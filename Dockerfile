FROM khipu/openjdk17-alpine:latest
ARG JAR_FILE_PATH=build/libs/kream-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} app.jar
COPY build/resources build/resources
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
EXPOSE 5432
#RUN sudo apt update
#ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]



