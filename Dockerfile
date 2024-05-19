FROM openjdk:21-jdk AS build

LABEL maintainer="Alvine Llavu"

WORKDIR /var/www/html

ADD target/BankApplication-0.0.1-SNAPSHOT.jar BankApplication.jar

ENTRYPOINT ["java","-jar","BankApplication.jar"]

