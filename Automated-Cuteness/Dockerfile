#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY /target/Automated-Cuteness-0.0.1-SNAPSHOT.jar Automated-Cuteness-0.0.1-SNAPSHOT.jar
#EXPOSE 3030
#ENTRYPOINT ["java","-jar", "/target/Automated-Cuteness.jar"]

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/Automated-Cuteness-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]