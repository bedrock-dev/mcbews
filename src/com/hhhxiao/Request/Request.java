package com.hhhxiao.Request;

import com.alibaba.fastjson.JSON;
import com.hhhxiao.Request.body.Body;
import com.hhhxiao.Request.body.Header;

public class Request {
    protected Body body;
    protected Header header;

    public Request() {
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


}
