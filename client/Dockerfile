# Étape 1 : Construire le projet avec Maven
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Utiliser une image légère pour exécuter l'application
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/client-service.jar ./client-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "client-service.jar"]
