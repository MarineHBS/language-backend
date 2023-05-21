package com.hbs.language;

import com.hbs.language.configuration.DynamoDBConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DynamoDBConfigurationProperties.class)
public class LanguageApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanguageApplication.class, args);
    }

}
