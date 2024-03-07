FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file into the container at /app
COPY kotlinspring/target/kotlinspring-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
