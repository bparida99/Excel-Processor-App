FROM openjdk:21
WORKDIR /data/app
COPY target/Excel-Processor-App-0.0.1-SNAPSHOT.jar /data/app/Excel-Processor-App-0.0.1-SNAPSHOT.jar
COPY src/main/resources/students.csv /data/app/students.csv
EXPOSE 8080

CMD java \
    -XX:+UseContainerSupport \
    -Xmx1024m \
    -jar Excel-Processor-App-0.0.1-SNAPSHOT.jar \

