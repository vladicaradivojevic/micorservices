FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/user-microservice-0.0.1-SNAPSHOT.jar /app/user-microservice-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/user-microservice-0.0.1-SNAPSHOT.jar"]
