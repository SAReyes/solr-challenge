FROM gradle:4.9 AS builder
COPY --chown=gradle:gradle . /opt/challenge
WORKDIR /opt/challenge
RUN gradle build

FROM openjdk:8-jre
COPY --from=builder /opt/challenge/build/libs/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
