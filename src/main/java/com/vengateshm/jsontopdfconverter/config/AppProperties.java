package com.vengateshm.jsontopdfconverter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app")
public class AppProperties {
    private String name;
    private String author;
}
