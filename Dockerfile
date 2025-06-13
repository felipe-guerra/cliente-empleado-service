# Usa una imagen oficial de Java
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copia el JAR generado
COPY target/cliente-empleado-service-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la app (Render asigna dinámicamente, usamos ENV)
ENV PORT 8080

# Ejecuta el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
