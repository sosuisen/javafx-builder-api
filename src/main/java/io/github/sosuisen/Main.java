package io.github.sosuisen;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Main {

    public static void main(String[] args) {
        try {
            BuilderClassGenerator generator = new BuilderClassGenerator();
            generator.generate(Button.class);
            generator.generate(Scene.class);
            generator.generate(VBox.class);
            generator.generate(BorderPane.class);
            generator.generate(ListView.class);
        } catch (IOException e) {
            System.err.println("Error generating builder class: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
