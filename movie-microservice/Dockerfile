FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/movie-microservice-0.0.1-SNAPSHOT.jar /app/movie-microservice-0.0.1-SNAPSHOT.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app/movie-microservice-0.0.1-SNAPSHOT.jar"]
