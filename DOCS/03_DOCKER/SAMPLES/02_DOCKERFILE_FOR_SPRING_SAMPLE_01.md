

```bash
# https://spring.io/guides/gs/spring-boot-docker/
# Example 1. Dockerfile

# Name this image like  springboot-todo-h2-api-docker-spring01
# Previous build the docker image execute the following steps
# 1.  mvn clean package

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```