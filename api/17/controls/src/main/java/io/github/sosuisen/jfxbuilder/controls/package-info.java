/**
 * JavaFX Builder API for Controls Module.
 * 
 * <p>This package contains builder classes for JavaFX controls, enabling
 * declarative and hierarchical UI construction with strongly-typed APIs.</p>
 * 
 * <p>The builder classes in this package provide a fluent interface for creating
 * and configuring JavaFX UI controls such as buttons, text fields, lists, tables,
 * charts, and other interactive components.</p>
 * 
 * <p>Example usage:</p>
 * {@snippet :
 * Button button = ButtonBuilder.create()
 *     .text("Click Me")
 *     .onAction(e -> System.out.println("Button clicked!"))
 *     .prefWidth(100)
 *     .build();
 * }
 */
package io.github.sosuisen.jfxbuilder.controls;
