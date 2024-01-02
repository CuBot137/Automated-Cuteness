FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
ENV ACCOUNT_SID = ${Twilio_SID}
ENV AUTH_TOKEN = ${Twilio_Auth}
ENV OUTGOING_SMSNUMBER = ${TWILIO_OUTGOING_SMSNUMBER}
ENV SENDER_NUMBER = ${My_Number}
COPY ${JAR_FILE} app.jar
EXPOSE 3030
ENTRYPOINT ["java","-jar", "/app.jar"]



#COPY ./target/Automated-Cuteness-0.0.1-SNAPSHOT.jar /app.jar