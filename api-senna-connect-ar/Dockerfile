FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/api-senna-connect-ar-0.0.1.jar
COPY ${JAR_FILE} app_senna_connect_ar.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app_senna_connect_ar.jar" ]