FROM openjdk:8
EXPOSE 8090
ADD target/organisation-employee.jar organisation-employee.jar
ENTRYPOINT ["java","-jar","/organisation-employee.jar"]