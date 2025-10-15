package com.empoyees.webapp.repository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;
@Configuration
@ConfigurationProperties(prefix = "com.employees.webapp")
@Data
public class CustomProperties {
    private String apiUrl;
    @PostConstruct
    public void init() {
        System.out.println("✅ API URL loaded: " + apiUrl);
    }

}