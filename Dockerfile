FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B -DskipTests package

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
ENV SERVER_PORT=8080

EXPOSE ${SERVER_PORT}

# Optional: JVM tuning for containers
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]
