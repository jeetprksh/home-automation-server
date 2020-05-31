package com.jeetprksh.iot.service.api;

import com.jeetprksh.iot.pojo.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Jeet Prakash on 2017-10-14.
 */

@Component
public class EventService {

    @Autowired EventPublisher eventPublisher;
    private final String[] validEvents = {"lights-off", "lights-on"};

    public GenericResponse triggerEvent(String eventName) throws Exception {
        GenericResponse response = new GenericResponse();
        if (Arrays.asList(validEvents).contains(eventName)) {
            eventPublisher.publishEvent(eventName);
            response.setStatus(true);
            return response;
        } else {
            response.setMessage("Invalid event name.");
            return response;
        }
    }

}
