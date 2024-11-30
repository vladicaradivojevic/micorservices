FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/cinema-microservice-0.0.1-SNAPSHOT.jar /app/cinema-microservice-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/cinema-microservice-0.0.1-SNAPSHOT.jar"]
