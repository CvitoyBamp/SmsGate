package ru.grafana.sms.service

import groovy.json.JsonSlurper
import groovy.text.GStringTemplateEngine
import groovy.json.JsonOutput
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
    Grafana grafana

    ProcessingRequest(GrafanaSmsConfig grafanaSmsConfig, Grafana grafana) {
        this.grafanaSmsConfig = grafanaSmsConfig
        this.grafana = grafana
    }

    GrafanaSmsConfig getGrafanaSmsConfig() {
        return grafanaSmsConfig
    }

    void setGrafanaSmsConfig(GrafanaSmsConfig grafanaSmsConfig) {
        this.grafanaSmsConfig = grafanaSmsConfig
    }

    Grafana getGrafana() {
        return grafana
    }

    void setGrafana(Grafana grafana) {
        this.grafana = grafana
    }

    void templating() {
        def engine = new GStringTemplateEngine()
        def jsonSlurper = new JsonSlurper()
        def json = jsonSlurper.parseText(JsonOutput.toJson(grafana)) as Map

        grafanaSmsConfig.smsGate.each {
            gate -> {
                def f = "${new File(gate.getTemplatePath()).getText('UTF-8')}"
                System.out.println(engine.createTemplate(f).make(json).toString())
//                tpl.add(engine.createTemplate(f).make(grafana as Map).toString())
            }
        }

//        return tpl
    }
}
