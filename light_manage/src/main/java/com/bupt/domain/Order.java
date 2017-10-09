package com.bupt.domain;

import com.bupt.common.utils.NumberUtills;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CJ on 2017/10/9.
 */
@Entity
@Table(name = "order1")
public class Order {
    @Id
    @Column(name = "maintain_number")
    private String maintainNumber;
    @Column(name = "monitor_name")
    private String monitorName;
    @Column(name = "monitor_number")
    private String monitorNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name= "CREATE_TIME")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    private Date lastUpdate;
    public Order(){

    }
    public Order(Order order){
        this.maintainNumber= NumberUtills.getNumber();
        this.monitorName=order.getMonitorName();
        this.maintainNumber=order.getMaintainNumber();
    }

    public String getMaintainNumber() {
        return maintainNumber;
    }

    public void setMaintainNumber(String maintainNumber) {
        this.maintainNumber = maintainNumber;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public String getMonitorNumber() {
        return monitorNumber;
    }

    public void setMonitorNumber(String monitorNumber) {
        this.monitorNumber = monitorNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
