FROM openjdk:14-alpine
COPY build/libs/challenge-bit-*-all.jar challenge-bit.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "challenge-bit.jar"]