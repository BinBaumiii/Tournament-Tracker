FROM gradle:jdk21-jammy AS build
WORKDIR /home/gradle/project

# Alles kopieren
COPY --chown=gradle:gradle . .

# Gradlew ausführbar machen
RUN chmod +x ./gradlew

# Build mit Wrapper
RUN ./gradlew build --no-daemon -x test

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
