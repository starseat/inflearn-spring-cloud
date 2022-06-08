# FirstApiService

## 여러 개의 Instance 기동

```
1) VM Options -> -Dserver.port=[다른포트]

2) $ mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=[다른포트]'

3)
$ mvn clean compile package
$ java -jar -Dserver.port=[다른포트] ./target/first-api-service-0.0.1-SNAPSHOT.jar
```