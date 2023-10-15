package ru.grafana.sms.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Alert {
    String status;
    Object labels;
    Object annotations;
    String startAt;
    String endsAt;
    Object values;
    String generatorURL;
    String fingerprint;
    String silenceURL;
    String dashboardURL;
    String panelURL;
    String imageURL;
}
