package zh.learn.javafx.ch27concurrency.workers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class PrimeFinderTask extends Task<ObservableList<Long>> {
    private final long lowerLimit;
    private final long upperLimit;
    private final long sleepTimeInMillis;

    public PrimeFinderTask() {
        this(1L, 30L, 500L);
    }

    public PrimeFinderTask(long lowerLimit, long upperLimit) {
        this(lowerLimit, upperLimit, 500L);
    }

    public PrimeFinderTask(long lowerLimit, long upperLimit, long sleepTimeInMillis) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    protected ObservableList<Long> call() throws Exception {
        final ObservableList<Long> results = FXCollections.observableArrayList();

        updateTitle("Prime Number Finder Task");

        long count = upperLimit - lowerLimit + 1;
        long counter = 0;
        for (long i = lowerLimit; i <= upperLimit; i++) {
            if (isCancelled()) {
                break;
            }

            ++counter;

            updateMessage("Checking " + i + " for a prime number");

            try {
                Thread.sleep(sleepTimeInMillis);
            } catch (InterruptedException e) {
                if (this.isCancelled()) {
                    break;
                }
            }

            if (PrimeUtil.isPrime(i)) {
                results.add(i);
                updateValue(FXCollections.<Long>unmodifiableObservableList(results));
            }
            updateProgress(counter, count);
        }
        return results;
    }

    @Override
    protected void cancelled() {
        super.cancelled();
        updateMessage("The task was cancelled.");
    }

    @Override
    protected void failed() {
        super.failed();
        updateMessage("The task failed.");
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        updateMessage("The task finished successfully.");
    }
}
