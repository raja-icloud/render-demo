# ---------- Stage 1: Build the app ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy everything
COPY . .

# Build jar inside container
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run the app ----------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
