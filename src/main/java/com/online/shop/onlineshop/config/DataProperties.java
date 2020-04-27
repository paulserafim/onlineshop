package com.online.shop.onlineshop.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "data")
@PropertySource("classpath:data.properties")
@Getter
@Setter
public class DataProperties {
    private String productDataPath;
}
