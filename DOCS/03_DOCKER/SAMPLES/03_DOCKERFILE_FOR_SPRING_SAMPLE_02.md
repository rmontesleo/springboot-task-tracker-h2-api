

```bash
# https://spring.io/guides/gs/spring-boot-docker/
# Example 2
# Name this image like  springboot-todo-h2-api-docker-spring02

# Previous build the docker image execute the following steps
# 1.  mvn clean package

FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```