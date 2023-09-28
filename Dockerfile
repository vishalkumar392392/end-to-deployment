# Use a base image with Java 17 (e.g., AdoptOpenJDK)
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/devops-integration.jar /app/devops-integration.jar

# Expose the port your Spring Boot application will listen on
EXPOSE 80

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "devops-integration.jar"]
