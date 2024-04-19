FROM openjdk:17-jdk-oracle
COPY target/ads-0.0.1-SNAPSHOT.jar ads.jar
ENTRYPOINT ["java","-jar","ads.jar"]