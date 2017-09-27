package com.bupt.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mengying on 2017/9/21.
 */
@Entity
@Table(name = "install_info")
public class Install_info {
    private String id;
    private String decisionMakerNumber;
    private String decisionMakerName;
    private Date createTime;
    private Date lastUpdate;

    @Id
    @Column(name = "ID", updatable = false)
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }


    @Column(name = "DECISION_MAKER_NUMBER")
    public String getDecisionMakerNumber() {
        return decisionMakerNumber;
    }

    public void setDecisionMakerNumber(String decisionMakerNumber) {
        this.decisionMakerNumber = decisionMakerNumber;
    }

    @Column(name = "DECISION_MAKER_NAME")
    public String getDecisionMakerName() {
        return decisionMakerName;
    }

    public void setDecisionMakerName(String decisionMakerName) {
        this.decisionMakerName = decisionMakerName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATE_TIME", updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
