@import io.github.sosuisen.template.GridPaneMethodModel

@param GridPaneMethodModel model


    /**
     * Adds a child to the gridpane at the specified [column, row] position.
     * This convenience method will set the gridpane column and row constraints
     * on the child.
     * @param child the node being added to the gridpane
     * @param columnIndex the column index position for the child within the gridpane, counting from 0
     * @param rowIndex the row index position for the child within the gridpane, counting from 0
     */
    public ${model.builderClassNameWithTypeParameter()} add(javafx.scene.Node child, int columnIndex, int rowIndex) {
        operations.add(obj -> {
            obj.add(child, columnIndex, rowIndex);
        });
        return this;
    }


    /**
     * Adds a child to the gridpane at the specified [column, row] position and spans.
     * This convenience method will set the gridpane column, row, and span constraints
     * on the child.
     * @param child the node being added to the gridpane
     * @param columnIndex the column index position for the child within the gridpane, counting from 0
     * @param rowIndex the row index position for the child within the gridpane, counting from 0
     * @param colspan the number of columns the child's layout area should span
     * @param rowspan the number of rows the child's layout area should span
     */
    public ${model.builderClassNameWithTypeParameter()} add(javafx.scene.Node child, int columnIndex, int rowIndex, int colspan, int rowspan) {
        operations.add(obj -> {
            obj.add(child, columnIndex, rowIndex, colspan, rowspan);
        });
        return this;
    }

    /**
     * Convenience method for placing the specified nodes sequentially in a given
     * row of the gridpane.    If the row already contains nodes the specified nodes
     * will be appended to the row.  For example, the first node will be positioned at [column,row],
     * the second at [column+1,row], etc.   This method will set the appropriate gridpane
     * row/column constraints on the nodes as well as add the nodes to the gridpane's
     * children sequence.
     *
     * @param rowIndex the row index position for the children within the gridpane
     * @param children the nodes to be added as a row in the gridpane
     */
    public ${model.builderClassNameWithTypeParameter()} addRow(int rowIndex, javafx.scene.Node... children) {
        operations.add(obj -> {
            obj.addRow(rowIndex, children);
        });
        return this;
    }

     /**
     * Convenience method for placing the specified nodes sequentially in a given
     * column of the gridpane.    If the column already contains nodes the specified nodes
     * will be appended to the column.  For example, the first node will be positioned at [column, row],
     * the second at [column, row+1], etc.   This method will set the appropriate gridpane
     * row/column constraints on the nodes as well as add the nodes to the gridpane's
     * children sequence.
     *
     * @param columnIndex the column index position for the children within the gridpane
     * @param children the nodes to be added as a column in the gridpane
     */
    public ${model.builderClassNameWithTypeParameter()} addColumn(int columnIndex, javafx.scene.Node... children)  {
        operations.add(obj -> {
            obj.addColumn(columnIndex, children);
        });
        return this;
    }

    /**
     * Add column constraints. Column constraints can be added to
     * explicitly control individual column sizing and layout behavior.
     * If not set, column sizing and layout behavior is computed based on content.
     *
     * The argument order corresponds to the column order.
     * 
     * @param constraints column constraints
     */
    public ${model.builderClassNameWithTypeParameter()} columnConstraints(javafx.scene.layout.ColumnConstraints... constraints) {
        operations.add(obj -> 
            java.util.Arrays.stream(constraints)
                  .forEach(obj.getColumnConstraints()::add)
        );
        return this;
    }

    /**
     * Add row constraints. Row constraints can be added to
     * explicitly control individual row sizing and layout behavior.
     * If not set, row sizing and layout behavior is computed based on content.
     *
     * The argument order corresponds to the row order.
     * 
     * @param constraints row constraints
     */
    public ${model.builderClassNameWithTypeParameter()} rowConstraints(javafx.scene.layout.RowConstraints... constraints) {
        operations.add(obj -> 
            java.util.Arrays.stream(constraints)
                  .forEach(obj.getRowConstraints()::add)
        );
        return this;
    }
