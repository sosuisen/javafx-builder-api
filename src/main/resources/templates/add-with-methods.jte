@import io.github.sosuisen.template.AddWithMethodModel

@param AddWithMethodModel model

    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link ${model.originalClassName()}#${model.getterMethodName()}()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final ${model.builderClassNameWithTypeParameter()} ${model.addMethodName()}(${model.observableListTypeParameter()}... elements) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link ${model.originalClassName()}#${model.getterMethodName()}()} method.
     * 
     * @return builder instance
     */     
    public final ${model.builderClassNameWithTypeParameter()} ${model.addMethodName()}(java.util.Collection<? extends ${model.observableListTypeParameter()}> col) {
        operations.add(obj -> {
            obj.${model.getterMethodName()}().addAll(col);
        });
        return this;
    }

@if(model.hasWithMethod())
    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link ${model.originalClassName()}#${model.getterMethodName()}()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} ${model.withMethodName()}(${model.observableListTypeParameter()}... elements) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        return builder.${model.addMethodName()}(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link ${model.originalClassName()}#${model.getterMethodName()}()} method.
     * 
     * @return builder instance
     */     
    public static ${model.typeParametersWithExtends().isEmpty() ? "" : model.typeParametersWithExtends() + " "}${model.builderClassNameWithTypeParameter()} ${model.withMethodName()}(java.util.Collection<? extends ${model.observableListTypeParameter()}> col) {
        ${model.builderClassNameWithTypeParameter()} builder = new ${model.builderClassNameWithTypeParameter()}();
        return builder.${model.addMethodName()}(col);
    }
@endif
