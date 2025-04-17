FROM openjdk:21-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y maven

COPY . /app

RUN mvn clean install -DskipTests

CMD ["java", "-jar", "target/todoListSqlite-0.0.1-SNAPSHOT.jar"]