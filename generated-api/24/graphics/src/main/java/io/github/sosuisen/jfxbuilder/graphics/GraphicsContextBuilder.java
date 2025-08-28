
package io.github.sosuisen.jfxbuilder.graphics;


public class GraphicsContextBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.canvas.GraphicsContext>> operations = new java.util.ArrayList<>();
    private GraphicsContextBuilder() {}
    
    private Object[] constructorArgs;

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
    
    public GraphicsContextBuilder apply(java.util.function.Consumer<javafx.scene.canvas.GraphicsContext> func) {
        operations.add(func);
        return this;
    }    
    
    public  GraphicsContextBuilder effect(javafx.scene.effect.Effect e) {
        operations.add(obj -> obj.setEffect(e));
        return this;
    }    
    
    public  GraphicsContextBuilder fill(javafx.scene.paint.Paint p) {
        operations.add(obj -> obj.setFill(p));
        return this;
    }    
    
    public  GraphicsContextBuilder transform(javafx.scene.transform.Affine xform) {
        operations.add(obj -> obj.setTransform(xform));
        return this;
    }    
    
    public  GraphicsContextBuilder transform(double mxx, double myx, double mxy, double myy, double mxt, double myt) {
        operations.add(obj -> obj.setTransform(mxx, myx, mxy, myy, mxt, myt));
        return this;
    }    
    
    public  GraphicsContextBuilder stroke(javafx.scene.paint.Paint p) {
        operations.add(obj -> obj.setStroke(p));
        return this;
    }    
    
    public  GraphicsContextBuilder fillRule(javafx.scene.shape.FillRule fillRule) {
        operations.add(obj -> obj.setFillRule(fillRule));
        return this;
    }    
    
    public  GraphicsContextBuilder lineDashOffset(double dashOffset) {
        operations.add(obj -> obj.setLineDashOffset(dashOffset));
        return this;
    }    
    
    public  GraphicsContextBuilder textAlign(javafx.scene.text.TextAlignment align) {
        operations.add(obj -> obj.setTextAlign(align));
        return this;
    }    
    
    public  GraphicsContextBuilder textBaseline(javafx.geometry.VPos baseline) {
        operations.add(obj -> obj.setTextBaseline(baseline));
        return this;
    }    
    
    public  GraphicsContextBuilder miterLimit(double ml) {
        operations.add(obj -> obj.setMiterLimit(ml));
        return this;
    }    
    
    public  GraphicsContextBuilder lineDashes(double... dashes) {
        operations.add(obj -> obj.setLineDashes(dashes));
        return this;
    }    
    
    public  GraphicsContextBuilder globalAlpha(double alpha) {
        operations.add(obj -> obj.setGlobalAlpha(alpha));
        return this;
    }    
    
    public  GraphicsContextBuilder lineJoin(javafx.scene.shape.StrokeLineJoin join) {
        operations.add(obj -> obj.setLineJoin(join));
        return this;
    }    
    
    public  GraphicsContextBuilder lineWidth(double lw) {
        operations.add(obj -> obj.setLineWidth(lw));
        return this;
    }    
    
    public  GraphicsContextBuilder globalBlendMode(javafx.scene.effect.BlendMode op) {
        operations.add(obj -> obj.setGlobalBlendMode(op));
        return this;
    }    
    
    public  GraphicsContextBuilder imageSmoothing(boolean imageSmoothing) {
        operations.add(obj -> obj.setImageSmoothing(imageSmoothing));
        return this;
    }    
    
    public  GraphicsContextBuilder font(javafx.scene.text.Font f) {
        operations.add(obj -> obj.setFont(f));
        return this;
    }    
    
    public  GraphicsContextBuilder lineCap(javafx.scene.shape.StrokeLineCap cap) {
        operations.add(obj -> obj.setLineCap(cap));
        return this;
    }    
    
    public  GraphicsContextBuilder fontSmoothingType(javafx.scene.text.FontSmoothingType fontsmoothing) {
        operations.add(obj -> obj.setFontSmoothingType(fontsmoothing));
        return this;
    }
}
