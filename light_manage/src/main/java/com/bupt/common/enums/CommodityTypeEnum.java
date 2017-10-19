package com.bupt.common.enums;


/**
 * Created by Xtj on 2017/7/6.
 */
public enum CommodityTypeEnum {
    LIGHT(0,"开关"),
    SWITCH(1,"电灯");
    private int value;
    private String name;
    CommodityTypeEnum(final int value,final String name){
        this.setValue(value);
       this.setName(name);
    }
    // 根据index获取enum对象
    public static CommodityTypeEnum findByIndex(int index){
        for(CommodityTypeEnum positionEnum :CommodityTypeEnum.values()){
            if(index==positionEnum.getValue()){
                return positionEnum;
            }
        }
        return null;
    }
    public static String findByValue(int value){
        for(CommodityTypeEnum positionEnum :CommodityTypeEnum.values()){
            if(value==positionEnum.getValue()){
                return positionEnum.getName();
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
