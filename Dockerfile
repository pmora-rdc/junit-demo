FROM openjdk:latest
ADD target/demo-0.0.1-SNAPSHOT.jar tmp/demo-0.0.1-SNAPSHOT.jar
MAINTAINER pmora@reputation.com
LABEL authors="Pablo Mora"
WORKDIR /tmp
RUN chmod +x demo-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]