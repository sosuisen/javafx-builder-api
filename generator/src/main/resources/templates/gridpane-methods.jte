@import io.github.sosuisen.model.template.GridPaneMethodModel

@param GridPaneMethodModel model


    /**
     * A builder method that invokes the {@link javafx.scene.layout.GridPane#add(javafx.scene.Node, int, int) add} method on the instance being constructed.
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} add(javafx.scene.Node child, int columnIndex, int rowIndex) {
        operations.add(obj -> obj.add(child, columnIndex, rowIndex));
        return this;
    }


    /**
     * A builder method that invokes the {@link javafx.scene.layout.GridPane#add(javafx.scene.Node, int, int, int, int) add} method on the instance being constructed.
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} add(javafx.scene.Node child, int columnIndex, int rowIndex, int colspan, int rowspan) {
        operations.add(obj -> obj.add(child, columnIndex, rowIndex, colspan, rowspan));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.scene.layout.GridPane#addRow(int, javafx.scene.Node[]) addRow} method on the instance being constructed.
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} addRow(int rowIndex, javafx.scene.Node... children) {
        operations.add(obj -> obj.addRow(rowIndex, children));
        return this;
    }

     /**
     * A builder method that invokes the {@link javafx.scene.layout.GridPane#addColumn(int, javafx.scene.Node[]) addColumn} method on the instance being constructed.     
     *
     * @return builder instance
     */
    public ${model.builderClassNameWithTypeParameter()} addColumn(int columnIndex, javafx.scene.Node... children)  {
        operations.add(obj -> obj.addColumn(columnIndex, children));
        return this;
    }
