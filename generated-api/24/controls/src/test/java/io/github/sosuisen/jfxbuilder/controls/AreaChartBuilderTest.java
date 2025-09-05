package io.github.sosuisen.jfxbuilder.controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class AreaChartBuilderTest {

    @Test
    @DisplayName("Test withData method with varargs")
    void testWithDataVarargs() {
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<>("A", 10));
        series1.getData().add(new XYChart.Data<>("B", 20));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Series 2");
        series2.getData().add(new XYChart.Data<>("A", 15));
        series2.getData().add(new XYChart.Data<>("B", 25));

        AreaChartBuilder<String, Number> builder = AreaChartBuilder.withData(series1, series2);
        AreaChart<String, Number> chart = builder.build();

        assertNotNull(chart);
        assertEquals(2, chart.getData().size());
        assertEquals("Series 1", chart.getData().get(0).getName());
        assertEquals("Series 2", chart.getData().get(1).getName());
    }

    @Test
    @DisplayName("Test withData method with Collection")
    void testWithDataCollection() {
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<>("A", 10));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Series 2");
        series2.getData().add(new XYChart.Data<>("B", 20));

        @SuppressWarnings("unchecked")
        ObservableList<XYChart.Series<String, Number>> seriesList =
            FXCollections.observableArrayList(series1, series2);

        AreaChartBuilder<String, Number> builder = AreaChartBuilder.withData(seriesList);
        AreaChart<String, Number> chart = builder.build();

        assertNotNull(chart);
        assertEquals(2, chart.getData().size());
        assertEquals("Series 1", chart.getData().get(0).getName());
        assertEquals("Series 2", chart.getData().get(1).getName());
    }

    @Test
    @DisplayName("Test xAxis method")
    void testXAxis() {
        NumberAxis customXAxis = new NumberAxis();
        customXAxis.setLabel("Custom X Axis");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 10));

        AreaChartBuilder<Number, Number> builder = AreaChartBuilder.withData(series)
            .xAxis(customXAxis);
        AreaChart<Number, Number> chart = builder.build();

        assertNotNull(chart);
        assertEquals(customXAxis, chart.getXAxis());
        assertEquals("Custom X Axis", chart.getXAxis().getLabel());

        // Verify default axis types
        assertTrue(
            chart.getYAxis() instanceof NumberAxis,
            "Default yAxis should be NumberAxis"
        );
    }

    @Test
    @DisplayName("Test yAxis method")
    void testYAxis() {
        NumberAxis customYAxis = new NumberAxis();
        customYAxis.setLabel("Custom Y Axis");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("category A", 10));

        AreaChartBuilder<String, Number> builder = AreaChartBuilder.withData(series)
            .yAxis(customYAxis);
        AreaChart<String, Number> chart = builder.build();

        assertNotNull(chart);
        assertEquals(customYAxis, chart.getYAxis());
        assertEquals("Custom Y Axis", chart.getYAxis().getLabel());

        // Verify default axis types
        assertTrue(
            chart.getXAxis() instanceof CategoryAxis,
            "Default xAxis should be CategoryAxis"
        );
    }

    @Test
    @DisplayName("Test xAxis and yAxis methods together")
    void testXAxisAndYAxisTogether() {
        NumberAxis customXAxis = new NumberAxis();
        customXAxis.setLabel("Custom X Axis");
        NumberAxis customYAxis = new NumberAxis();
        customYAxis.setLabel("Custom Y Axis");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 10));
        series.getData().add(new XYChart.Data<>(2, 20));

        AreaChartBuilder<Number, Number> builder = AreaChartBuilder.withData(series)
            .xAxis(customXAxis)
            .yAxis(customYAxis);
        AreaChart<Number, Number> chart = builder.build();

        assertNotNull(chart);
        assertEquals(customXAxis, chart.getXAxis());
        assertEquals(customYAxis, chart.getYAxis());
        assertEquals("Custom X Axis", chart.getXAxis().getLabel());
        assertEquals("Custom Y Axis", chart.getYAxis().getLabel());
        assertEquals(1, chart.getData().size());
    }

    @Test
    @DisplayName("Test inferred xAxis and yAxis types - String and Number")
    void testInferredAxesTypesStringAndNumber() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Test Series");
        series.getData().add(new XYChart.Data<>("A", 10));
        series.getData().add(new XYChart.Data<>("B", 20));

        AreaChartBuilder<String, Number> builder = AreaChartBuilder.withData(series);
        AreaChart<String, Number> chart = builder.build();

        assertNotNull(chart);
        assertNotNull(chart.getXAxis());
        assertNotNull(chart.getYAxis());

        // Axis types are inferred from given Data<X, Y>
        assertTrue(
            chart.getXAxis() instanceof CategoryAxis,
            "Inferred xAxis type should be CategoryAxis"
        );
        assertTrue(
            chart.getYAxis() instanceof NumberAxis,
            "Inferred yAxis should be NumberAxis"
        );
    }

    @Test
    @DisplayName("Test inferred xAxis and yAxis types - Number and String")
    void testInferredAxesTypesNumberAndString() {
        XYChart.Series<Number, String> series = new XYChart.Series<>();
        series.setName("Test Series");
        series.getData().add(new XYChart.Data<>(10, "A"));
        series.getData().add(new XYChart.Data<>(20, "B"));

        AreaChartBuilder<Number, String> builder = AreaChartBuilder.withData(series);
        AreaChart<Number, String> chart = builder.build();

        assertNotNull(chart);
        assertNotNull(chart.getXAxis());
        assertNotNull(chart.getYAxis());

        // Axis types are inferred from given Data<X, Y>
        assertTrue(
            chart.getXAxis() instanceof NumberAxis,
            "Inferred yAxis should be NumberAxis"
        );
        assertTrue(
            chart.getYAxis() instanceof CategoryAxis,
            "Inferred xAxis should be CategoryAxis"
        );
    }

    @Test
    @DisplayName("Test inferred xAxis and yAxis types - Number and Number")
    void testInferredAxesTypesNumberAndNumber() {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Test Series");
        series.getData().add(new XYChart.Data<>(10, 3));
        series.getData().add(new XYChart.Data<>(20, 7));

        AreaChartBuilder<Number, Number> builder = AreaChartBuilder.withData(series);
        AreaChart<Number, Number> chart = builder.build();

        assertNotNull(chart);
        assertNotNull(chart.getXAxis());
        assertNotNull(chart.getYAxis());

        // Axis types are inferred from given Data<X, Y>
        assertTrue(
            chart.getXAxis() instanceof NumberAxis,
            "Inferred yAxis should be NumberAxis"
        );
        assertTrue(
            chart.getYAxis() instanceof NumberAxis,
            "Inferred yAxis should be NumberAxis"
        );
    }

    @Test
    @DisplayName("Test inferred xAxis and yAxis types - Default")
    void testInferredAxesTypesDefault() {
        XYChart.Series series = new XYChart.Series<>();
        series.setName("Test Series");

        AreaChartBuilder builder = AreaChartBuilder.withData(series);
        AreaChart chart = builder.build();

        assertNotNull(chart);
        assertNotNull(chart.getXAxis());
        assertNotNull(chart.getYAxis());

        // Axis types are default as the Series does not have Data<X, Y>.
        assertTrue(
            chart.getXAxis() instanceof CategoryAxis,
            "Inferred xAxis type should be CategoryAxis"
        );
        assertTrue(
            chart.getYAxis() instanceof NumberAxis,
            "Inferred yAxis should be NumberAxis"
        );
    }

    @Test
    @DisplayName("Test inferred xAxis and yAxis types with Collecction - Number and String")
    void testInferredAxesTypesWithCollectionNumberAndString() {
        XYChart.Series<Number, String> series1 = new XYChart.Series<>();
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<>(10, "A"));

        XYChart.Series<Number, String> series2 = new XYChart.Series<>();
        series2.setName("Series 2");
        series2.getData().add(new XYChart.Data<>(20, "B"));

        @SuppressWarnings("unchecked")
        ObservableList<XYChart.Series<Number, String>> seriesList =
            FXCollections.observableArrayList(series1, series2);

        AreaChartBuilder<Number, String> builder = AreaChartBuilder.withData(seriesList);
        AreaChart<Number, String> chart = builder.build();

        assertNotNull(chart);
        assertNotNull(chart.getXAxis());
        assertNotNull(chart.getYAxis());

        // Axis types are inferred from given Data<X, Y>
        assertTrue(
            chart.getXAxis() instanceof NumberAxis,
            "Inferred yAxis should be NumberAxis"
        );
        assertTrue(
            chart.getYAxis() instanceof CategoryAxis,
            "Inferred xAxis should be CategoryAxis"
        );
    }

}
