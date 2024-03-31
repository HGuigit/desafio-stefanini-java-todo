#!/bin/sh
set -e

JAR_FILE=$(find . -name 'todolist-*.jar' | sort -V | tail -n 1)

if [ "$SPRING_PROFILE" = "local-completo" ]; then
    dockerize -wait tcp://sql_server:1433 -timeout 240s
    java -jar "$JAR_FILE" --spring.profiles.active="$SPRING_PROFILE"
else
    java -jar "$JAR_FILE" --spring.profiles.active="$SPRING_PROFILE"
fi