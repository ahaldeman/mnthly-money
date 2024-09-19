# Use an official Gradle image with OpenJDK 21 to build the application
FROM gradle:8.10.1-jdk21-alpine AS build
WORKDIR /app
COPY --chown=gradle:gradle build.gradle.kts settings.gradle.kts ./
COPY --chown=gradle:gradle gradle ./gradle
RUN gradle assemble --no-daemon || return 0  # Run an initial build to cache dependencies

# Copy the source code to the build image
COPY --chown=gradle:gradle src ./src
RUN gradle assemble --no-daemon

# Use an official OpenJDK 21 runtime image to run the application
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
