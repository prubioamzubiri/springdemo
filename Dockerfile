FROM adoptopenjdk/openjdk13:jre-13.0.2_8-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./datos.txt datos.txt
COPY ./entrypoint.sh entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["/bin/sh", "-c", "./entrypoint.sh"] 