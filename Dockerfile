FROM amazoncorretto:17.0.6
ADD target/vatrates.jar vatrates.jar
ENTRYPOINT ["java", "-jar", "/vatrates.jar"]
