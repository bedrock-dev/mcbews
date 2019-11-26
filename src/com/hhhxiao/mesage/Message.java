package mesage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mesage.body.Body;
import mesage.body.CommandResponseBody;
import mesage.body.EventResponseBody;

public class Message {
    protected Body body;
    protected Header header;

    public Message() {
    }

    public String toJSONString(){
        return JSON.toJSONString(this);
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    static Message p(String s){
        JSONObject object = JSON.parseObject(s);
        if(!object.containsKey("body") || !object.containsKey("header"))
            return null;
        Body responseBody = null;
        JSONObject bodyObject = object.getJSONObject("body");
        if(bodyObject.containsKey("statusCode")){
            responseBody = JSON.parseObject(bodyObject.toJSONString(), CommandResponseBody.class);
        }else if(bodyObject.containsKey("eventName")){
            responseBody = JSON.parseObject(bodyObject.toJSONString(), EventResponseBody.class);
        }
        Header header = JSON.parseObject(object.getJSONObject("header").toJSONString(),Header.class);
        Message message = new Message();
        message.setHeader(header);
        message.setBody(responseBody);
        return message;

    }

}
