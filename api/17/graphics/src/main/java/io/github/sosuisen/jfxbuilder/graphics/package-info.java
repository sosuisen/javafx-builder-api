/**
 * JavaFX Builder API for Graphics Module.
 * 
 * <p>This package contains builder classes for JavaFX graphics components, enabling
 * declarative and hierarchical UI construction with strongly-typed APIs.</p>
 * 
 * <p>The builder classes in this package provide a fluent interface for creating
 * and configuring JavaFX graphics elements such as shapes, layouts, effects, 
 * transformations, and other visual components.</p>
 * 
 * <p>Example usage:</p>
 * {@snippet :
 * Circle circle = CircleBuilder.create()
 *     .centerX(50)
 *     .centerY(50)
 *     .radius(25)
 *     .fill(Color.BLUE)
 *     .build();
 * }
 */
package io.github.sosuisen.jfxbuilder.graphics;
