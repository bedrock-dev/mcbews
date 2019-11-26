package com.hhhxiao.Request.body;

public class EventRequestBody extends  Body {
    private String eventName;

    public EventRequestBody(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
