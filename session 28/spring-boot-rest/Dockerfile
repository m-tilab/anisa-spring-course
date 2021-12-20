FROM azul/zulu-openjdk-alpine:11
MAINTAINER mehdi tilab
COPY target/spring-boot-rest-0.0.1-SNAPSHOT.jar spring-boot-rest.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-boot-rest.jar"]