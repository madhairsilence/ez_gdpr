## Sample source code to implement encryption in Spring boot application

This source code has two implementations , to encrypt data.
- AOP Based implements, where encryption happens in Controller level
- Entity attribute based implementation , where database objects are encrypted at field level

#### Tool / Techniques Used
- AOP , Interception pattern
- Custom Jackson Serialization

#### Note
- Only Mock Encryption Code is provided. It should be replaced with actual encryption

### How to Run this app
```
mvn clean compile springb-boot:run
```

### Access URL/APIs
``` 
http://localhost:8080/user - AOP Implementation
http://localhost:8080/piiuser - Attribute Convertor implementation
http://localhost:8080/h2-console - H2 DB Console
```