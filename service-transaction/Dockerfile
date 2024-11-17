FROM openjdk:17
VOLUME [ "/tmp" ]
ADD target/service-transaction.jar service-transaction.jar 
ENTRYPOINT [ "java","-jar","/service-transaction.jar" ]