package com.jeetprksh.iot.service.controller;

import com.jeetprksh.iot.pojo.GenericResponse;
import com.jeetprksh.iot.service.api.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jeet Prakash on 2017-10-14.
 */

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    EventService eventService;

    @RequestMapping(path = "/event", method = RequestMethod.POST)
    public @ResponseBody
    GenericResponse triggerEvent(@RequestParam("name") String eventName) {
        try {
            return eventService.triggerEvent(eventName);
        } catch (Exception ex) {
            ex.printStackTrace();
            GenericResponse response = new GenericResponse();
            response.setMessage("Unexpected Error Occurred");
            return response;
        }
    }

}
