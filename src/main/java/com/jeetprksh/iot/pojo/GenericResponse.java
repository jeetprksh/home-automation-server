package com.jeetprksh.iot.pojo;

/**
 * Created by Jeet Prakash on 2017-10-14.
 */
public class GenericResponse {

    private boolean status;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
