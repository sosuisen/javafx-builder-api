@import io.github.sosuisen.model.template.XYChartMethodModel

@param XYChartMethodModel model


    /**
     * Creates an instance of the builder,
     * then calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll(XYChart.Series&lt;X, Y&gt;... elements)} method
     * on the ObservableList returned by the {@link ${model.canonicalClassName()}#getData() ${model.simpleClassName()}#getData()} method.
     *
     * <p>
     * After calling this method, you may need to invoke the {@link ${model.canonicalBuilderClassName()}#xAxis(javafx.scene.chart.Axis) xAxis(Axis)} and {@link ${model.canonicalBuilderClassName()}#yAxis(javafx.scene.chart.Axis) yAxis(Axis)} methods. 
     * If you do not, the default axis objects will be set for the x-axis and y-axis.
     * </p>
     *
     * <p>
     * The default axis classes are inferred from the type parameters of XYChart.Data objects contained in the XYChart.Series passed to the withData method.
     * If the type is String, the axis object is created using new {@link javafx.scene.chart.CategoryAxis CategoryAxis}(). If it's Number, it is created using new {@link javafx.scene.chart.NumberAxis NumberAxis}(). 
     * When there are no Data objects, the default x-axis object is created using new CategoryAxis() and the default y-axis object is created using new NumberAxis().
     * </p>
     *
     * @return builder instance
     */
    @SafeVarargs
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} withData(javafx.scene.chart.XYChart.Series<X, Y>... elements) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{new javafx.scene.chart.CategoryAxis(), new javafx.scene.chart.NumberAxis()};
        if (elements != null && elements.length > 0) {
            javafx.scene.chart.XYChart.Series<X, Y> series = elements[0];
            setDefaultConstructorArgs(builder, series);
        }        
        return builder.addData(elements);
    }

    /**
     * Creates an instance of the builder,
     * then calls the {@link java.util.List#addAll(java.util.Collection) addAll(Collection&lt;? extends XYChart.Series&lt;X, Y&gt;&gt; col} method
     * on the ObservableList returned by the {@link ${model.canonicalClassName()}#getData() ${model.simpleClassName()}#getData()} method.
     *
     * <p>
     * After calling this method, you may need to invoke the {@link ${model.canonicalBuilderClassName()}#xAxis(javafx.scene.chart.Axis) xAxis(Axis)} and {@link ${model.canonicalBuilderClassName()}#yAxis(javafx.scene.chart.Axis) yAxis(Axis)} methods. 
     * If you do not, the default axis objects will be set for the x-axis and y-axis.
     * </p>
     *
     * <p>
     * The default axis classes are inferred from the type parameters of XYChart.Data objects contained in the XYChart.Series passed to the withData method.
     * If the type is String, the axis object is created using new {@link javafx.scene.chart.CategoryAxis CategoryAxis}(). If it's Number, it is created using new {@link javafx.scene.chart.NumberAxis NumberAxis}(). 
     * When there are no Data objects, the default x-axis object is created using new CategoryAxis() and the default y-axis object is created using new NumberAxis().
     * </p>
     *
     * @return builder instance
     */
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} withData(java.util.Collection<? extends javafx.scene.chart.XYChart.Series<X, Y>> col) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{new javafx.scene.chart.CategoryAxis(), new javafx.scene.chart.NumberAxis()};
        if (col != null && !col.isEmpty()) {
            javafx.scene.chart.XYChart.Series<X, Y> series = col.iterator().next();
            setDefaultConstructorArgs(builder, series);
        }        
        return builder.addData(col);
    }

    private static <X, Y> void setDefaultConstructorArgs(${model.builderClassNameWithTypeParameter()} builder,
        javafx.scene.chart.XYChart.Series<X, Y> series) {
        builder.constructorArgs = new Object[2];

        if (!series.getData().isEmpty()) {
            javafx.scene.chart.XYChart.Data<X, Y> data = series.getData().get(0);
            if (data.getXValue() instanceof java.lang.String) {
                builder.constructorArgs[0] = new javafx.scene.chart.CategoryAxis();
            } else if (data.getXValue() instanceof java.lang.Number) {
                builder.constructorArgs[0] = new javafx.scene.chart.NumberAxis();
            } else {
                builder.constructorArgs[0] = new javafx.scene.chart.CategoryAxis();
            }
            if (data.getYValue() instanceof java.lang.String) {
                builder.constructorArgs[1] = new javafx.scene.chart.CategoryAxis();
            } else if (data.getYValue() instanceof java.lang.Number) {
                builder.constructorArgs[1] = new javafx.scene.chart.NumberAxis();
            } else {
                builder.constructorArgs[1] = new javafx.scene.chart.NumberAxis();
            }
            return;
        }
        builder.constructorArgs[0] = new javafx.scene.chart.CategoryAxis();
        builder.constructorArgs[1] = new javafx.scene.chart.NumberAxis();
    }

    /**
     * A builder method that set xAxis object to the instance being constructed.
     * This method is used together with the {@link ${model.canonicalBuilderClassName()}#withData(javafx.scene.chart.XYChart.Series...) withData(Series...)} or the {@link ${model.canonicalBuilderClassName()}#withData(java.util.Collection col) withData(Collection)}.
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} xAxis(javafx.scene.chart.Axis<X> axis) {
        if(constructorArgs.length > 0)
            constructorArgs[0] = axis;
        return this;
    }

    /**
     * A builder method that set yAxis object to the instance being constructed.
     * This method is used together with the {@link ${model.canonicalBuilderClassName()}#withData(javafx.scene.chart.XYChart.Series...) withData(Series...)} or the {@link ${model.canonicalBuilderClassName()}#withData(java.util.Collection col) withData(Collection)}.
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} yAxis(javafx.scene.chart.Axis<Y> axis) {
        if(constructorArgs.length > 1)
            constructorArgs[1] = axis;
        return this;
    }