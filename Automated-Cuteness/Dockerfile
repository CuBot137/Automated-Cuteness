FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
ENV ACCOUNT_SID = ${Twilio_SID}
ENV AUTH_TOKEN = ${Twilio_Auth}
ENV OUTGOING_SMSNUMBER = ${TWILIO_OUTGOING_SMSNUMBER}
ENV SENDER_NUMBER = ${My_Number}
COPY ./target/Automated-Cuteness-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/app.jar"]
