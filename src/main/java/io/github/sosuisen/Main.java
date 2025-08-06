package io.github.sosuisen;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Main {

  public static void main(String[] args) {
    try {
      BuilderClassGenerator generator = new BuilderClassGenerator();
      generator.generate(Button.class);
      generator.generate(Scene.class);
    } catch (IOException e) {
      System.err.println("Error generating builder class: " + e.getMessage());
      e.printStackTrace();
    }
  }

}
