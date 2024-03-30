#!/bin/sh
set -e

JAR_FILE=$(find . -name 'todolist-*.jar' | sort -V | tail -n 1)

java -jar "$JAR_FILE" --spring.profiles.active="$SPRING_PROFILE"
