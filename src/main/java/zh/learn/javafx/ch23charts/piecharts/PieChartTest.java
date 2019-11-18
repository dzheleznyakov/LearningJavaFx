package zh.learn.javafx.ch23charts.piecharts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PieChart chart = new PieChart();
        chart.setTitle("Population in 2000");
        chart.setLegendSide(Side.LEFT);

        ObservableList<PieChart.Data> chartData = PieChartUtil.getChartData();
        addData(chartData);
        chart.setData(chartData);

        addSliceTooltip(chart);

        Scene scene = new Scene(new StackPane(chart));
        scene.getStylesheets().add("css/additional_series_colors.css");

        stage.setScene(scene);
        stage.setTitle("A Pie Chart");
        stage.show();

        setSeriesColorStyles(chart);
    }

    private void addData(ObservableList<PieChart.Data> data) {
        data.add(new PieChart.Data("Bangladesh", 138));
        data.add(new PieChart.Data("Egypt", 68));
        data.add(new PieChart.Data("France", 59));
        data.add(new PieChart.Data("Germany", 82));
        data.add(new PieChart.Data("Indonesia", 212));
    }

    private void addSliceTooltip(PieChart chart) {
        double totalPieValue = 0.0;
        for (PieChart.Data datum : chart.getData()) {
            totalPieValue += datum.getPieValue();
        }

        for (PieChart.Data d : chart.getData()) {
            Node sliceNode = d.getNode();
            double pieValue = d.getPieValue();
            double percentPieValue = (pieValue / totalPieValue) * 100;

            String msg = d.getName() + "=" + pieValue +
                    " (" + String.format("%.2f", percentPieValue) + "%)";
            Tooltip tt = new Tooltip(msg);
            tt.setStyle("-fx-background-color: yellow;" +
                    "-fx-text-fill: black;");
            Tooltip.install(sliceNode, tt);
        }
    }

    private void setSeriesColorStyles(PieChart chart) {
        ObservableList<PieChart.Data> chartData = chart.getData();
        int size = chartData.size();
        for (int i = 0; i < size; i++) {
            String removedStyle = "default-color" + (i % 8);
            String addedStyle = "default-color" + (i % size);

            Node node = chartData.get(i).getNode();
            node.getStyleClass().remove(removedStyle);
            node.getStyleClass().add(addedStyle);

            String styleClass = ".pie-legend-symbol.data" + i +
                    ".default-color" + (i % 8);
            Node legendNode = chart.lookup(styleClass);
            if (legendNode != null) {
                legendNode.getStyleClass().remove(removedStyle);
                legendNode.getStyleClass().add(addedStyle);
            }
        }
    }
}
