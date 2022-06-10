# UserService

- DescoryServer (eureka) 먼저 실행 하여야 함.


## 여러 개의 Instance 기동

```
$ mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=[포트번호]'
$ java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
```

## application.yml 데이터 가져오기

```yaml
# application.yml

test:
  message: this is test message.
```

### Enviroment 사용

```java
@RestController
public class UserController {
  private Enviroment env;
  
  @Autowired
  public UserController(Enviroment env) {
    this.env = env;
  }
  
  public String getMessage() {
      return env.getProperty("test.message");
  }
}
```

### @Value 사용

```java
@RestController
public class UserController {
    
    @Value("${test.message}")
    private String MESSAGE;
    
    public String getMessage() {
      return MESSAGE;
  }
}

// 또는 이렇게도 사용가능
@Getter @Setter
@Component
public class Test {
    @Value("${test.message}")
    private String message;
}

@RestController
public class GroupController {
    @Autowired
    private Test test;
    
    public String getMessage() {
        return test.getMessage();
    }
}
```

## 데이터 처리 개념

### RequestUser
- `Front-end` 에서 받은 `JSON Data` 를 담기 위한 자료형

### UserDto
- 데이터 내부 처리 용도 (타 서비스, 메서드 로 데이터 전달)

### UserEntity
- `DB` 와 연동되기 위한 자료형


## 기타

### ModelMapper

- Class 변환
- ex) RequestMapper -> UserDto

```java
public void test(RequestUser user){
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    UserDto userDto=mapper.map(user,UserDto.class);
}
```