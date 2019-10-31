FROM openjdk:8
ADD target/JV5-BackEnd.jar JV5-BackEnd.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "JV5-BackEnd.jar"]

#docker build -f Dockerfile -t jv5-be:0.0.1 .