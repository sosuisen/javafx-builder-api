package com.example;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        outputButtonMethodSignatures();
       
    }

    private void outputButtonMethodSignatures() {
        System.out.println("Public method signatures of JavaFX Button class:");
        System.out.println("================================================");
        
        Method[] methods = Button.class.getMethods();
        for (Method method : methods) {
            StringBuilder signature = new StringBuilder();
            signature.append(method.getReturnType().getSimpleName()).append(" ");
            signature.append(method.getName()).append("(");
            
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter param = parameters[i];
                signature.append(param.getType().getSimpleName());
                signature.append(" ").append(param.getName());
                if (i < parameters.length - 1) {
                    signature.append(", ");
                }
            }
            signature.append(")");
            
            System.out.println(signature.toString());
        }
        
        System.out.println("================================================");
        System.out.println("Total public methods: " + methods.length);
    }

}
