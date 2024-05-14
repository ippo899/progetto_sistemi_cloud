
# Utilizza una immagine base di Java per eseguire l'applicazione Spring Boot
FROM openjdk:17-alpine
# Copia il file JAR dell'applicazione nella directory /app
WORKDIR /app
COPY target/server-0.0.1-SNAPSHOT.jar /app
#ENV SERVER_PORT=8080
EXPOSE 8080
CMD ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]

