package zh.learn.javafx.ch03collections.lists;

import javafx.collections.ListChangeListener;

import java.util.List;

public class PersonListChangeListener implements ListChangeListener<Person> {
    @Override
    public void onChanged(Change<? extends Person> change) {
        while (change.next()) {
            if (change.wasPermutated()) {
                handlePermutated(change);
            } else if (change.wasUpdated()) {
                handleUpdated(change);
            } else if (change.wasReplaced()) {
                handleReplaced(change);
            } else {
                if (change.wasRemoved()) {
                    handleRemoved(change);
                } else if (change.wasAdded()) {
                    handleAdded(change);
                }
            }
        }
    }

    private void handlePermutated(Change<? extends Person> change) {
        System.out.println("Change Type: Permutated");
        System.out.println("Permutated Range: " + getRangeText(change));
        int start = change.getFrom();
        int end = change.getTo();
        for (int oldIndex = start; oldIndex < end; oldIndex++) {
            int newIndex = change.getPermutation(oldIndex);
            System.out.println("index[" + oldIndex + "] moved to index[" + newIndex + "]");
        }
    }

    private void handleUpdated(Change<? extends Person> change) {
        System.out.println("Change Type: Updated");
        System.out.println("Updated Range: " + getRangeText(change));
        System.out.println("Updated elements are: " + change.getList().subList(change.getFrom(), change.getTo()));
    }

    private void handleReplaced(Change<? extends Person> change) {
        System.out.println("Change Type: Replaced");
        handleRemoved(change);
        handleAdded(change);
    }

    private void handleRemoved(Change<? extends Person> change) {
        System.out.println("Change Type: Removed");

        int removedSize = change.getRemovedSize();
        List<? extends Person> sublist = change.getRemoved();

        System.out.println("Removed Size: " + removedSize);
        System.out.println("Removed Range: " + getRangeText(change));
        System.out.println("Removed List: " + sublist);
    }

    private void handleAdded(Change<? extends Person> change) {
        System.out.println("Change Type: Added");

        int addedSize = change.getAddedSize();
        List<? extends Person> subList = change.getAddedSubList();

        System.out.println("Added Size: " + addedSize);
        System.out.println("Added Range: " + getRangeText(change));
        System.out.println("Added List: " + subList);
    }

    private String getRangeText(Change<? extends Person> change) {
        return "[" + change.getFrom() + ", " + change.getTo() + "]";
    }
}
