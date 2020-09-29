FROM maven:3.6.3-jdk-14 AS JAVA_BUILD
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package -PnoTesting

FROM openjdk:14-jdk
VOLUME /tmp

COPY --from=JAVA_BUILD /tmp/target/yals.jar /app/
COPY ./docker-entrypoint.sh /
RUN sh -c 'chmod +x /docker-entrypoint.sh'
RUN sh -c 'microdnf -y update  && microdnf install -y curl jq && microdnf -y clean all'

ENTRYPOINT ./docker-entrypoint.sh

EXPOSE 8080

HEALTHCHECK --start-period=60s --interval=5s --timeout=20s --retries=3 \
   CMD curl --silent --request GET http://127.0.0.1:8080/actuator/health \
                   | jq --exit-status '.status == "UP"' || exit 1
