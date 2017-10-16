package com.bupt.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by mengying on 2017/9/26.
 */
@Entity
@Table(name = "install_detail")
public class Install_detail {
    private String id;
    private String installNumber;
    private String goodsNumber;
    private String goodsName;
    private String location;
    private String switchNumber;
    private String type;

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Column(name = "INSTALL_NUMBER")
    public String getInstallNumber() {
        return installNumber;
    }

    public void setInstallNumber(String installNumber) {
        this.installNumber = installNumber;
    }

    @Column(name = "GOODS_NUMBER")
    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    @Column(name = "GOODS_NAME")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "SWITCH_NUMBER")
    public String getSwitchNumber() {
        return switchNumber;
    }

    public void setSwitchNumber(String switchNumber) {
        this.switchNumber = switchNumber;
    }

    @Column(name = "TYPE")
    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
