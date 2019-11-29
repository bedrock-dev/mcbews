package com.hhhxiao.resp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hhhxiao.Request.body.BodyException;

import java.util.HashMap;
import java.util.List;

/**
 * 执行命令后的返回信息
 */
public class CommandResponse {
    private final int statusCode;
    private final String statusMessage;
    private final JSONObject body;

    public CommandResponse(JSONObject body) {
        this.body = body;
        statusCode = body.getIntValue("statusCode");
        statusMessage = body.getString("statusMessage");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }


    //clear 指令
    public HashMap<String, Integer> getClearNum() {
        JSONArray itemNum = body.getJSONArray("itemsRemoved");
        JSONArray playerName = body.getJSONArray("player");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < itemNum.size(); i++)
            hashMap.put(itemNum.getString(i), playerName.getIntValue(i));
        return hashMap;
    }

    //clone指令复制的方块数量
    public int getCloneCount() {
        return body.getIntValue("count");
    }

    //受到影响的玩家列表 clear effect
    public List<String> getPlayerList() {
        return body.getJSONArray("player").toJavaList(String.class);
    }

    //执行附魔指令的时候返回手上没有物品的玩家列表
    public List<String> getNoItemNames() {
        return body.getJSONArray("noItemNames").toJavaList(String.class);
    }

    //effect指令的秒数
    public int getEffectSeconds() {
        return body.getIntValue("seconds");
    }

    public int getFillCount() {
        return body.getIntValue("fillCount");
    }

    //kill
    public HashMap<String, Integer> getTargetName() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        JSONArray array = body.getJSONArray("targetname");
        for (int i = 0; i < array.size(); ++i) {
            String key = array.getString(i);
            if (hashMap.containsKey(key)) {
                int num = hashMap.remove(key);
                hashMap.put(key, num + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        return hashMap;
    }

    //list
    public int getCurrentPlayerCount() {
        return body.getIntValue("currentPlayerCount");
    }

    //locate
    public int[] getFeaturePos() {
        JSONObject o = body.getJSONObject("destination");
        int[] position = new int[3];
        position[0] = o.getIntValue("x");
        position[1] = o.getIntValue("y");
        position[2] = o.getIntValue("z");
        return position;
    }


}
