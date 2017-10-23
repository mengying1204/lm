package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Stadpole on 2017/9/21.
 */
@Entity
@Table(name="purchase_detail")
public class PurchaseDetail {
    private String id;
    private String purchaseNumber;
    private String name;
    private Double power;
    private Double price;
    private Integer type;
    private Double countDetail;

    private String typeName;
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

      @Basic
    @Column(name = "PURCHASE_NUMBER")
    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }
    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "POWER")
    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    @Basic
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Basic
    @Column(name = "TYPE")

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "COUNT_DETAIL")

    public Double getCountDetail() {
        return countDetail;
    }

    public void setCountDetail(Double countDetail) {
        this.countDetail = countDetail;
    }
    @Transient
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
