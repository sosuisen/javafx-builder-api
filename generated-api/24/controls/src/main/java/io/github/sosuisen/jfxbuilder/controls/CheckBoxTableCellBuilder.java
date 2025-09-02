
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code CheckBoxTableCellBuilder} class constructs instances of the {@link javafx.scene.control.cell.CheckBoxTableCell CheckBoxTableCell} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.cell.CheckBoxTableCell CheckBoxTableCell} constructor
 * and returns an instance of the {@code CheckBoxTableCellBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.cell.CheckBoxTableCell CheckBoxTableCell}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.cell.CheckBoxTableCell CheckBoxTableCell} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class CheckBoxTableCellBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.cell.CheckBoxTableCell<S, T>>> operations = new java.util.ArrayList<>();
    private CheckBoxTableCellBuilder() {}
    

    public static <S, T> CheckBoxTableCellBuilder<S, T> create() { return new CheckBoxTableCellBuilder<S, T>(); }


    
    public static <S, T> CheckBoxTableCellBuilder<S, T> create(javafx.util.Callback<java.lang.Integer, javafx.beans.value.ObservableValue<java.lang.Boolean>> getSelectedProperty) {
        CheckBoxTableCellBuilder<S, T> builder = new CheckBoxTableCellBuilder<S, T>();
        builder.constructorArgs = new Object[]{getSelectedProperty};
        return builder;
    }


    
    public static <S, T> CheckBoxTableCellBuilder<S, T> create(javafx.util.Callback<java.lang.Integer, javafx.beans.value.ObservableValue<java.lang.Boolean>> getSelectedProperty, javafx.util.StringConverter<T> converter) {
        CheckBoxTableCellBuilder<S, T> builder = new CheckBoxTableCellBuilder<S, T>();
        builder.constructorArgs = new Object[]{getSelectedProperty, converter};
        return builder;
    }

    private Object[] constructorArgs;

    /**
     * This method builds and returns an instance of the original class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the build() method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.control.cell.CheckBoxTableCell CheckBoxTableCell} class
     */
    public javafx.scene.control.cell.CheckBoxTableCell<S, T> build() {
        javafx.scene.control.cell.CheckBoxTableCell<S, T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.cell.CheckBoxTableCell<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.cell.CheckBoxTableCell<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.cell.CheckBoxTableCell<S, T> callParameterizedConstructor() {
        javafx.scene.control.cell.CheckBoxTableCell<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.cell.CheckBoxTableCell.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.cell.CheckBoxTableCell<S, T>) constructor.newInstance(constructorArgs);
                    break;
                }
            }
            if (newInstance == null) {
                throw new RuntimeException("No suitable constructor found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance", e);
        }

        return newInstance;
    }

    
    private static boolean isConstructorCompatible(java.lang.reflect.Constructor<?> constructor, Object[] args) {
        Class<?>[] paramTypes = constructor.getParameterTypes();
        if (paramTypes.length != args.length) return false;
        
        for (int i = 0; i < paramTypes.length; i++) {
            if (args[i] != null) {
                Class<?> paramType = paramTypes[i];
                Class<?> argType = args[i].getClass();
                
                // Check if argument type is assignable to parameter type
                if (!paramType.isAssignableFrom(argType)) {
                    // Handle primitive types
                    if (paramType.isPrimitive()) {
                        if (!isPrimitiveCompatible(paramType, argType)) {
                            return false;
                        }
                    } else if (argType.isPrimitive()) {
                        if (!isPrimitiveCompatible(argType, paramType)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean isPrimitiveCompatible(Class<?> primitiveType, Class<?> wrapperType) {
        if (primitiveType == boolean.class) return wrapperType == Boolean.class;
        if (primitiveType == byte.class) return wrapperType == Byte.class;
        if (primitiveType == char.class) return wrapperType == Character.class;
        if (primitiveType == short.class) return wrapperType == Short.class;
        if (primitiveType == int.class) return wrapperType == Integer.class;
        if (primitiveType == long.class) return wrapperType == Long.class;
        if (primitiveType == float.class) return wrapperType == Float.class;
        if (primitiveType == double.class) return wrapperType == Double.class;
        return false;
    }
    /**
     * Applies a function to the CheckBoxTableCell instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(checkBoxTableCell -> checkBoxTableCell.setId("Main" + checkBoxTableCell.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public CheckBoxTableCellBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.cell.CheckBoxTableCell<S, T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setConverter(javafx.util.StringConverter)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> converter(javafx.util.StringConverter<T> value) {
        operations.add(obj -> obj.setConverter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setItem(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> item(T value) {
        operations.add(obj -> obj.setItem(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setSelectedStateCallback(javafx.util.Callback)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> selectedStateCallback(javafx.util.Callback<java.lang.Integer, javafx.beans.value.ObservableValue<java.lang.Boolean>> value) {
        operations.add(obj -> obj.setSelectedStateCallback(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.CheckBoxTableCell#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  CheckBoxTableCellBuilder<S, T> wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.CheckBoxTableCell#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final CheckBoxTableCellBuilder<S, T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.CheckBoxTableCell#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final CheckBoxTableCellBuilder<S, T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.CheckBoxTableCell#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final CheckBoxTableCellBuilder<S, T> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.CheckBoxTableCell#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final CheckBoxTableCellBuilder<S, T> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.CheckBoxTableCell#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final CheckBoxTableCellBuilder<S, T> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.CheckBoxTableCell#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final CheckBoxTableCellBuilder<S, T> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this CheckBoxTableCell's contents.
     * For example:
     * <pre>
     * CheckBoxTableCellBuilder builder = CheckBoxTableCellBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public CheckBoxTableCellBuilder<S, T> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public CheckBoxTableCellBuilder<S, T> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public CheckBoxTableCellBuilder<S, T> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#converterProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<T>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#editingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> editingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#emptyProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> emptyPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.emptyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#indexProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> indexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.indexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#itemProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> itemPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.itemProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#selectedStateCallbackProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> selectedStateCallbackPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<java.lang.Integer, javafx.beans.value.ObservableValue<java.lang.Boolean>>>> op) {
        operations.add(obj -> op.accept(obj.selectedStateCallbackProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#tableColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> tableColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumn<S, T>>> op) {
        operations.add(obj -> op.accept(obj.tableColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#tableRowProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> tableRowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableRow<S>>> op) {
        operations.add(obj -> op.accept(obj.tableRowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#tableViewProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> tableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableView<S>>> op) {
        operations.add(obj -> op.accept(obj.tableViewProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.CheckBoxTableCell#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public CheckBoxTableCellBuilder<S, T> wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
