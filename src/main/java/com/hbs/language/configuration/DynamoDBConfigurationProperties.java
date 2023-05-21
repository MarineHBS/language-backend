package com.hbs.language.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dynamodb")
public record DynamoDBConfigurationProperties(String serviceEndpoint, String signingRegion, String accessKey,
                                              String secretKey) {
}
