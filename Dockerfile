FROM openjdk:11
LABEL maintainer="Alvine Llavu"

ADD target/BankApplication-0.0.1-SNAPSHOT.jar BankApplication.jar
ENTRYPOINT ["java","-jar","BankApplication.jar"]