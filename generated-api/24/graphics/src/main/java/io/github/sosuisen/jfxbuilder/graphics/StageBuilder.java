
package io.github.sosuisen.jfxbuilder.graphics;


public class StageBuilder {
    private java.util.List<java.util.function.Consumer<javafx.stage.Stage>> operations = new java.util.ArrayList<>();
    private StageBuilder() {}
    

    private javafx.stage.StageStyle style = javafx.stage.StageStyle.DECORATED;

    public static StageBuilder withScene(javafx.scene.Scene scene) {
        StageBuilder builder = new StageBuilder();
        builder.scene(scene);
        return builder;
    }

    public StageBuilder stageStyle(javafx.stage.StageStyle style) {
        this.style = style;
        return this;
    }

    public static StageBuilder create() {
        StageBuilder builder = new StageBuilder();
        return builder;
    }

    public static StageBuilder create(javafx.stage.StageStyle style) {
        StageBuilder builder = new StageBuilder();
        builder.style = style;
        return builder;
    }

    public javafx.stage.Stage build() {
        javafx.stage.Stage newInstance;

        newInstance = new javafx.stage.Stage(style);

        for (java.util.function.Consumer<javafx.stage.Stage> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    
    public StageBuilder apply(java.util.function.Consumer<javafx.stage.Stage> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setAlwaysOnTop(boolean)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder alwaysOnTop(boolean value) {
        operations.add(obj -> obj.setAlwaysOnTop(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setEventDispatcher(javafx.event.EventDispatcher)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder eventDispatcher(javafx.event.EventDispatcher value) {
        operations.add(obj -> obj.setEventDispatcher(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setForceIntegerRenderScale(boolean)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder forceIntegerRenderScale(boolean forced) {
        operations.add(obj -> obj.setForceIntegerRenderScale(forced));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setFullScreen(boolean)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder fullScreen(boolean value) {
        operations.add(obj -> obj.setFullScreen(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setFullScreenExitHint(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder fullScreenExitHint(java.lang.String value) {
        operations.add(obj -> obj.setFullScreenExitHint(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setFullScreenExitKeyCombination(javafx.scene.input.KeyCombination)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder fullScreenExitKeyCombination(javafx.scene.input.KeyCombination keyCombination) {
        operations.add(obj -> obj.setFullScreenExitKeyCombination(keyCombination));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder height(double value) {
        operations.add(obj -> obj.setHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setIconified(boolean)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder iconified(boolean value) {
        operations.add(obj -> obj.setIconified(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setMaxHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder maxHeight(double value) {
        operations.add(obj -> obj.setMaxHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setMaxWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder maxWidth(double value) {
        operations.add(obj -> obj.setMaxWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setMaximized(boolean)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder maximized(boolean value) {
        operations.add(obj -> obj.setMaximized(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setMinHeight(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder minHeight(double value) {
        operations.add(obj -> obj.setMinHeight(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setMinWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder minWidth(double value) {
        operations.add(obj -> obj.setMinWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setOnCloseRequest(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder onCloseRequest(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnCloseRequest(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setOnHidden(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder onHidden(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHidden(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setOnHiding(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder onHiding(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnHiding(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setOnShowing(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder onShowing(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShowing(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setOnShown(javafx.event.EventHandler)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder onShown(javafx.event.EventHandler<javafx.stage.WindowEvent> value) {
        operations.add(obj -> obj.setOnShown(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setOpacity(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder opacity(double value) {
        operations.add(obj -> obj.setOpacity(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setRenderScaleX(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder renderScaleX(double scale) {
        operations.add(obj -> obj.setRenderScaleX(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setRenderScaleY(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder renderScaleY(double scale) {
        operations.add(obj -> obj.setRenderScaleY(scale));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setResizable(boolean)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder resizable(boolean value) {
        operations.add(obj -> obj.setResizable(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setScene(javafx.scene.Scene)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder scene(javafx.scene.Scene value) {
        operations.add(obj -> obj.setScene(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setTitle(java.lang.String)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder title(java.lang.String value) {
        operations.add(obj -> obj.setTitle(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setUserData(java.lang.Object)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder userData(java.lang.Object value) {
        operations.add(obj -> obj.setUserData(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder width(double value) {
        operations.add(obj -> obj.setWidth(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setX(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder x(double value) {
        operations.add(obj -> obj.setX(value));
        return this;
    }
    /**
     * Builder method for {@link javafx.stage.Stage#setY(double)}
     * 
     * @return builder instance
     */    
    
    public  StageBuilder y(double value) {
        operations.add(obj -> obj.setY(value));
        return this;
    }
    /**
     * Call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public final StageBuilder addIcons(javafx.scene.image.Image... elements) {
        operations.add(obj -> {
            obj.getIcons().addAll(elements);
        });
        return this;
    }

    /**
     * Call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */     
    public final StageBuilder addIcons(java.util.Collection<? extends javafx.scene.image.Image> col) {
        operations.add(obj -> {
            obj.getIcons().addAll(col);
        });
        return this;
    }


    /**
     * Create an instance of the builder, then call the {@link javafx.collections.ObservableList#addAll(E... elements) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */     
    @SafeVarargs
    public static StageBuilder withIcons(javafx.scene.image.Image... elements) {
        StageBuilder builder = new StageBuilder();
        return builder.addIcons(elements);
    }

    /**
     * Create an instance of the builder, then call the {@link java.util.List#addAll(Collection<? extends E> c) addAll} method on the ObservableList returned by the {@link javafx.stage.Stage#getIcons()} method.
     * 
     * @return builder instance
     */     
    public static StageBuilder withIcons(java.util.Collection<? extends javafx.scene.image.Image> col) {
        StageBuilder builder = new StageBuilder();
        return builder.addIcons(col);
    }

    
    /**
     * Applies a function to the {@link javafx.stage.Stage#alwaysOnTopProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder alwaysOnTopPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.alwaysOnTopProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#eventDispatcherProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder eventDispatcherPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventDispatcher>> op) {
        operations.add(obj -> op.accept(obj.eventDispatcherProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#focusedProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder focusedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.focusedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#forceIntegerRenderScaleProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder forceIntegerRenderScalePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.forceIntegerRenderScaleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#fullScreenExitHintProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder fullScreenExitHintPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.lang.String>> op) {
        operations.add(obj -> op.accept(obj.fullScreenExitHintProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#fullScreenExitKeyProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder fullScreenExitKeyPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.scene.input.KeyCombination>> op) {
        operations.add(obj -> op.accept(obj.fullScreenExitKeyProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#fullScreenProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder fullScreenPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.fullScreenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#heightProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder heightPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.heightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#iconifiedProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder iconifiedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.iconifiedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#maxHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder maxHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#maxWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder maxWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.maxWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#maximizedProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder maximizedPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.maximizedProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#minHeightProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder minHeightPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minHeightProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#minWidthProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder minWidthPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.minWidthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#onCloseRequestProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder onCloseRequestPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onCloseRequestProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#onHiddenProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder onHiddenPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHiddenProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#onHidingProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder onHidingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onHidingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#onShowingProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder onShowingPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShowingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#onShownProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder onShownPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.stage.WindowEvent>>> op) {
        operations.add(obj -> op.accept(obj.onShownProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#opacityProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder opacityPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.opacityProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#outputScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder outputScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#outputScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder outputScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.outputScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#renderScaleXProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder renderScaleXPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleXProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#renderScaleYProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder renderScaleYPropertyApply(java.util.function.Consumer<javafx.beans.property.DoubleProperty> op) {
        operations.add(obj -> op.accept(obj.renderScaleYProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#resizableProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder resizablePropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.resizableProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#sceneProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder scenePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.Scene>> op) {
        operations.add(obj -> op.accept(obj.sceneProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#showingProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder showingPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyBooleanProperty> op) {
        operations.add(obj -> op.accept(obj.showingProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#titleProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#widthProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder widthPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.widthProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#xProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder xPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.xProperty()));
        return this;
    }    
    /**
     * Applies a function to the {@link javafx.stage.Stage#yProperty()}.
     * 
     * @return builder instance
     */    
    
    public StageBuilder yPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyDoubleProperty> op) {
        operations.add(obj -> op.accept(obj.yProperty()));
        return this;
    }
}
