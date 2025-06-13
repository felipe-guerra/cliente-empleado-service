# Etapa de build (compila el JAR dentro de la imagen)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# ⇩ usa el nombre real del JAR o un comodín
COPY --from=build /app/target/cliente-empleado-service-1.0-SNAPSHOT.jar app.jar
# (o) COPY --from=build /app/target/*.jar app.jar
ENV PORT 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
