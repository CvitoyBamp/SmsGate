package ru.grafana.sms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Grafana implements Serializable {
    String receiver;
    String status;
    int orgId;
    ArrayList<Alert> alerts;
    Object groupLabels;
    Object commonLabels;
    Object commonAnnotations;
    String externalURL;
    String version;
    String groupKey;
    int truncatedAlerts;
    String title;
    String state;
    String message;
}
