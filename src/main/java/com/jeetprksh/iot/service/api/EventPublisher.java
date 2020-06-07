package com.jeetprksh.iot.service.api;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Jeet Prakash on 2017-10-14.
 */

@Component
public class EventPublisher {

  private MqttClient client;

  private MqttClient getBrokerClient() throws Exception {
    if (Objects.isNull(client)) {
      client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
      client.connect();
    }
    return client;
  }

  public void publishEvent(String message) throws Exception {
    MqttClient client = this.getBrokerClient();
    if (client.isConnected()) {
      MqttMessage mqttMessage = new MqttMessage();
      mqttMessage.setPayload(message.getBytes());
      this.getBrokerClient().publish("iot_data", mqttMessage);
    } else {
      throw new Exception("Not Connected to Broker");
    }
  }
}
