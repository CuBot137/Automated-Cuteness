FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/Automated-Cuteness-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]