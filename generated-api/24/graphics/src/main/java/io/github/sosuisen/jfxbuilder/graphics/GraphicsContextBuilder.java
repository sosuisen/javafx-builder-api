
package io.github.sosuisen.jfxbuilder.graphics;

/**
 * The {@code GraphicsContextBuilder} class constructs instances of the {@link javafx.scene.canvas.GraphicsContext GraphicsContext} class 
 * and offers a fluent interface for creating and configuring it. 
 *
 * <p>
 * This class includes a static {@code create} method that accepts the same arguments as the original {@link javafx.scene.canvas.GraphicsContext GraphicsContext} constructor
 * and returns an instance of the {@code GraphicsContextBuilder}.
 * </p>
 *
 * <p>
 * You can use method chaining to call the builder methods for configuring the {@link javafx.scene.canvas.GraphicsContext GraphicsContext}.
 * Finally, invoke the {@code build} method to generate an instance of the {@link javafx.scene.canvas.GraphicsContext GraphicsContext} class.
 * </p>
 *
 * <p>
 * Note that intermediate builder methods are not evaluated until the {@code build} method
 * is called, meaning they are evaluated lazily.
 * </p>
 *
 * @author Hidekazu Kubota &lt;hidekazu.kubota@gmail.com&gt;
 */

public class GraphicsContextBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.canvas.GraphicsContext>> operations = new java.util.ArrayList<>();
    private GraphicsContextBuilder() {}
    
    private Object[] constructorArgs;

    /**
     * Builds and returns an instance of the {@link javafx.scene.canvas.GraphicsContext} class.
     * 
     * <p>
     * Intermediate builder methods are not evaluated until the {@code build} method
     * is called; in other words, they are evaluated lazily.
     * </p>
     *
     * @return new instance of the {@link javafx.scene.canvas.GraphicsContext GraphicsContext} class
     */
    public javafx.scene.canvas.GraphicsContext build() {
        javafx.scene.canvas.GraphicsContext newInstance;

        newInstance = callParameterizedConstructor();


        for (java.util.function.Consumer<javafx.scene.canvas.GraphicsContext> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.canvas.GraphicsContext callParameterizedConstructor() {
        javafx.scene.canvas.GraphicsContext newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.canvas.GraphicsContext.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.canvas.GraphicsContext) constructor.newInstance(constructorArgs);
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
     * Applies a function to the GraphicsContext instance currently being constructed.
     * Most operations on the instance can be performed using this method.
     *
     * @return builder instance
     *
     */
    public GraphicsContextBuilder apply(java.util.function.Consumer<javafx.scene.canvas.GraphicsContext> func) {
        operations.add(func);
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setEffect(javafx.scene.effect.Effect)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder effect(javafx.scene.effect.Effect e) {
        operations.add(obj -> obj.setEffect(e));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setFill(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder fill(javafx.scene.paint.Paint p) {
        operations.add(obj -> obj.setFill(p));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setFillRule(javafx.scene.shape.FillRule)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder fillRule(javafx.scene.shape.FillRule fillRule) {
        operations.add(obj -> obj.setFillRule(fillRule));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setFont(javafx.scene.text.Font)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder font(javafx.scene.text.Font f) {
        operations.add(obj -> obj.setFont(f));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setFontSmoothingType(javafx.scene.text.FontSmoothingType)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder fontSmoothingType(javafx.scene.text.FontSmoothingType fontsmoothing) {
        operations.add(obj -> obj.setFontSmoothingType(fontsmoothing));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setGlobalAlpha(double)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder globalAlpha(double alpha) {
        operations.add(obj -> obj.setGlobalAlpha(alpha));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setGlobalBlendMode(javafx.scene.effect.BlendMode)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder globalBlendMode(javafx.scene.effect.BlendMode op) {
        operations.add(obj -> obj.setGlobalBlendMode(op));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setImageSmoothing(boolean)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder imageSmoothing(boolean imageSmoothing) {
        operations.add(obj -> obj.setImageSmoothing(imageSmoothing));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setLineCap(javafx.scene.shape.StrokeLineCap)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder lineCap(javafx.scene.shape.StrokeLineCap cap) {
        operations.add(obj -> obj.setLineCap(cap));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setLineDashOffset(double)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder lineDashOffset(double dashOffset) {
        operations.add(obj -> obj.setLineDashOffset(dashOffset));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setLineDashes(double...)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder lineDashes(double... dashes) {
        operations.add(obj -> obj.setLineDashes(dashes));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setLineJoin(javafx.scene.shape.StrokeLineJoin)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder lineJoin(javafx.scene.shape.StrokeLineJoin join) {
        operations.add(obj -> obj.setLineJoin(join));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setLineWidth(double)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder lineWidth(double lw) {
        operations.add(obj -> obj.setLineWidth(lw));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setMiterLimit(double)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder miterLimit(double ml) {
        operations.add(obj -> obj.setMiterLimit(ml));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setStroke(javafx.scene.paint.Paint)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder stroke(javafx.scene.paint.Paint p) {
        operations.add(obj -> obj.setStroke(p));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setTextAlign(javafx.scene.text.TextAlignment)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder textAlign(javafx.scene.text.TextAlignment align) {
        operations.add(obj -> obj.setTextAlign(align));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setTextBaseline(javafx.geometry.VPos)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder textBaseline(javafx.geometry.VPos baseline) {
        operations.add(obj -> obj.setTextBaseline(baseline));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setTransform(double, double, double, double, double, double)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder transform(double mxx, double myx, double mxy, double myy, double mxt, double myt) {
        operations.add(obj -> obj.setTransform(mxx, myx, mxy, myy, mxt, myt));
        return this;
    }
    /**
     * Builder method for {@link javafx.scene.canvas.GraphicsContext#setTransform(javafx.scene.transform.Affine)}
     * 
     * @return builder instance
     */    
    
    public  GraphicsContextBuilder transform(javafx.scene.transform.Affine xform) {
        operations.add(obj -> obj.setTransform(xform));
        return this;
    }
}
