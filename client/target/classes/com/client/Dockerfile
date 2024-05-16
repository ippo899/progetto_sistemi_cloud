# Utilizza una immagine base di Java per eseguire l'applicazione Spring Boot
FROM openjdk:17-alpine

# Imposta la directory di lavoro all'interno del contenitore
WORKDIR /app

# Copia il file JAR dell'applicazione nella directory /app
COPY target/client-0.0.1-SNAPSHOT.jar /app

# Imposta la variabile d'ambiente SERVER_PORT e espone la porta
#ENV SERVER_PORT=8081
EXPOSE 8081

# Comando per avviare l'applicazione quando il contenitore viene eseguito
CMD ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]
