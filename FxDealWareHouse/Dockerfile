FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
copy target/*.jar /opt/app.jar
CMD ["java", "-jar", "app.jar"]