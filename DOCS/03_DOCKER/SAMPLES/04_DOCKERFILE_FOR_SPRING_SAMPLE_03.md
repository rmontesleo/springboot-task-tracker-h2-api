

```bash
# https://spring.io/guides/gs/spring-boot-docker/
# Example 2
# Name this image like  springboot-todo-h2-api-docker-spring03

# Previous build the docker image execute the following steps
# 1.  mvn clean package
# 2.  mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.demo.task.tracker.TaskTrackerApplication"]
```