FROM openjdk:17-alpine
ARG JAR_FILE=target/Serviceforcv-0.0.1-SNAPSHOT.jar
RUN mkdir /service
WORKDIR /service
COPY ${JAR_FILE} /service
ENTRYPOINT java -jar /service/Serviceforcv-0.0.1-SNAPSHOT.jar