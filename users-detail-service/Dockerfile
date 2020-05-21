FROM openjdk:8
COPY ./users-detail-service/target/users-detail-service-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "/app.jar"]
