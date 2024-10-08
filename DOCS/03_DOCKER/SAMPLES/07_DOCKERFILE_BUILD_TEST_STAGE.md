

```bash
# https://docs.docker.com/language/java/build-images/
# Name this image like  springboot-todo-h2-api-docker-test


FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

FROM base as test
CMD ["./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run"]


FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8080
COPY --from=build /app/target/task-tracker-docker.jar /task-tracker-docker.jar
ENTRYPOINT ["java", "-jar", "task-tracker-docker.jar" ]
```