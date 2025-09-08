
@import io.github.sosuisen.model.template.AlertMethodModel

@param AlertMethodModel model


    /**
     * Creates an instance of the builder,
     * then calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll(ButtonType... elements)} method
     * on the ObservableList returned by the {@link ${model.canonicalClassName()}#getButtonTypes() ${model.simpleClassName()}#getButtonTypes()} method.
     *
     * <p>
     * After calling this method, you may need to invoke the {@link ${model.builderClassNameWithTypeParameter()}#alertType(javafx.scene.control.Alert.AlertType) alertType(AlertType)} method.
     * If you do not, the default {@link javafx.scene.control.Alert.AlertType#NONE AlertType.NONE} will be set.
     * </p>
     *
     * @return builder instance
     */
    @SafeVarargs
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} withButtonTypes(javafx.scene.control.ButtonType... elements) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{javafx.scene.control.Alert.AlertType.NONE};
        return builder.addButtonTypes(elements);
    }

    /**
     * Creates an instance of the builder,
     * then calls the {@link java.util.List#addAll(java.util.Collection) setAll(Collection&lt;? extends ButtonType&gt; col} method
     * on the ObservableList returned by the {@link ${model.canonicalClassName()}#getButtonTypes() ${model.simpleClassName()}#getButtonTypes()} method.
     *
     * <p>
     * After calling this method, you may need to invoke the {@link ${model.builderClassNameWithTypeParameter()}#alertType(javafx.scene.control.Alert.AlertType) alertType(AlertType)} method.
     * If you do not, the default {@link javafx.scene.control.Alert.AlertType#NONE AlertType.NONE} will be set.
     * </p>
     *
     * @return builder instance
     */
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} withButtonTypes(java.util.Collection<? extends javafx.scene.control.ButtonType> col) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        builder.constructorArgs = new Object[]{javafx.scene.control.Alert.AlertType.NONE};
        return builder.addButtonTypes(col);
    }