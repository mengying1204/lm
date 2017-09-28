package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CJ on 2017/9/28.
 */
@Entity
@Table(name = "maintain_order")
public class MaintainOrder {
    @Id
    private String maintainNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name= "CREATE_TIME")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name= "LAST_UPDATE")
    private Date lastUpdate;

    private String monitorNumber;
    private String monitorName;

/*    @OneToMany(mappedBy = "maintainOrder")
    private List<MaintainInfo> maintainInfos;*/

    public MaintainOrder(){}

    public MaintainOrder(MaintainOrder maintainOrder) {
        this.maintainNumber = maintainOrder.getMaintainNumber();
        this.monitorNumber = maintainOrder.getMonitorNumber();
        this.monitorName = maintainOrder.getMonitorName();
   //     this.maintainInfos =maintainOrder.getMaintainInfos();
    }

    public String getMaintainNumber() {
        return maintainNumber;
    }

    public void setMaintainNumber(String maintainNumber) {
        this.maintainNumber = maintainNumber;
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

    public String getMonitorNumber() {
        return monitorNumber;
    }

    public void setMonitorNumber(String monitorNumber) {
        this.monitorNumber = monitorNumber;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

   /* public List<MaintainInfo> getMaintainInfos() {
        return maintainInfos;
    }

    public void setMaintainInfos(List<MaintainInfo> maintainInfos) {
        this.maintainInfos = maintainInfos;
    }*/
}
