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
@Table(name="purchase_info")
public class PurchaseInfo {
    private Date createTime;
    private Date lastUpdate;
    private String  purchaseNumber;
    private String purchaseManagerNumbert;  //下发采购单人员编号
    private String purchaseManagerName;  //下发采购单人员姓名
    private String countInfo;
    @Id
    @Column(name = "PURCHASE_NUMBER", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
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
    public String getPurchaseManagerNumbert() {
        return purchaseManagerNumbert;
    }

    public void setPurchaseManagerNumbert(String purchaseManagerNumbert) {
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        purchaseManagerNumbert =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);
        this.purchaseManagerNumbert = purchaseManagerNumbert;
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

    public String getCountInfo() {
        return countInfo;
    }

    public void setCountInfo(String countInfo) {
        this.countInfo = countInfo;
    }
}
