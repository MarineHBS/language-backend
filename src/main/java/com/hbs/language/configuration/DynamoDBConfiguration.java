package com.hbs.language.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DynamoDBConfiguration {

    private final DynamoDBConfigurationProperties dynamoDBConfigurationProperties;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.eu-north-1.amazonaws.com",
                                "eu-north-1")
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(awsCredentials())
                )
                .build();
    }

    private AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(
                "AKIA2B6UZLPS2QHETKNK",
                "YJBMBbpYbZh5cNXkud0LUNYodA8+i3FJXmWeHSUy"
        );
    }
}
