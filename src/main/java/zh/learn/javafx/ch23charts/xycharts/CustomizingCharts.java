package zh.learn.javafx.ch23charts.xycharts;

import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import zh.learn.javafx.Aux;

public class CustomizingCharts extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Year");

        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1900);
        xAxis.setUpperBound(2300);
        xAxis.setTickUnit(50);

        xAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number n) {
                return String.valueOf(n.intValue());
            }

            @Override
            public Number fromString(String s) {
                return Integer.parseInt(s);
            }
        });

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population");

        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, "M"));

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Population by Year and Country");

        chart.setData(XYChartDataUtil.getCountrySeries());

        chart.setAlternativeColumnFillVisible(true);
        chart.setAlternativeRowFillVisible(false);

        chart.setHorizontalGridLinesVisible(false);
        chart.setVerticalGridLinesVisible(false);

        Aux.showStage(stage, new StackPane(chart), "Customizing Tick Labels and Chart Plot");
    }
}
