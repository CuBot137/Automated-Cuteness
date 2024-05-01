#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/Automated-Cuteness-0.0.2-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]

# Stage 1: Build the JAR file
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Create the Docker image
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/app/target/Automated-Cuteness-0.0.2-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]