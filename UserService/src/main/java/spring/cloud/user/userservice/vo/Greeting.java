package spring.cloud.user.userservice.vo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * application.yml 의 greeting 을 가져오기 위한 Value Object
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Greeting {

    @Value("${greeting.message}")
    private String message;

}
