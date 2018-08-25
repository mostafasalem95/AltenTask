FROM openjdk
MAINTAINER Mostafa Salem <mostafasalem95@gmail.com>
ADD target/vehicles-config-service 0.0.1.jar vehicles-config-service-0.0.1.jar
ADD config-repo $HOME/config-repo
ENTRYPOINT ["java", "-jar", "/vehicles-config-service 0.0.1.jar"]
EXPOSE 9000