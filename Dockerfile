# ── Build stage ──
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copy pom.xml first so dependency downloads are cached between builds
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# ── Runtime stage ──
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/temple-backend-1.0.0.jar app.jar

# Render sets PORT at runtime; application.yml already reads it via
# server.port=${PORT:8080}
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]