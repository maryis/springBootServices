#sudo docker build -t my-config-server:1.0 -f ./Dockerfile .
FROM openjdk:8-jdk-alpine
COPY target/*.jar app.jar
EXPOSE 8888:8888
ENTRYPOINT ["java","-jar","app.jar"]