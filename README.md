# JavaFX Builder API Generator

A Maven-based tool that generates fluent builder APIs for JavaFX components by analyzing JavaFX SDK and creating corresponding builder classes.

## Overview

This project generates builder pattern implementations for JavaFX UI components, facilitating the creation of JavaFX applications with a fluent, declarative API. The UI code written using the builder API can represent nested structures that reflect nested UI components.

## Features

- **Automatic Builder Generation**: Creates builder classes for JavaFX controls, graphics, media, and web components.
- **JavaFX 24 Support**: Currently supports JavaFX 24.0.0
- **Modular Architecture**: Separates builders into logical modules (controls, graphics, media, web).
- **Template-based Generation**: Utilizes JTE (Java Template Engine) for flexible code generation.
- **Maven Integration**: Offers full Maven build lifecycle support with profiles for different modules.

## Use generator

This Builder API is planned for publication to Maven Central but is not yet available. Currently, you need to install it in your local repository to use it.

To generate it yourself, please see the instructions in [Generate builder classes](./docs/BUILD.md).

## Builder API

Refer [Builder API](./docs/API.md).


