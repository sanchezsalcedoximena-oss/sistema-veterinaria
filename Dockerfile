# Usar imagen con Java 17
FROM openjdk:17-jdk-slim

# Copiar el jar generado
COPY target/*.jar app.jar

# Puerto (Render usa variable PORT)
EXPOSE 8080

# Ejecutar la app
ENTRYPOINT ["java","-jar","/app.jar"]