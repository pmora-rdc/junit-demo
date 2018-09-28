FROM openjdk:latest
VOLUME /tmp
ADD target/demo-0.0.1-SNAPSHOT.jar tmp/demo-0.0.1-SNAPSHOT.jar
MAINTAINER pmora@reputation.com
LABEL authors="Pablo Mora"
EXPOSE 8090
RUN chmod +x demo-0.0.1-SNAPSHOT.jar
CMD ["java", ,"-Djava.security.egd=file:/dev/./urandom", "-jar", "demo-0.0.1-SNAPSHOT.jar"]