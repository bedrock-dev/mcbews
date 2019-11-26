package com.hhhxiao.resp;

import com.alibaba.fastjson.JSONObject;
import com.hhhxiao.Request.body.BodyException;

/**
 * 用于解析订阅事件返回的信息的接口
 * @author AgNO3
 */
public class EventResponse extends Response {
    private final String eventName;
    private final JSONObject properties;
    private final JSONObject measurements;

    public EventResponse(String s) throws BodyException {
        super(s);
        JSONObject body = JSONObject.parseObject(s).getJSONObject("body");
        if(!body.containsKey("eventName"))
            throw new BodyException("Not a EventResponse");
         this.eventName = body.getString("eventName");
         this.properties = body.getJSONObject("properties");
         this.measurements = body.getJSONObject("properties");
    }

    public String getEventName(){
        return eventName;
    }

    /**
     * @param key 键名
     * @return 返回键对应的值
     */
    public Object getProperties(String key) {
        return properties.get(key);
    }
    //所有消息都通用的方法
    public int getBiome() {
        return properties.getIntValue("Biome");
    }

    public String getBuildVersion() {
        return properties.getString("Build");
    }


    public int getMode() {
        return properties.getInteger("Mode");
    }

    public int getPlayerGameMode() {
        return properties.getInteger("PlayerGameMode");
    }

    public String getPlat() {
        return properties.getString("Plat");
    }

    public String getEditionType() {
        return properties.getString("editionType");
    }


    public String getLocal() {
        return properties.getString("local");
    }

    public int getDim(){
        return properties.getIntValue("Dim");
    }

    //下面是部分消息独占的方法


    //BlockBroken
    //BlockPlaced

    /**
     * @return 放置或者破坏的方块的名字 | 玩家弹起的方块名字(床或者史莱姆方块)
     */
    public String getBlockName() {
        return properties.getString("Block");
    }

    //BossKilled

    /**
     * @return 杀掉的boss的实体id
     */
    public int getBossType(){
        return properties.getInteger("BossType");
    }




    //PlayerMessage

    /**
     * @return 玩家和websocket服务器发送的消息
     */
    public String getMessage() {
        return properties.getString("Message");
    }

    //CauldronUsed

    /**
     * @return 使用炼药锅时候的level??
     */
    public int getCauldronLevel(){
        return properties.getInteger("CauldronLevel");
    }

    /**
     * @return 炼药锅相关，猜测是染色
     */
    public int getCauldronDyeColor(){
        return properties.getInteger("DyeColor");
    }

    /**
     * @return 炼药锅相关，猜测是和炼药锅交互的物品的
     */
    public String getCauldronItemId(){
        return properties.getString("ItemUsedId");
    }
    //CraftingSessionCompleted

    /**
     * @return 关闭合成页面的时候是否使用合成台
     */
    public boolean isUsedCraftingTable(){
        return properties.getBoolean("UsedCraftingTable");
    }

    //EntitySpawned

    /**
     * @return 玩家使用/summon指令生成的生物的实体id | 玩家杀死的生物的id
     *  | 杀死玩家的生物id
     */
    public int getMobType(){
        return properties.getInteger("MobType");
    }

    /**
     * @return 捡到的物品的名字 | 合成的物品的名字 |掉落的物品的名字
     *          从熔炉中取出的物品的名字 | 使用物品时候的物品名字
     */
    public String getItemType(){
        return properties.getString("Type");
    }

    /**
     * @return 玩家杀死的是否为怪物
     */
    public boolean isMonster(){
        return properties.getBoolean("IsMonster");
    }

    /**
     * @return 杀死生物的方式??
     */
    public int getKillMethodType(){
        return properties.getInteger("KillMethodType");
    }

    /**
     * @return 杀死生物使用的武器
     */
    public int getWeaponType(){
        return properties.getInteger("WeaponType");
    }

    /**
     * @return 玩家死亡原因
     */
    public int getDiedCause(){
        return properties.getInteger("Cause");
    }

    /**
     * @return 发消息的玩家名字
     */
    public String getSenderName() {
        return properties.getString("Sender");
    }

    /**
     * @return 玩家传送的距离
     */
    public double getMetersTravelled(){
        return properties.getDoubleValue("MetersTravelled");
    }


    /**
     * @return 玩家x轴坐标 仅PlayerTransform事件可用
     */
    public double getX(){
        return properties.getDouble("PosX");
    }

    /**
     * @return 玩家y轴坐标 仅PlayerTransform事件可用
     */
    public double getY(){
        return properties.getDoubleValue("PosY");
    }

    /**
     * @return 玩家z轴坐标 仅PlayerTransform事件可用
     */
    public double getZ(){
        return properties.getDoubleValue("PosZ");
    }

    /**
     * @return 玩家使用传送门要去的维度
     */
    public int getToDim(){
        return properties.getIntValue("Dim");
    }


}
