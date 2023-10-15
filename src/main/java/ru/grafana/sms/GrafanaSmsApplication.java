package ru.grafana.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.grafana.sms.config.GrafanaSmsConfig;

@SpringBootApplication
@EnableConfigurationProperties(GrafanaSmsConfig.class)
public class GrafanaSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrafanaSmsApplication.class, args);
    }

}
