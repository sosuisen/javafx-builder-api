
package io.github.sosuisen.jfxbuilder.controls;

/**
 * The {@code ComboBoxTableCellBuilder} class constructs instances of the {@link javafx.scene.control.cell.ComboBoxTableCell ComboBoxTableCell} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.control.cell.ComboBoxTableCell ComboBoxTableCell} constructor
 * and returns an instance of the {@code ComboBoxTableCellBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.control.cell.ComboBoxTableCell ComboBoxTableCell}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.control.cell.ComboBoxTableCell ComboBoxTableCell} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class ComboBoxTableCellBuilder<S, T> {
    private java.util.List<java.util.function.Consumer<javafx.scene.control.cell.ComboBoxTableCell<S, T>>> operations = new java.util.ArrayList<>();
    private ComboBoxTableCellBuilder() {}
    

    public static <S, T> ComboBoxTableCellBuilder<S, T> create() { return new ComboBoxTableCellBuilder<S, T>(); }


    @SafeVarargs
    public static <S, T> ComboBoxTableCellBuilder<S, T> create(T... items) {
        ComboBoxTableCellBuilder<S, T> builder = new ComboBoxTableCellBuilder<S, T>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }


    
    public static <S, T> ComboBoxTableCellBuilder<S, T> create(javafx.collections.ObservableList<T> items) {
        ComboBoxTableCellBuilder<S, T> builder = new ComboBoxTableCellBuilder<S, T>();
        builder.constructorArgs = new Object[]{items};
        return builder;
    }


    @SafeVarargs
    public static <S, T> ComboBoxTableCellBuilder<S, T> create(javafx.util.StringConverter<T> converter, T... items) {
        ComboBoxTableCellBuilder<S, T> builder = new ComboBoxTableCellBuilder<S, T>();
        builder.constructorArgs = new Object[]{converter, items};
        return builder;
    }


    
    public static <S, T> ComboBoxTableCellBuilder<S, T> create(javafx.util.StringConverter<T> converter, javafx.collections.ObservableList<T> items) {
        ComboBoxTableCellBuilder<S, T> builder = new ComboBoxTableCellBuilder<S, T>();
        builder.constructorArgs = new Object[]{converter, items};
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
     * @return new instance of the {@link javafx.scene.control.cell.ComboBoxTableCell ComboBoxTableCell} class
     */
    public javafx.scene.control.cell.ComboBoxTableCell<S, T> build() {
        javafx.scene.control.cell.ComboBoxTableCell<S, T> newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.control.cell.ComboBoxTableCell<>();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.control.cell.ComboBoxTableCell<S, T>> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    @SuppressWarnings("unchecked")

    private javafx.scene.control.cell.ComboBoxTableCell<S, T> callParameterizedConstructor() {
        javafx.scene.control.cell.ComboBoxTableCell<S, T> newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.control.cell.ComboBoxTableCell.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.control.cell.ComboBoxTableCell<S, T>) constructor.newInstance(constructorArgs);
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
     * Applies a function to the ComboBoxTableCell instance currently being built.
     * Most operations on the instance can be performed using this method.
     *
     * <p>Example usage:</p>     
     * <pre>{@code
     * apply(comboBoxTableCell -> comboBoxTableCell.setId("Main" + comboBoxTableCell.getTypeSelector()))
     * }</pre>
     *
     * @return builder instance
     *
     */
    public ComboBoxTableCellBuilder<S, T> apply(java.util.function.Consumer<javafx.scene.control.cell.ComboBoxTableCell<S, T>> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setAccessibleHelp(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> accessibleHelp(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleHelp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setAccessibleRole(javafx.scene.AccessibleRole)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> accessibleRole(javafx.scene.AccessibleRole value) {
        operations.add(obj -> obj.setAccessibleRole(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setAccessibleRoleDescription(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> accessibleRoleDescription(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleRoleDescription(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setAccessibleText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> accessibleText(java.lang.String value) {
        operations.add(obj -> obj.setAccessibleText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setAlignment(javafx.geometry.Pos)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> alignment(javafx.geometry.Pos value) {
        operations.add(obj -> obj.setAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setBackground(javafx.scene.layout.Background)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> background(javafx.scene.layout.Background value) {
        operations.add(obj -> obj.setBackground(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> blendMode(javafx.scene.effect.BlendMode value) {
        operations.add(obj -> obj.setBlendMode(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setBorder(javafx.scene.layout.Border)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> border(javafx.scene.layout.Border value) {
        operations.add(obj -> obj.setBorder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setCache(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> cache(boolean value) {
        operations.add(obj -> obj.setCache(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setCacheHint(javafx.scene.CacheHint)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> cacheHint(javafx.scene.CacheHint value) {
        operations.add(obj -> obj.setCacheHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setCacheShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> cacheShape(boolean value) {
        operations.add(obj -> obj.setCacheShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setCenterShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> centerShape(boolean value) {
        operations.add(obj -> obj.setCenterShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setClip(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> clip(javafx.scene.Node value) {
        operations.add(obj -> obj.setClip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setComboBoxEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> comboBoxEditable(boolean value) {
        operations.add(obj -> obj.setComboBoxEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setContentDisplay(javafx.scene.control.ContentDisplay)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> contentDisplay(javafx.scene.control.ContentDisplay value) {
        operations.add(obj -> obj.setContentDisplay(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setContextMenu(javafx.scene.control.ContextMenu)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> contextMenu(javafx.scene.control.ContextMenu value) {
        operations.add(obj -> obj.setContextMenu(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setConverter(javafx.util.StringConverter)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> converter(javafx.util.StringConverter<T> value) {
        operations.add(obj -> obj.setConverter(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setCursor(javafx.scene.Cursor)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> cursor(javafx.scene.Cursor value) {
        operations.add(obj -> obj.setCursor(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setDepthTest(javafx.scene.DepthTest)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> depthTest(javafx.scene.DepthTest value) {
        operations.add(obj -> obj.setDepthTest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setDisable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> disable(boolean value) {
        operations.add(obj -> obj.setDisable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setEditable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> editable(boolean value) {
        operations.add(obj -> obj.setEditable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> effect(javafx.scene.effect.Effect value) {
        operations.add(obj -> obj.setEffect(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setEllipsisString(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> ellipsisString(java.lang.String value) {
        operations.add(obj -> obj.setEllipsisString(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setFocusTraversable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> focusTraversable(boolean value) {
        operations.add(obj -> obj.setFocusTraversable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> font(javafx.scene.text.Font value) {
        operations.add(obj -> obj.setFont(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setGraphic(javafx.scene.Node)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> graphic(javafx.scene.Node value) {
        operations.add(obj -> obj.setGraphic(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setGraphicTextGap(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> graphicTextGap(double value) {
        operations.add(obj -> obj.setGraphicTextGap(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setId(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> id(java.lang.String value) {
        operations.add(obj -> obj.setId(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setInputMethodRequests(javafx.scene.input.InputMethodRequests)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> inputMethodRequests(javafx.scene.input.InputMethodRequests value) {
        operations.add(obj -> obj.setInputMethodRequests(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setItem(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> item(T value) {
        operations.add(obj -> obj.setItem(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setLayoutX(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> layoutX(double value) {
        operations.add(obj -> obj.setLayoutX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setLayoutY(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> layoutY(double value) {
        operations.add(obj -> obj.setLayoutY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setLineSpacing(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> lineSpacing(double value) {
        operations.add(obj -> obj.setLineSpacing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setManaged(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> managed(boolean value) {
        operations.add(obj -> obj.setManaged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMaxSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> maxSize(double maxWidth, double maxHeight) {
        operations.add(obj -> obj.setMaxSize(maxWidth, maxHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMinSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> minSize(double minWidth, double minHeight) {
        operations.add(obj -> obj.setMinSize(minWidth, minHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMnemonicParsing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> mnemonicParsing(boolean value) {
        operations.add(obj -> obj.setMnemonicParsing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setMouseTransparent(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> mouseTransparent(boolean value) {
        operations.add(obj -> obj.setMouseTransparent(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setNodeOrientation(javafx.geometry.NodeOrientation)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> nodeOrientation(javafx.geometry.NodeOrientation orientation) {
        operations.add(obj -> obj.setNodeOrientation(orientation));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnContextMenuRequested(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onContextMenuRequested(javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent> value) {
        operations.add(obj -> obj.setOnContextMenuRequested(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnDragDetected(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onDragDetected(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnDragDetected(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnDragDone(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onDragDone(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDone(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnDragDropped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onDragDropped(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragDropped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onDragEntered(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onDragExited(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onDragOver(javafx.event.EventHandler<? super javafx.scene.input.DragEvent> value) {
        operations.add(obj -> obj.setOnDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnInputMethodTextChanged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onInputMethodTextChanged(javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent> value) {
        operations.add(obj -> obj.setOnInputMethodTextChanged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnKeyPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onKeyPressed(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnKeyReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onKeyReleased(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnKeyTyped(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onKeyTyped(javafx.event.EventHandler<? super javafx.scene.input.KeyEvent> value) {
        operations.add(obj -> obj.setOnKeyTyped(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseClicked(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseClicked(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseClicked(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseDragEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseDragEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseDragExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseDragExited(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseDragOver(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseDragOver(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragOver(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseDragReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseDragReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent> value) {
        operations.add(obj -> obj.setOnMouseDragReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseDragged(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseDragged(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseEntered(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseEntered(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseEntered(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseExited(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseExited(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseExited(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseMoved(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMousePressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMousePressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnMouseReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onMouseReleased(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        operations.add(obj -> obj.setOnMouseReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnRotate(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onRotate(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnRotationFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onRotationFinished(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnRotationStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onRotationStarted(javafx.event.EventHandler<? super javafx.scene.input.RotateEvent> value) {
        operations.add(obj -> obj.setOnRotationStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnScroll(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScroll(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnScrollFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onScrollFinished(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnScrollStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onScrollStarted(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        operations.add(obj -> obj.setOnScrollStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnSwipeDown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onSwipeDown(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeDown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnSwipeLeft(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onSwipeLeft(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeLeft(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnSwipeRight(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onSwipeRight(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeRight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnSwipeUp(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onSwipeUp(javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent> value) {
        operations.add(obj -> obj.setOnSwipeUp(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnTouchMoved(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onTouchMoved(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchMoved(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnTouchPressed(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onTouchPressed(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchPressed(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnTouchReleased(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onTouchReleased(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchReleased(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnTouchStationary(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onTouchStationary(javafx.event.EventHandler<? super javafx.scene.input.TouchEvent> value) {
        operations.add(obj -> obj.setOnTouchStationary(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnZoom(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onZoom(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoom(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnZoomFinished(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onZoomFinished(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomFinished(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOnZoomStarted(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> onZoomStarted(javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent> value) {
        operations.add(obj -> obj.setOnZoomStarted(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setOpaqueInsets(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> opaqueInsets(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setOpaqueInsets(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setPadding(javafx.geometry.Insets)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> padding(javafx.geometry.Insets value) {
        operations.add(obj -> obj.setPadding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setPickOnBounds(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> pickOnBounds(boolean value) {
        operations.add(obj -> obj.setPickOnBounds(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setPrefHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> prefHeight(double value) {
        operations.add(obj -> obj.setPrefHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setPrefSize(double, double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> prefSize(double prefWidth, double prefHeight) {
        operations.add(obj -> obj.setPrefSize(prefWidth, prefHeight));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setPrefWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> prefWidth(double value) {
        operations.add(obj -> obj.setPrefWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setRotate(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> rotate(double value) {
        operations.add(obj -> obj.setRotate(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setRotationAxis(javafx.geometry.Point3D)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> rotationAxis(javafx.geometry.Point3D value) {
        operations.add(obj -> obj.setRotationAxis(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setScaleShape(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> scaleShape(boolean value) {
        operations.add(obj -> obj.setScaleShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> scaleX(double value) {
        operations.add(obj -> obj.setScaleX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> scaleY(double value) {
        operations.add(obj -> obj.setScaleY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setScaleZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> scaleZ(double value) {
        operations.add(obj -> obj.setScaleZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setShape(javafx.scene.shape.Shape)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> shape(javafx.scene.shape.Shape value) {
        operations.add(obj -> obj.setShape(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setSkin(javafx.scene.control.Skin)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> skin(javafx.scene.control.Skin<?> value) {
        operations.add(obj -> obj.setSkin(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setSnapToPixel(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> snapToPixel(boolean value) {
        operations.add(obj -> obj.setSnapToPixel(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setStyle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> style(java.lang.String value) {
        operations.add(obj -> obj.setStyle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setText(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> text(java.lang.String value) {
        operations.add(obj -> obj.setText(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTextAlignment(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> textAlignment(javafx.scene.text.TextAlignment value) {
        operations.add(obj -> obj.setTextAlignment(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTextFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> textFill(javafx.scene.paint.Paint value) {
        operations.add(obj -> obj.setTextFill(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTextOverrun(javafx.scene.control.OverrunStyle)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> textOverrun(javafx.scene.control.OverrunStyle value) {
        operations.add(obj -> obj.setTextOverrun(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTooltip(javafx.scene.control.Tooltip)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> tooltip(javafx.scene.control.Tooltip value) {
        operations.add(obj -> obj.setTooltip(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTranslateX(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> translateX(double value) {
        operations.add(obj -> obj.setTranslateX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTranslateY(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> translateY(double value) {
        operations.add(obj -> obj.setTranslateY(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setTranslateZ(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> translateZ(double value) {
        operations.add(obj -> obj.setTranslateZ(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setUnderline(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> underline(boolean value) {
        operations.add(obj -> obj.setUnderline(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setViewOrder(double)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> viewOrder(double value) {
        operations.add(obj -> obj.setViewOrder(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setVisible(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> visible(boolean value) {
        operations.add(obj -> obj.setVisible(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.control.cell.ComboBoxTableCell#setWrapText(boolean)}
     * 
     * @return builder instance
     */    
    
    public  ComboBoxTableCellBuilder<S, T> wrapText(boolean value) {
        operations.add(obj -> obj.setWrapText(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ComboBoxTableCellBuilder<S, T> addItems(T... elements) {
        operations.add(obj -> {
            obj.getItems().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getItems()} method.
     * 
     * @return builder instance
     */
    public final ComboBoxTableCellBuilder<S, T> addItems(java.util.Collection<? extends T> col) {
        operations.add(obj -> {
            obj.getItems().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getItems()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public static <S, T> ComboBoxTableCellBuilder<S, T> withItems(T... elements) {
        ComboBoxTableCellBuilder<S, T> builder = new ComboBoxTableCellBuilder<S, T>();
        return builder.addItems(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getItems()} method.
     * 
     * @return builder instance
     */
    public static <S, T> ComboBoxTableCellBuilder<S, T> withItems(java.util.Collection<? extends T> col) {
        ComboBoxTableCellBuilder<S, T> builder = new ComboBoxTableCellBuilder<S, T>();
        return builder.addItems(col);
    }


    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getStyleClass()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ComboBoxTableCellBuilder<S, T> addStyleClass(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getStyleClass()} method.
     * 
     * @return builder instance
     */
    public final ComboBoxTableCellBuilder<S, T> addStyleClass(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStyleClass().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getStylesheets()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ComboBoxTableCellBuilder<S, T> addStylesheets(java.lang.String... elements) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getStylesheets()} method.
     * 
     * @return builder instance
     */
    public final ComboBoxTableCellBuilder<S, T> addStylesheets(java.util.Collection<? extends java.lang.String> col) {
        operations.add(obj -> {
            obj.getStylesheets().addAll(col);
        });
        return this;
    }



    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getTransforms()} method.
     * 
     * @return builder instance
     */
    @SafeVarargs
    public final ComboBoxTableCellBuilder<S, T> addTransforms(javafx.scene.transform.Transform... elements) {
        operations.add(obj -> {
            obj.getTransforms().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.scene.control.cell.ComboBoxTableCell#getTransforms()} method.
     * 
     * @return builder instance
     */
    public final ComboBoxTableCellBuilder<S, T> addTransforms(java.util.Collection<? extends javafx.scene.transform.Transform> col) {
        operations.add(obj -> {
            obj.getTransforms().addAll(col);
        });
        return this;
    }


    
    /**
     * Utility setter to add CSS string for this ComboBoxTableCell's contents.
     * For example:
     * <pre>
     * ComboBoxTableCellBuilder builder = ComboBoxTableCellBuilder.create()
     *          .addStylesheetsText(".my-label { -fx-text-fill: white; }")
     *          .build();
     * </pre>
     *
     * @param css CSS string
     */
    public ComboBoxTableCellBuilder<S, T> addStylesheetsText(String css) {
        operations.add(obj -> obj.getStylesheets().addAll("data:text/css;base64," +
                java.util.Base64.getEncoder().encodeToString(css.getBytes())));
        return this;
    }

    public ComboBoxTableCellBuilder<S, T> bottomAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setBottomAnchor(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> leftAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setLeftAnchor(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> rightAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setRightAnchor(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> topAnchorInAnchorPane(java.lang.Double value) {
        operations.add(obj -> javafx.scene.layout.AnchorPane.setTopAnchor(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> alignmentInBorderPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setAlignment(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInBorderPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.BorderPane.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInFlowPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.FlowPane.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> columnIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnIndex(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> columnSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setColumnSpan(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> constraintsInGridPane(int columnIndex, int rowIndex, int columnspan, int rowspan, javafx.geometry.HPos halignment, javafx.geometry.VPos valignment, javafx.scene.layout.Priority hgrow, javafx.scene.layout.Priority vgrow, javafx.geometry.Insets margin) {
        operations.add(obj -> javafx.scene.layout.GridPane.setConstraints(obj, columnIndex, rowIndex, columnspan, rowspan, halignment, valignment, hgrow, vgrow, margin));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> fillHeightInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillHeight(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> fillWidthInGridPane(java.lang.Boolean value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setFillWidth(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> hAlignmentInGridPane(javafx.geometry.HPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHalignment(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> hGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setHgrow(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInGridPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> rowIndexInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowIndex(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> rowSpanInGridPane(java.lang.Integer value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setRowSpan(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> vAlignmentInGridPane(javafx.geometry.VPos value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setValignment(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> vGrowInGridPane(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.GridPane.setVgrow(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> hGrowInHBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.HBox.setHgrow(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInHBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.HBox.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> alignmentInStackPane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setAlignment(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInStackPane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.StackPane.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> alignmentInTilePane(javafx.geometry.Pos value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setAlignment(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInTilePane(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.TilePane.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> marginInVBox(javafx.geometry.Insets value) {
        operations.add(obj -> javafx.scene.layout.VBox.setMargin(obj, value));
        return this;
    }


    public ComboBoxTableCellBuilder<S, T> vGrowInVBox(javafx.scene.layout.Priority value) {
        operations.add(obj -> javafx.scene.layout.VBox.setVgrow(obj, value));
        return this;
    }
    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#accessibleHelpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> accessibleHelpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleHelpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#accessibleRoleDescriptionProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> accessibleRoleDescriptionPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleDescriptionProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#accessibleRoleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> accessibleRolePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.AccessibleRole>> op) {
        operations.add(obj -> op.accept(obj.accessibleRoleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#accessibleTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> accessibleTextPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.accessibleTextProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#alignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> alignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Pos>> op) {
        operations.add(obj -> op.accept(obj.alignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#backgroundProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> backgroundPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Background>> op) {
        operations.add(obj -> op.accept(obj.backgroundProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#blendModeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> blendModePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.BlendMode>> op) {
        operations.add(obj -> op.accept(obj.blendModeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#borderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> borderPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.layout.Border>> op) {
        operations.add(obj -> op.accept(obj.borderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#boundsInLocalProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> boundsInLocalPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInLocalProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#boundsInParentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> boundsInParentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.boundsInParentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#cacheHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> cacheHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.CacheHint>> op) {
        operations.add(obj -> op.accept(obj.cacheHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#cacheProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> cachePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#cacheShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> cacheShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.cacheShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#centerShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> centerShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.centerShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#clipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> clipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.clipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#comboBoxEditableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> comboBoxEditablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.comboBoxEditableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#contentDisplayProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> contentDisplayPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContentDisplay>> op) {
        operations.add(obj -> op.accept(obj.contentDisplayProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#contextMenuProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> contextMenuPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.ContextMenu>> op) {
        operations.add(obj -> op.accept(obj.contextMenuProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#converterProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> converterPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.StringConverter<T>>> op) {
        operations.add(obj -> op.accept(obj.converterProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#cursorProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> cursorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Cursor>> op) {
        operations.add(obj -> op.accept(obj.cursorProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#depthTestProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> depthTestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.DepthTest>> op) {
        operations.add(obj -> op.accept(obj.depthTestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#disableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> disablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#disabledProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> disabledPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.disabledProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#editableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> editablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#editingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> editingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.editingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#effectProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> effectPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.effect.Effect>> op) {
        operations.add(obj -> op.accept(obj.effectProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#effectiveNodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> effectiveNodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.effectiveNodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#ellipsisStringProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> ellipsisStringPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.ellipsisStringProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#emptyProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> emptyPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.emptyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#focusTraversableProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> focusTraversablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusTraversableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#focusVisibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> focusVisiblePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusVisibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#focusWithinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> focusWithinPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusWithinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#fontProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> fontPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.Font>> op) {
        operations.add(obj -> op.accept(obj.fontProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#graphicProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> graphicPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.Node>> op) {
        operations.add(obj -> op.accept(obj.graphicProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#graphicTextGapProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> graphicTextGapPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.graphicTextGapProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#hoverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> hoverPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.hoverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#idProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> idPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.idProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#indexProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> indexPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyIntegerProperty> op) {
        operations.add(obj -> op.accept(obj.indexProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#inputMethodRequestsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> inputMethodRequestsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.InputMethodRequests>> op) {
        operations.add(obj -> op.accept(obj.inputMethodRequestsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#insetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> insetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.insetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#itemProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> itemPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<T>> op) {
        operations.add(obj -> op.accept(obj.itemProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#labelPaddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> labelPaddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.labelPaddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#layoutBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> layoutBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.geometry.Bounds>> op) {
        operations.add(obj -> op.accept(obj.layoutBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#layoutXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> layoutXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#layoutYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> layoutYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.layoutYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#lineSpacingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> lineSpacingPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.lineSpacingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#localToParentTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> localToParentTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToParentTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#localToSceneTransformProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> localToSceneTransformPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.transform.Transform>> op) {
        operations.add(obj -> op.accept(obj.localToSceneTransformProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#managedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> managedPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.managedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#mnemonicParsingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> mnemonicParsingPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mnemonicParsingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#mouseTransparentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> mouseTransparentPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.mouseTransparentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#needsLayoutProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> needsLayoutPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.needsLayoutProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#nodeOrientationProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> nodeOrientationPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.NodeOrientation>> op) {
        operations.add(obj -> op.accept(obj.nodeOrientationProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onContextMenuRequestedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onContextMenuRequestedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ContextMenuEvent>>> op) {
        operations.add(obj -> op.accept(obj.onContextMenuRequestedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onDragDetectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onDragDetectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDetectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onDragDoneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onDragDonePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDoneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onDragDroppedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onDragDroppedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragDroppedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.DragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onInputMethodTextChangedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onInputMethodTextChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.InputMethodEvent>>> op) {
        operations.add(obj -> op.accept(obj.onInputMethodTextChangedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onKeyPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onKeyPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onKeyReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onKeyReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onKeyTypedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onKeyTypedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.KeyEvent>>> op) {
        operations.add(obj -> op.accept(obj.onKeyTypedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseClickedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseClickedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseClickedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseDragEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseDragEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseDragExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseDragExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseDragOverProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseDragOverPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragOverProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseDragReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseDragReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseDragEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDragReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseDraggedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseDraggedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseDraggedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseEnteredProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseEnteredPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseEnteredProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseExitedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseExitedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseExitedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMousePressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMousePressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMousePressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onMouseReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onMouseReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.MouseEvent>>> op) {
        operations.add(obj -> op.accept(obj.onMouseReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onRotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onRotatePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onRotationFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onRotationFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onRotationStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onRotationStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.RotateEvent>>> op) {
        operations.add(obj -> op.accept(obj.onRotationStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onScrollFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onScrollFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onScrollProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onScrollPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onScrollStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onScrollStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent>>> op) {
        operations.add(obj -> op.accept(obj.onScrollStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onSwipeDownProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onSwipeDownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeDownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onSwipeLeftProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onSwipeLeftPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeLeftProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onSwipeRightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onSwipeRightPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeRightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onSwipeUpProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onSwipeUpPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.SwipeEvent>>> op) {
        operations.add(obj -> op.accept(obj.onSwipeUpProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onTouchMovedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onTouchMovedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchMovedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onTouchPressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onTouchPressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchPressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onTouchReleasedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onTouchReleasedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchReleasedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onTouchStationaryProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onTouchStationaryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.TouchEvent>>> op) {
        operations.add(obj -> op.accept(obj.onTouchStationaryProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onZoomFinishedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onZoomFinishedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomFinishedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onZoomProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onZoomPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#onZoomStartedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> onZoomStartedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<? super javafx.scene.input.ZoomEvent>>> op) {
        operations.add(obj -> op.accept(obj.onZoomStartedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#opaqueInsetsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> opaqueInsetsPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.opaqueInsetsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#paddingProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> paddingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Insets>> op) {
        operations.add(obj -> op.accept(obj.paddingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#parentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> parentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Parent>> op) {
        operations.add(obj -> op.accept(obj.parentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#pickOnBoundsProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> pickOnBoundsPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pickOnBoundsProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#prefHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> prefHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#prefWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> prefWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.prefWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#pressedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> pressedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.pressedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#rotateProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> rotatePropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.rotateProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#rotationAxisProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> rotationAxisPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.geometry.Point3D>> op) {
        operations.add(obj -> op.accept(obj.rotationAxisProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#scaleShapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> scaleShapePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.scaleShapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#scaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> scaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#scaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> scaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#scaleZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> scaleZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.scaleZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#selectedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> selectedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.selectedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#shapeProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> shapePropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.shape.Shape>> op) {
        operations.add(obj -> op.accept(obj.shapeProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#skinProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> skinPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Skin<?>>> op) {
        operations.add(obj -> op.accept(obj.skinProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#snapToPixelProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> snapToPixelPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.snapToPixelProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#styleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> stylePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.styleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#tableColumnProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> tableColumnPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableColumn<S, T>>> op) {
        operations.add(obj -> op.accept(obj.tableColumnProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#tableRowProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> tableRowPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableRow<S>>> op) {
        operations.add(obj -> op.accept(obj.tableRowProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#tableViewProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> tableViewPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableView<S>>> op) {
        operations.add(obj -> op.accept(obj.tableViewProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#textAlignmentProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> textAlignmentPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.text.TextAlignment>> op) {
        operations.add(obj -> op.accept(obj.textAlignmentProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#textFillProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> textFillPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.paint.Paint>> op) {
        operations.add(obj -> op.accept(obj.textFillProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#textOverrunProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> textOverrunPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.OverrunStyle>> op) {
        operations.add(obj -> op.accept(obj.textOverrunProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#textProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> textPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.textProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#textTruncatedProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> textTruncatedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.textTruncatedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#tooltipProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> tooltipPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.control.Tooltip>> op) {
        operations.add(obj -> op.accept(obj.tooltipProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#translateXProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> translateXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#translateYProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> translateYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#translateZProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> translateZPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.translateZProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#underlineProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> underlinePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.underlineProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#viewOrderProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> viewOrderPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.viewOrderProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#visibleProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> visiblePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.visibleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.scene.control.cell.ComboBoxTableCell#wrapTextProperty()}.
     * 
     * @return builder instance
     */    
    
    public ComboBoxTableCellBuilder<S, T> wrapTextPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.wrapTextProperty()));
        return this;
    }
}
