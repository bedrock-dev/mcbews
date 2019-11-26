package com.hhhxiao.resp;

public class Response {
    protected final String rawString;

    public Response(String s){
        this.rawString  = s;
    }

    public String getRawString() {
        return rawString;
    }
}
