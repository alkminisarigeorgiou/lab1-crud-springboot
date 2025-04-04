# Use official OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy built JAR into containers
COPY target/mars-crud-*.jar app.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]