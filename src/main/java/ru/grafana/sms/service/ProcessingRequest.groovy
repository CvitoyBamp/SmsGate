package ru.grafana.sms.service

import groovy.text.GStringTemplateEngine
import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Data
import lombok.experimental.FieldDefaults
import org.springframework.context.annotation.Bean
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import ru.grafana.sms.config.GrafanaSmsConfig
import ru.grafana.sms.model.Grafana

class ProcessingRequest {

    GrafanaSmsConfig grafanaSmsConfig
    Map<String, Object> grafana

    ProcessingRequest(GrafanaSmsConfig grafanaSmsConfig, Map<String, Object> grafana) {
        this.grafanaSmsConfig = grafanaSmsConfig
        this.grafana = grafana
    }

    GrafanaSmsConfig getGrafanaSmsConfig() {
        return grafanaSmsConfig
    }

    void setGrafanaSmsConfig(GrafanaSmsConfig grafanaSmsConfig) {
        this.grafanaSmsConfig = grafanaSmsConfig
    }

    Map<String, Object> getGrafana() {
        return grafana
    }

    void setGrafana(Map<String, Object> grafana) {
        this.grafana = grafana
    }

    void templating() {
        def engine = new GStringTemplateEngine()
        def tpl = [] as String[]

        grafanaSmsConfig.smsGate.each {
            gate -> {
                def f = new File(gate.getTemplatePath())
                System.out.println(engine.createTemplate(f).make(grafana).toString())
//                tpl.add(engine.createTemplate(f).make(grafana as Map).toString())
            }
        }

//        return tpl
    }
}
