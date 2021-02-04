FROM openjdk:8-jre-slim
RUN ./gradlew build
ARG build/libs/lots-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=gcp","app.jar"]
EXPOSE 8080