FROM openjdk:17-oracle
VOLUME /tmp
COPY target/ressources-service-0.0.1-SNAPSHOT.jar ressources-service.jar
ENTRYPOINT ["java","-jar","/ressources-service.jar"]