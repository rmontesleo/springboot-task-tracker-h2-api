

```bash
# https://docs.docker.com/language/java/build-images/
# Name this image like  springboot-todo-h2-api-docker-build

FROM openjdk:17-alpine3.13

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
```