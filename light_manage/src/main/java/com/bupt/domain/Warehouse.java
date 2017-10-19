package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Stadpole on 2017/10/17.
 */
@Entity
@Table(name="warehouse")
public class Warehouse {
    private String id;
    private Date createTime;
    private Date lastUpdate;
    private String name;
    private Double power;
    private Double price;
    private Integer type;
    private Double countDetail;
    private String code;
    private String location;

//游离态
    private String codeName;
    private String operator;
    private String operatorNumber;
    private String remark;
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

    @Temporal(TemporalType.TIMESTAMP)//指定映射数据库中的日期事件类型
    @CreationTimestamp
    @Column(name= "CREATE_TIME", updatable = false )
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "COMMODITY_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "COMMODITY_POWER")

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
    @Column(name = "COMMODITY_TYPE")
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
    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Basic
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Transient
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Transient
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Transient

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    @Transient
    public String getOperatorNumber() {
        return operatorNumber;
    }

    public void setOperatorNumber(String operatorNumber) {
        this.operatorNumber = operatorNumber;
    }
    @Transient
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
