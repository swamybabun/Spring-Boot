# Specifying the base image 
FROM openjdk:8-windowsservercore

# Maintainer information
LABEL maintainer="test@gmail.com"

#Copying the jar file from local [target directory from application] to the docker
COPY target/demo-0.0.1-SNAPSHOT.jar /demo.jar

# Port number on which our application runs
EXPOSE 8080

# Writing the command for running the application
CMD ["java", "-jar", "demo.jar"]