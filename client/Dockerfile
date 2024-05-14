# Utilizza una immagine base di Java per eseguire l'applicazione Spring Boot
FROM openjdk:17-alpine
# Copia il file JAR dell'applicazione nella directory /app
WORKDIR /app
COPY target/client-0.0.1-SNAPSHOT.jar /app
#ENV SERVER_PORT 8081
EXPOSE 8081
CMD ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]

