package com.jeetprksh.iot.service.api;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

/**
 * Created by Jeet Prakash on 2017-10-14.
 */

@Component
public class EventPublisher {

    private MqttClient client;

    public MqttClient getPublisher() throws Exception {
        if (client != null) {
            return client;
        } else {
            client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
            client.connect();
            return client;
        }
    }

    public void publishEvent(String message) throws Exception {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(message.getBytes());
        this.getPublisher().publish("iot_data", mqttMessage);
    }
}
