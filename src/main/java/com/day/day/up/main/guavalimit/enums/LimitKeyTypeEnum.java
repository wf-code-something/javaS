package com.day.day.up.main.guavalimit.enums;

public enum LimitKeyTypeEnum {
    /**
     * 限流key类型枚举
     */
    IPADDR("IPADDR", "根据IP地址来限制"),
    CUSTOM("CUSTOM", "自定义根据业务唯一码来限制，需要在强求参数中添加根据 String limitKeyValue");

    private String keyType;

    private String desc;

    LimitKeyTypeEnum(String keyType, String desc) {
        this.keyType = keyType;
        this.desc = desc;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
