# Spring Cloud Gateway

## 용어 설명

### Predicate
 - 요청 정보가 어떤 것인지 판단하는 필터

### Pre filter
 - 어떤 작업이 일어나기 전에 수행하는 사전 필터

### Post Filter
 - 어떠한 처리가 끝난 뒤 수행되는 필터

> 작업 방법은 `property (application.yml)` 로도 가능하고, `Java Code` 로도 가능함.

## 부가 설명

### application(.yml) 설정 부가 설명

```yaml
spring:
  application:
    name: apigateway-service
  cloud:
    gateway:
      routes:
        - id: first-service
          uri: http://localhost:8081/
          predicates:
            - Path=/first-service/**
        - id: second-service
          uri: http://localhost:8082/
          predicates:
            - Path=/second-service/**
```
> gateway 에서 내부 서비스로 매핑시 url 정보가 그대로 전달됨. <br>
> ex) 요청 url: http://localhost:8000/first-service/welcom <br>
>    gw -> `first-service` 요청: http://localhost:8001/first-service/welcome <br>
>  이때! `first-service` 는 `/first-service/welcome` 에 대한 매핑이 없으므로 `404 not found` 에러 발생! <br>
>  따라서 `first-service` 에서 `/` 로 되어 있는 `RequestMapping` 을 `/first-service` 로 변경 필요! <br>
> but, 위 내용은 `filter` 적용해서 해결 가능!