package zh.learn.javafx.ch23charts.xycharts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class HorizontalBarChart extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Population (in millions)");

        CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Country");

        BarChart<Number, String> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Population by Country and Year");

        ObservableList<XYChart.Series<Number, String>> chartData = getChartData(XYChartDataUtil.getYearSeries());
        chart.setData(chartData);

        Aux.showStage(stage, new StackPane(chart), "A Horizontal Bar Chart");
    }

    private ObservableList<XYChart.Series<Number, String>> getChartData(
            ObservableList<XYChart.Series<String, Number>> oldData) {
        ObservableList<XYChart.Series<Number, String>> newData = FXCollections.observableArrayList();

        for (XYChart.Series<String, Number> oldSeries : oldData) {
            XYChart.Series<Number, String> newSeries = new XYChart.Series<>();
            newSeries.setName(oldSeries.getName());

            for (XYChart.Data<String, Number> oldItem : oldSeries.getData()) {
                XYChart.Data<Number, String> newItem = new XYChart.Data<>(oldItem.getYValue(), oldItem.getXValue());
                newSeries.getData().add(newItem);
            }
            newData.add(newSeries);
        }
        return newData;
    }
}
