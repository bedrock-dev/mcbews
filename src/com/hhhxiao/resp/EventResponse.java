package com.hhhxiao.resp;

import com.alibaba.fastjson.JSONObject;
import com.hhhxiao.Request.body.BodyException;

/**
 * ���ڽ��������¼����ص���Ϣ�Ľӿ�
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
     * @param key ����
     * @return ���ؼ���Ӧ��ֵ
     */
    public Object getProperties(String key) {
        return properties.get(key);
    }
    //������Ϣ��ͨ�õķ���
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

    //�����ǲ�����Ϣ��ռ�ķ���


    //BlockBroken
    //BlockPlaced

    /**
     * @return ���û����ƻ��ķ�������� | ��ҵ���ķ�������(������ʷ��ķ����)
     */
    public String getBlockName() {
        return properties.getString("Block");
    }

    //BossKilled

    /**
     * @return ɱ����boss��ʵ��id
     */
    public int getBossType(){
        return properties.getInteger("BossType");
    }




    //PlayerMessage

    /**
     * @return ��Һ�websocket���������͵���Ϣ
     */
    public String getMessage() {
        return properties.getString("Message");
    }

    //CauldronUsed

    /**
     * @return ʹ����ҩ��ʱ���level??
     */
    public int getCauldronLevel(){
        return properties.getInteger("CauldronLevel");
    }

    /**
     * @return ��ҩ����أ��²���Ⱦɫ
     */
    public int getCauldronDyeColor(){
        return properties.getInteger("DyeColor");
    }

    /**
     * @return ��ҩ����أ��²��Ǻ���ҩ����������Ʒ��
     */
    public String getCauldronItemId(){
        return properties.getString("ItemUsedId");
    }
    //CraftingSessionCompleted

    /**
     * @return �رպϳ�ҳ���ʱ���Ƿ�ʹ�úϳ�̨
     */
    public boolean isUsedCraftingTable(){
        return properties.getBoolean("UsedCraftingTable");
    }

    //EntitySpawned

    /**
     * @return ���ʹ��/summonָ�����ɵ������ʵ��id | ���ɱ���������id
     *  | ɱ����ҵ�����id
     */
    public int getMobType(){
        return properties.getInteger("MobType");
    }

    /**
     * @return �񵽵���Ʒ������ | �ϳɵ���Ʒ������ |�������Ʒ������
     *          ����¯��ȡ������Ʒ������ | ʹ����Ʒʱ�����Ʒ����
     */
    public String getItemType(){
        return properties.getString("Type");
    }

    /**
     * @return ���ɱ�����Ƿ�Ϊ����
     */
    public boolean isMonster(){
        return properties.getBoolean("IsMonster");
    }

    /**
     * @return ɱ������ķ�ʽ??
     */
    public int getKillMethodType(){
        return properties.getInteger("KillMethodType");
    }

    /**
     * @return ɱ������ʹ�õ�����
     */
    public int getWeaponType(){
        return properties.getInteger("WeaponType");
    }

    /**
     * @return �������ԭ��
     */
    public int getDiedCause(){
        return properties.getInteger("Cause");
    }

    /**
     * @return ����Ϣ���������
     */
    public String getSenderName() {
        return properties.getString("Sender");
    }

    /**
     * @return ��Ҵ��͵ľ���
     */
    public double getMetersTravelled(){
        return properties.getDoubleValue("MetersTravelled");
    }


    /**
     * @return ���x������ ��PlayerTransform�¼�����
     */
    public double getX(){
        return properties.getDouble("PosX");
    }

    /**
     * @return ���y������ ��PlayerTransform�¼�����
     */
    public double getY(){
        return properties.getDoubleValue("PosY");
    }

    /**
     * @return ���z������ ��PlayerTransform�¼�����
     */
    public double getZ(){
        return properties.getDoubleValue("PosZ");
    }

    /**
     * @return ���ʹ�ô�����Ҫȥ��ά��
     */
    public int getToDim(){
        return properties.getIntValue("Dim");
    }


}
