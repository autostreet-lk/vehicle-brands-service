FROM openjdk:12
LABEL maintainer="chathurangat@gmail.com"
WORKDIR /app
EXPOSE 8083
COPY target/vehicle-brand-service.jar /app/vehicle-brand-service.jar
ENTRYPOINT ["java","-jar","vehicle-brand-service.jar"]