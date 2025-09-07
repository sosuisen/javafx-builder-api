#!/bin/bash
# Use -T 4 to be multithread.
mvn clean compile test -T 4 -pl api/24/controls,api/24/graphics,api/24/media,api/24/web
