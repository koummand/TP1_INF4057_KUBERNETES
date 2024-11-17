FROM openjdk:17
VOLUME [ "/tmp" ]
ADD target/service-banque.jar service-banque.jar 
ENTRYPOINT [ "java","-jar","/service-banque.jar" ]