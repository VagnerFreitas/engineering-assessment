FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
#RUN #mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package -DskipTests
COPY target/*.jar /app/application.jar

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]
