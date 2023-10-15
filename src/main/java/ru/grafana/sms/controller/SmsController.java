package ru.grafana.sms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.grafana.sms.config.GrafanaSmsConfig;
import ru.grafana.sms.model.Grafana;
import ru.grafana.sms.service.ProcessingRequest;

import java.util.Map;

@Slf4j
@RestController
public class SmsController {

    @Autowired
    private GrafanaSmsConfig grafanaSmsConfig;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody Grafana grafana) {
        new ProcessingRequest(grafanaSmsConfig, grafana).templating();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
