FROM openjdk:17
VOLUME [ "/tmp" ]
ADD target/service-demande.jar service-demande.jar 
ENTRYPOINT [ "java","-jar","/service-demande.jar" ]