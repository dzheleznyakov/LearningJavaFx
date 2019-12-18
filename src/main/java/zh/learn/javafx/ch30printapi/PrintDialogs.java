package zh.learn.javafx.ch30printapi;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class PrintDialogs extends Application {
    private final Label jobStatus = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label textLbl = new Label("Text:");
        TextArea text = new TextArea();
        text.setPrefRowCount(10);
        text.setPrefColumnCount(20);
        text.setWrapText(true);

        Button pageSetupBtn = new Button("Page Setup and Print");
        pageSetupBtn.setOnAction(e -> pageSetup(text, stage));

        Button printSetupBtn = new Button("Print Setup and Print");
        printSetupBtn.setOnAction(e -> printSetup(text, stage));

        HBox jobStatusBox = new HBox(5, new Label("Print Job Status:"), jobStatus);
        HBox buttonBox = new HBox(5, pageSetupBtn, printSetupBtn);

        VBox root = new VBox(5, textLbl, text, jobStatusBox, buttonBox);
        Aux.showStage(stage, root, "Showing Print Dialogs");
    }

    private void pageSetup(Node node, Stage owner) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job == null) {
            return;
        }

        boolean proceed = job.showPageSetupDialog(owner);
        if (proceed) {
            print(job, node);
        }
    }

    private void printSetup(Node node, Stage owner) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job == null) {
            return;
        }

        boolean proceed = job.showPrintDialog(owner);
        if (proceed) {
            print(job, node);
        }
    }

    private void print(PrinterJob job, Node node) {
        jobStatus.textProperty().bind(job.jobStatusProperty().asString());

        boolean printed = job.printPage(node);
        if (printed) {
            job.endJob();
        }
    }
}
