package me.schedule.framework.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class SystemStartEvent {

    private String eventName;
    private String msg;

    public String getEventName() {
        return eventName;
    }

    public SystemStartEvent setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SystemStartEvent setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static SystemStartEvent factory(){
        return new SystemStartEvent();
    }
}
