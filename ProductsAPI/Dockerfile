FROM maven:3.3.9-jdk-8-alpine as backbuild
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -B -f pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY . .
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml clean clean install spring-boot:repackage

FROM java:8-jdk-alpine
LABEL maintainer="jgaviri8@gmail.com"
WORKDIR /app
COPY --from=backbuild /usr/src/app/target/swagger-spring-1.0.0.jar .
ENTRYPOINT ["java", "-jar", "/app/swagger-spring-1.0.0.jar"]

