#Stage 1 - maven package in jar
FROM maven:3.8-openjdk-17 as maven
WORKDIR /app
COPY . /app
RUN mvn install -Dmaven.test.skip=true

#Stage 2 - run project
FROM openjdk:17.0.2-jdk
WORKDIR /app
COPY --from=maven /app/target/dish-1.jar app.jar
CMD java -jar app.jar
