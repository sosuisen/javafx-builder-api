/**
 * JavaFX Builder API for Media Module.
 * 
 * <p>This package contains builder classes for JavaFX media components, enabling
 * declarative and hierarchical UI construction with strongly-typed APIs.</p>
 * 
 * <p>The builder classes in this package provide a fluent interface for creating
 * and configuring JavaFX media-related components such as MediaPlayer, MediaView,
 * AudioClip, and other multimedia elements.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * MediaView mediaView = MediaViewBuilder.create()
 *         .mediaPlayer(MediaPlayerBuilder.create(
 *                 new Media("https://xxxx/xxx.mp4"))
 *                 .autoPlay(true)
 *                 .build())
 *         .fitWidth(640)
 *         .fitHeight(480)
 *         .preserveRatio(true)
 *         .build();
 * }</pre>
 */
package io.github.sosuisen.jfxbuilder.media;