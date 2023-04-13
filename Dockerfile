FROM openjdk:8-jdk-alpine
WORKDIR /app
ARG JAR_FILE=*.jar
COPY targer/${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
