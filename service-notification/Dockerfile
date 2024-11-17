FROM openjdk:17
VOLUME [ "/tmp" ]
ADD target/service-notification.jar service-notification.jar 
ENTRYPOINT [ "java","-jar","/service-notification.jar" ]