### Test Framework for testing API 

#### Tests are created for https://generator.swagger.io/
&nbsp;
##### Endpoints:
##### https://generator.swagger.io/#/clients/clientOptions
##### https://generator.swagger.io/#/servers/serverOptions
##### https://generator.swagger.io/api/gen/clients/java
&nbsp;
##### Command line to pass environment variables 
##### mvn clean test -DpropertyMode=test
&nbsp;
##### If propertyMode is not defined in command line, 
##### then tests'll be triggered for environment saved in mode.properties file 