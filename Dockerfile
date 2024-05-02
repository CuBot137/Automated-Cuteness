#FROM maven:3.9.6 as builder
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
#FROM eclipse-temurin:17.0.11_9-jre-focal
#COPY --from=builder /app/target/Automated-Cuteness-0.0.2-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]


# Use Maven to build the application
FROM maven:3.9.6 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use a Google Cloud Platform base image for running the application
FROM gcr.io/distroless/java:11
WORKDIR /app
COPY --from=builder /app/target/Automated-Cuteness-0.0.2-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
