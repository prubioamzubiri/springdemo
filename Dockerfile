FROM eclipse-temurin:17.0.4.1_1-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./datos.txt datos.txt
COPY ./entrypoint.sh entrypoint.sh
ENTRYPOINT ["/bin/sh", "-c", "./entrypoint.sh"] 