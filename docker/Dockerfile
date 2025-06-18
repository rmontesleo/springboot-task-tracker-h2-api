FROM eclipse-temurin:17-jdk-alpine AS base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x  mvnw
RUN ./mvnw dependency:resolve
COPY src ./src

FROM base AS test
CMD ["./mvnw", "test"]

FROM base AS development
CMD ["./mvnw", "spring-boot:run"]


FROM base AS build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine AS production
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 8080
COPY --from=build /app/target/springboot-task-tracker-h2-api.jar /home/spring/springboot-task-tracker-h2-api.jar
ENTRYPOINT ["java", "-jar", "/home/spring/springboot-task-tracker-h2-api.jar" ]