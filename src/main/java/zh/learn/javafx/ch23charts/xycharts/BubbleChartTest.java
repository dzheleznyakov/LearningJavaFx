package zh.learn.javafx.ch23charts.xycharts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class BubbleChartTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Year");

        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1900);
        xAxis.setUpperBound(2300);
        xAxis.setTickUnit(50);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (in millions)");

        BubbleChart<Number, Number> chart = new BubbleChart<>(xAxis, yAxis);
        chart.setTitle("Population by Year and Country");

        ObservableList<XYChart.Series<Number, Number>> chartData = XYChartDataUtil.getCountrySeries();

        setBubbleRadius(chartData);

        chart.setData(chartData);

        Aux.showStage(stage, new StackPane(chart), "A Bubble Chart");
    }

    private void setBubbleRadius(ObservableList<XYChart.Series<Number, Number>> chartData) {
        for (XYChart.Series<Number, Number> series : chartData) {
            for (XYChart.Data<Number, Number> datum : series.getData()) {
                datum.setExtraValue(20);
            }
        }
    }
}
