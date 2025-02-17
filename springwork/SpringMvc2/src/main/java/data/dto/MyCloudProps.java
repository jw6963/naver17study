package data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = "naver.cloud")
@PropertySource("classpath:/ncp.properties")
public class MyCloudProps {
    private String db;
    private String username;
    private String password;
}
