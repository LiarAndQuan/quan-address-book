FROM openjdk:17-jdk-alpine

ADD quan-address-book-1.0-SNAPSHOT.jar /app/

EXPOSE 30000

ENTRYPOINT ["java","-jar","/app/quan-address-book-1.0-SNAPSHOT.jar","--spring.profiles.active=prod"]
