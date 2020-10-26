FROM openjdk:8
COPY target/sleuth-zipkin-service.jar sleuth-zipkin-service.jar
EXPOSE 9411
ENTRYPOINT ["java", "-jar", "sleuth-zipkin-service.jar"]