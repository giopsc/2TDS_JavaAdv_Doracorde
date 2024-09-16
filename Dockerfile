FROM maven:3.8.8-amazoncorretto

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

FROM openjdk:17-jdk

WORKDIR /app

COPY target/Doracorde-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]