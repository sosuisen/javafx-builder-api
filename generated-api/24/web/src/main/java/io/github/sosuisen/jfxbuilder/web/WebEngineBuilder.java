
package io.github.sosuisen.jfxbuilder.web;


public class WebEngineBuilder {
    private java.util.List<java.util.function.Consumer<javafx.scene.web.WebEngine>> operations = new java.util.ArrayList<>();
    private WebEngineBuilder() {}
    

    
    public static WebEngineBuilder create(java.lang.String url) {
        WebEngineBuilder builder = new WebEngineBuilder();
        builder.constructorArgs = new Object[]{url};
        return builder;
    }


    public static WebEngineBuilder create() { return new WebEngineBuilder(); }

    private Object[] constructorArgs;

    public javafx.scene.web.WebEngine build() {
        javafx.scene.web.WebEngine newInstance;

        if (constructorArgs == null) {

            newInstance = new javafx.scene.web.WebEngine();

        } else {
            newInstance = callParameterizedConstructor();
        }


        for (java.util.function.Consumer<javafx.scene.web.WebEngine> op : operations) {
            op.accept(newInstance);
        }
        return newInstance;
    }


    private javafx.scene.web.WebEngine callParameterizedConstructor() {
        javafx.scene.web.WebEngine newInstance;        
        try {
            java.lang.reflect.Constructor<?>[] constructors = javafx.scene.web.WebEngine.class.getConstructors();
            newInstance = null;
            for (java.lang.reflect.Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == constructorArgs.length && isConstructorCompatible(constructor, constructorArgs)) {
                    newInstance = (javafx.scene.web.WebEngine) constructor.newInstance(constructorArgs);
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
    
    public WebEngineBuilder apply(java.util.function.Consumer<javafx.scene.web.WebEngine> func) {
        operations.add(func);
        return this;
    }    
    
    public  WebEngineBuilder createPopupHandler(javafx.util.Callback<javafx.scene.web.PopupFeatures, javafx.scene.web.WebEngine> handler) {
        operations.add(obj -> obj.setCreatePopupHandler(handler));
        return this;
    }    
    
    public  WebEngineBuilder onResized(javafx.event.EventHandler<javafx.scene.web.WebEvent<javafx.geometry.Rectangle2D>> handler) {
        operations.add(obj -> obj.setOnResized(handler));
        return this;
    }    
    
    public  WebEngineBuilder userAgent(java.lang.String value) {
        operations.add(obj -> obj.setUserAgent(value));
        return this;
    }    
    
    public  WebEngineBuilder confirmHandler(javafx.util.Callback<java.lang.String, java.lang.Boolean> handler) {
        operations.add(obj -> obj.setConfirmHandler(handler));
        return this;
    }    
    
    public  WebEngineBuilder promptHandler(javafx.util.Callback<javafx.scene.web.PromptData, java.lang.String> handler) {
        operations.add(obj -> obj.setPromptHandler(handler));
        return this;
    }    
    
    public  WebEngineBuilder onStatusChanged(javafx.event.EventHandler<javafx.scene.web.WebEvent<java.lang.String>> handler) {
        operations.add(obj -> obj.setOnStatusChanged(handler));
        return this;
    }    
    
    public  WebEngineBuilder javaScriptEnabled(boolean value) {
        operations.add(obj -> obj.setJavaScriptEnabled(value));
        return this;
    }    
    
    public  WebEngineBuilder userStyleSheetLocation(java.lang.String value) {
        operations.add(obj -> obj.setUserStyleSheetLocation(value));
        return this;
    }    
    
    public  WebEngineBuilder userDataDirectory(java.io.File value) {
        operations.add(obj -> obj.setUserDataDirectory(value));
        return this;
    }    
    
    public  WebEngineBuilder onVisibilityChanged(javafx.event.EventHandler<javafx.scene.web.WebEvent<java.lang.Boolean>> handler) {
        operations.add(obj -> obj.setOnVisibilityChanged(handler));
        return this;
    }    
    
    public  WebEngineBuilder onAlert(javafx.event.EventHandler<javafx.scene.web.WebEvent<java.lang.String>> handler) {
        operations.add(obj -> obj.setOnAlert(handler));
        return this;
    }    
    
    public  WebEngineBuilder onError(javafx.event.EventHandler<javafx.scene.web.WebErrorEvent> handler) {
        operations.add(obj -> obj.setOnError(handler));
        return this;
    }    
    
    public WebEngineBuilder titlePropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyStringProperty> op) {
        operations.add(obj -> op.accept(obj.titleProperty()));
        return this;
    }    
    
    public WebEngineBuilder onVisibilityChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.web.WebEvent<java.lang.Boolean>>>> op) {
        operations.add(obj -> op.accept(obj.onVisibilityChangedProperty()));
        return this;
    }    
    
    public WebEngineBuilder createPopupHandlerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.web.PopupFeatures, javafx.scene.web.WebEngine>>> op) {
        operations.add(obj -> op.accept(obj.createPopupHandlerProperty()));
        return this;
    }    
    
    public WebEngineBuilder confirmHandlerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<java.lang.String, java.lang.Boolean>>> op) {
        operations.add(obj -> op.accept(obj.confirmHandlerProperty()));
        return this;
    }    
    
    public WebEngineBuilder promptHandlerPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.web.PromptData, java.lang.String>>> op) {
        operations.add(obj -> op.accept(obj.promptHandlerProperty()));
        return this;
    }    
    
    public WebEngineBuilder locationPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyStringProperty> op) {
        operations.add(obj -> op.accept(obj.locationProperty()));
        return this;
    }    
    
    public WebEngineBuilder onErrorPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.web.WebErrorEvent>>> op) {
        operations.add(obj -> op.accept(obj.onErrorProperty()));
        return this;
    }    
    
    public WebEngineBuilder onAlertPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.web.WebEvent<java.lang.String>>>> op) {
        operations.add(obj -> op.accept(obj.onAlertProperty()));
        return this;
    }    
    
    public WebEngineBuilder documentPropertyApply(java.util.function.Consumer<javafx.beans.property.ReadOnlyObjectProperty<org.w3c.dom.Document>> op) {
        operations.add(obj -> op.accept(obj.documentProperty()));
        return this;
    }    
    
    public WebEngineBuilder onResizedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.web.WebEvent<javafx.geometry.Rectangle2D>>>> op) {
        operations.add(obj -> op.accept(obj.onResizedProperty()));
        return this;
    }    
    
    public WebEngineBuilder userAgentPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.userAgentProperty()));
        return this;
    }    
    
    public WebEngineBuilder userDataDirectoryPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<java.io.File>> op) {
        operations.add(obj -> op.accept(obj.userDataDirectoryProperty()));
        return this;
    }    
    
    public WebEngineBuilder onStatusChangedPropertyApply(java.util.function.Consumer<javafx.beans.property.ObjectProperty<javafx.event.EventHandler<javafx.scene.web.WebEvent<java.lang.String>>>> op) {
        operations.add(obj -> op.accept(obj.onStatusChangedProperty()));
        return this;
    }    
    
    public WebEngineBuilder userStyleSheetLocationPropertyApply(java.util.function.Consumer<javafx.beans.property.StringProperty> op) {
        operations.add(obj -> op.accept(obj.userStyleSheetLocationProperty()));
        return this;
    }    
    
    public WebEngineBuilder javaScriptEnabledPropertyApply(java.util.function.Consumer<javafx.beans.property.BooleanProperty> op) {
        operations.add(obj -> op.accept(obj.javaScriptEnabledProperty()));
        return this;
    }
}
