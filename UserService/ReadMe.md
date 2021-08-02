# 여러 개의 Instance 기동
```
$ mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=[포트번호]'
$ java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
```
