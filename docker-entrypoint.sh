#!/bin/bash

JAVA_OPTS=${JAVA_OPTS}

if [ -n "${JAVA_DEBUG_PORT}" ]; then
  export JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=0.0.0.0:${JAVA_DEBUG_PORT}"
fi

export JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom"
export JAVA_OPTS="$JAVA_OPTS --add-opens java.base/java.lang=ALL-UNNAMED"
export JAVA_OPTS="$JAVA_OPTS -XX:+UseContainerSupport"
export JAVA_OPTS="$JAVA_OPTS -XX:+AlwaysActAsServerClassMachine"
export JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/opt/dumps"

echo "Executing: java ${JAVA_OPTS} -jar /app/yals.jar"

exec java ${JAVA_OPTS} -jar /app/yals.jar
