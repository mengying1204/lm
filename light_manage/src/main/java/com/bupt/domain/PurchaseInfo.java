package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by Stadpole on 2017/9/21.
 */
@Entity
@Table(name="purchase_info")
public class PurchaseInfo {
    private Date createTime;
    private Date lastUpdate;
    private String  purchaseNumber;
    private String purchaseManagerNumber;  //下发采购单人员编号
    private String purchaseManagerName;  //下发采购单人员姓名
    private Double totalCount;
    private Double totalPrice;
    @Id
    @Column(name = "PURCHASE_NUMBER", updatable = false)
    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {

        this.purchaseNumber = purchaseNumber;
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
    @Column(name = "PURCHASE_M_NUMBER")
    public String getPurchaseManagerNumber() {
        return purchaseManagerNumber;
    }

    public void setPurchaseManagerNumber(String purchaseManagerNumber) {
        this.purchaseManagerNumber = purchaseManagerNumber;
    }

    @Basic
    @Column(name = "PURCHASE_M_NAME")
    public String getPurchaseManagerName() {
        return purchaseManagerName;
    }

    public void setPurchaseManagerName(String purchaseManagerName) {
        this.purchaseManagerName = purchaseManagerName;
    }


    @Basic
    @Column(name = "COUNT_INFO")
    public Double getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Double totalCount) {
        this.totalCount = totalCount;
    }

    @Transient

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
