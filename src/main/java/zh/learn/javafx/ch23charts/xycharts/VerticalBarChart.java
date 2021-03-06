package zh.learn.javafx.ch23charts.xycharts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class VerticalBarChart extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (in millions)");

        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Population by Country and Year");

        ObservableList<XYChart.Series<String, Number>> chartData = XYChartDataUtil.getYearSeries();
        chart.setData(chartData);

        Aux.showStage(stage, new StackPane(chart), "A Vertical Bar Chart");
    }
}
