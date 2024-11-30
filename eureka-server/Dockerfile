FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/EurekaServer-0.0.1-SNAPSHOT.jar /app/EurekaServer-0.0.1-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app/EurekaServer-0.0.1-SNAPSHOT.jar"]
