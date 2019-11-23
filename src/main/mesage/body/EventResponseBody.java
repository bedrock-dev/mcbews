package mesage.body;

/**
 * 订阅的事件的返回信息
 * @author AgNO3
 */
public class EventResponseBody extends Body{
    private String eventName;
    private String measurements;
    private Object properties;


    public EventResponseBody(String eventName, String measurements, Object properties) {
        this.eventName = eventName;
        this.measurements = measurements;
        this.properties = properties;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }
}
