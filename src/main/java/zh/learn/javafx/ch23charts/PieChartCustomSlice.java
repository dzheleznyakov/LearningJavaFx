package zh.learn.javafx.ch23charts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartCustomSlice extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PieChart chart = new PieChart();
        chart.setTitle("Population in 200");

        chart.setLegendSide(Side.LEFT);

        ObservableList<PieChart.Data> chartData = PieChartUtil.getChartData();
        chart.setData(chartData);

        StackPane root = new StackPane(chart);
        Scene scene = new Scene(root);

        scene.getStylesheets().addAll("css/pie_slice.css");

        stage.setScene(scene);
        stage.setTitle("Custom Pie Slices");
        stage.show();
    }
}
