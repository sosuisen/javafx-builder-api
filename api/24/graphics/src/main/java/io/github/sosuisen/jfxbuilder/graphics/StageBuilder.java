package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code StageBuilder} class constructs instances of the {@link javafx.stage.Stage} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.stage.Stage} constructor
 * and returns an instance of the {@code StageBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.stage.Stage}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.stage.Stage} class.
 * </p>
 *
 * <p>
 * Note 1: Intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 * <p>
 * Note 2: There is no setter for the optional constructor argument {@code StageStyle}, but {@code StageBuilder} has a {@code stageStyle} method.
 * </p>
 * <p>
 * Example:
 * </p>
 * <pre>{@code 
 * StageBuilder.withScene(
 *       SceneBuilder.withRoot(
 *             AnchorPaneBuilder.withChildren(
 *                   LabelBuilder.create()
                         .text("Hello, JavaFX!")
                         .style("-fx-font-weight: bold;")
                         .build())
 *                 .build())
 *           .build())
 *     .width(640)
 *     .height(480)
 *     .build();
 * }</pre>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */
public class StageBuilder {
    private final java.util.List<java.util.function.Consumer<javafx.stage.Stage>> operations = new java.util.ArrayList<>();
    private StageBuilder() {}
    
    private javafx.stage.StageStyle style = javafx.stage.StageStyle.DECORATED;

    /**
     * Creates an instance of the builder and then calls the {@link javafx.stage.Stage#setScene(javafx.scene.Scene) setScene(javafx.scene.Scene)} method.
     * This shorthand ensures consistency with other methods, such as the `withChildren` method found in container classes.
     *
     * @return an instance of the StageBuilder.
     */
    public static StageBuilder withScene(javafx.scene.Scene scene) {
        StageBuilder builder = new StageBuilder();
        builder.scene(scene);
        return builder;
    }


    /**
     * Sets a {@link javafx.stage.StageStyle}.
     * There is no setter for the optional constructor argument {@code StageStyle};
     * however, the {@code StageBuilder} includes a convenient {@code stageStyle} method.
     *
     * @return an instance of the StageBuilder.
     */
    public StageBuilder stageStyle(javafx.stage.StageStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Returns an instance of the StageBuilder.
     *
     * @return an instance of the StageBuilder.
     */
    public static StageBuilder create() {
        StageBuilder builder = new StageBuilder();
        return builder;
    }

    /**
     * Accepts the constructor arguments of {@link javafx.stage.Stage#Stage(javafx.stage.StageStyle)}
     * and returns an instance of the StageBuilder.
     *
     * @return an instance of the StageBuilder.
     */
    public static StageBuilder create(javafx.stage.StageStyle style) {
        StageBuilder builder = new StageBuilder();
        builder.style = style;
        return builder;
    }

    /**
     * Builds and returns an instance of the {@link javafx.stage.Stage} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.stage.Stage} class
     */
    public javafx.stage.Stage build() {
        javafx.stage.Stage newInstance;

        newInstance = new javafx.stage.Stage(style);

        for (java.util.function.Consumer<javafx.stage.Stage> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }



    /**
     * Applies a function to the Stage instance being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public StageBuilder apply(java.util.function.Consumer<javafx.stage.Stage> func) {
        operations.add(func);
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setAlwaysOnTop(boolean) setAlwaysOnTop} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder alwaysOnTop(boolean value) {
        operations.add(obj -> obj.setAlwaysOnTop(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setEventDispatcher(javafx.event.EventDispatcher) setEventDispatcher} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setForceIntegerRenderScale(boolean) setForceIntegerRenderScale} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setFullScreen(boolean) setFullScreen} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder fullScreen(boolean value) {
        operations.add(obj -> obj.setFullScreen(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setFullScreenExitHint(java.lang.String) setFullScreenExitHint} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder fullScreenExitHint(java.lang.String value) {
        operations.add(obj -> obj.setFullScreenExitHint(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setFullScreenExitKeyCombination(javafx.scene.input.KeyCombination) setFullScreenExitKeyCombination} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder fullScreenExitKeyCombination(javafx.scene.input.KeyCombination keyCombination) {
        operations.add(obj -> obj.setFullScreenExitKeyCombination(keyCombination));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setHeight(double) setHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setIconified(boolean) setIconified} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder iconified(boolean value) {
        operations.add(obj -> obj.setIconified(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setMaxHeight(double) setMaxHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setMaxWidth(double) setMaxWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setMaximized(boolean) setMaximized} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder maximized(boolean value) {
        operations.add(obj -> obj.setMaximized(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setMinHeight(double) setMinHeight} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setMinWidth(double) setMinWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setOnCloseRequest(javafx.event.EventHandler) setOnCloseRequest} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setOnHidden(javafx.event.EventHandler) setOnHidden} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setOnHiding(javafx.event.EventHandler) setOnHiding} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setOnShowing(javafx.event.EventHandler) setOnShowing} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setOnShown(javafx.event.EventHandler) setOnShown} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setOpacity(double) setOpacity} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setRenderScaleX(double) setRenderScaleX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setRenderScaleY(double) setRenderScaleY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setResizable(boolean) setResizable} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder resizable(boolean value) {
        operations.add(obj -> obj.setResizable(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setScene(javafx.scene.Scene) setScene} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder scene(javafx.scene.Scene value) {
        operations.add(obj -> obj.setScene(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Stage#setTitle(java.lang.String) setTitle} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder title(java.lang.String value) {
        operations.add(obj -> obj.setTitle(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setUserData(java.lang.Object) setUserData} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setWidth(double) setWidth} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setX(double) setX} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }

    /**
     * A builder method that invokes the {@link javafx.stage.Window#setY(double) setY} method on the instance being constructed.
     *
     * @return builder instance
     */
    public  StageBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }

    /**
     * Calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */
    public final StageBuilder addIcons(javafx.scene.image.Image... elements) {
        operations.add(obj -> obj.getIcons().addAll(elements));
        return this;
    }

    /**
     * Calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */
    public final StageBuilder addIcons(java.util.Collection<? extends javafx.scene.image.Image> col) {
        operations.add(obj -> obj.getIcons().addAll(col));
        return this;
    }

    /**
     * Creates an instance of the builder, then calls the {@link javafx.collections.ObservableList#addAll(java.lang.Object[]) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */
    public static StageBuilder withIcons(javafx.scene.image.Image... elements) {
        StageBuilder builder = new StageBuilder();
        return builder.addIcons(elements);
    }

    /**
     * Creates an instance of the builder, then calls the {@link java.util.List#addAll(java.util.Collection) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */
    public static StageBuilder withIcons(java.util.Collection<? extends javafx.scene.image.Image> col) {
        StageBuilder builder = new StageBuilder();
        return builder.addIcons(col);
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#alwaysOnTopProperty() alwaysOnTopProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.alwaysOnTopProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .alwaysOnTopPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder alwaysOnTopPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alwaysOnTopProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#eventDispatcherProperty() eventDispatcherProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.eventDispatcherProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .eventDispatcherPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#focusedProperty() focusedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.focusedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .focusedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#forceIntegerRenderScaleProperty() forceIntegerRenderScaleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.forceIntegerRenderScaleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .forceIntegerRenderScalePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#fullScreenExitHintProperty() fullScreenExitHintProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fullScreenExitHintProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fullScreenExitHintPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder fullScreenExitHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.fullScreenExitHintProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#fullScreenExitKeyProperty() fullScreenExitKeyProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fullScreenExitKeyProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fullScreenExitKeyPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder fullScreenExitKeyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.fullScreenExitKeyProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#fullScreenProperty() fullScreenProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.fullScreenProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .fullScreenPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder fullScreenPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.fullScreenProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#heightProperty() heightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.heightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .heightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#iconifiedProperty() iconifiedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.iconifiedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .iconifiedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder iconifiedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.iconifiedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#maxHeightProperty() maxHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#maxWidthProperty() maxWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maxWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maxWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#maximizedProperty() maximizedProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.maximizedProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .maximizedPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder maximizedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.maximizedProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#minHeightProperty() minHeightProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minHeightProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minHeightPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#minWidthProperty() minWidthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.minWidthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .minWidthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#onCloseRequestProperty() onCloseRequestProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onCloseRequestProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onCloseRequestPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#onHiddenProperty() onHiddenProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHiddenProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHiddenPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#onHidingProperty() onHidingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onHidingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onHidingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#onShowingProperty() onShowingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onShowingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onShowingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#onShownProperty() onShownProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.onShownProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .onShownPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#opacityProperty() opacityProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.opacityProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .opacityPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#outputScaleXProperty() outputScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.outputScaleXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .outputScaleXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#outputScaleYProperty() outputScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.outputScaleYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .outputScaleYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#renderScaleXProperty() renderScaleXProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.renderScaleXProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .renderScaleXPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#renderScaleYProperty() renderScaleYProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.renderScaleYProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .renderScaleYPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#resizableProperty() resizableProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.resizableProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .resizablePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#sceneProperty() sceneProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.sceneProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .scenePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#showingProperty() showingProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.showingProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .showingPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#titleProperty() titleProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.titleProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .titlePropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#widthProperty() widthProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.widthProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .widthPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#xProperty() xProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.xProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .xPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }

    /**
     * Applies a function to the {@link javafx.stage.Stage#yProperty() yProperty} 
     * of the instance being constructed. 
     * This serves as a shorthand form of the {@link StageBuilder#apply(java.util.function.Consumer) apply} method.
     * <p>
     * Example: 
     * </p>
     * <pre>{@code
     * // Use apply
     * .apply(obj -> obj.yProperty().bind(anotherProperty))
     *
     * // Use shorthand form
     * .yPropertyApply(prop -> prop.bind(anotherProperty))}
     * </pre>
     *
     * @return builder instance
     */
    public StageBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
