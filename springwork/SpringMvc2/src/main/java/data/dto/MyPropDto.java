package data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:/application.properties") // application.properties인 경우 생략 가능
@ConfigurationProperties(prefix = "emp")
@Data
@Configuration // 설정 파일로 bean 등록
public class MyPropDto {
    private String addr;
    private String hp;
}
