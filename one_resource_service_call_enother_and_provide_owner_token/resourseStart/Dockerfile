FROM openjdk:17

COPY ./target/client-0.0.1-SNAPSHOT.jar /usr/src/app.jar
WORKDIR /usr/src

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
