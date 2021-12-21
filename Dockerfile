FROM alpine:3.15
RUN apk add openjdk13
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./datos.txt datos.txt
ENTRYPOINT ["java","-jar","/app.jar"]