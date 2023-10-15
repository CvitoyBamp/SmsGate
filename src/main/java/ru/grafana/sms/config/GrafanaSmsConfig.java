package ru.grafana.sms.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "sms-sender")
@PropertySource("classpath:application.yaml")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GrafanaSmsConfig {

    List<SmsGate> smsGate = new ArrayList<>();
    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class SmsGate {
        String host;
        String clientCert;
        String keyCert;
        String caCert;
        String[] numbers;
        String templatePath;
    }
}
