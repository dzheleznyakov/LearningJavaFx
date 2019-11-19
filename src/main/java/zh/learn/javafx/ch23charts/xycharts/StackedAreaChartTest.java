package zh.learn.javafx.ch23charts.xycharts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StackedAreaChartTest extends Application {
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

        StackedAreaChart<Number, Number> chart = new StackedAreaChart<>(xAxis, yAxis);
        chart.setTitle("Population by Year and Country");

        ObservableList<XYChart.Series<Number, Number>> chartData = XYChartDataUtil.getCountrySeries();
        chart.setData(chartData);

        Aux.showStage(stage, new StackPane(chart), "A Stacked Area Chart");
    }
}
