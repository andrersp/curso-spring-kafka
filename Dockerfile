FROM maven:3.9.2-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:17.0.7_7-jre-alpine
COPY --from=build /home/app/target/application.jar /usr/local/lib/my-app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/my-app.jar"]