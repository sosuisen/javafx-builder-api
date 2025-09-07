#!/bin/bash
# Use -T 4 to be multithread.
# package phase is needed to generate javadoc of modular project.
mvn clean package javadoc:javadoc -Dmaven.test.skip=true -T 4 -pl api-24/controls,api-24/graphics,api-24/media,api-24/web
