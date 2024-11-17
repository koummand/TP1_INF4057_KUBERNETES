FROM openjdk:17
VOLUME [ "/tmp" ]
ADD target/service-compte.jar service-compte.jar 
ENTRYPOINT [ "java","-jar","/service-compte.jar" ]