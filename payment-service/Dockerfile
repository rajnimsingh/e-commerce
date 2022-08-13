# Getting base image
FROM amazoncorretto:11-alpine-jdk
MAINTAINER rajni ubhi <ubhi.rajni800@gmail.com>
EXPOSE 8090
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} payment-service.jar
ENTRYPOINT ["java","-jar","/payment-service.jar"]