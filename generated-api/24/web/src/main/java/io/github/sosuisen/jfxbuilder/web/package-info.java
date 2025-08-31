/**
 * JavaFX Builder API for Web module.
 * 
 * <p>This package contains fluent builder classes for JavaFX web components, enabling
 * declarative and hierarchical UI construction with strongly-typed APIs.</p>
 * 
 * <p>The builder classes in this package provide a fluent interface for creating
 * and configuring JavaFX web-related components such as WebView, WebEngine, 
 * HTMLEditor, and other web integration elements.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * WebView webView = WebViewBuilder.create()
 *     .prefWidth(800)
 *     .prefHeight(600)
 *     .build();
 * 
 * webView.getEngine().load("https://example.com");
 * }</pre>
 */
package io.github.sosuisen.jfxbuilder.web;