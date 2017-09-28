package com.bupt.domain;

import com.bupt.common.base.BaseUuidEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by CJ on 2017/9/21.
 */
@Entity
@Table(name = "maintain_info")
public class MaintainInfo extends BaseUuidEntity {
   /* MAINTAIN_NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    LIGHT_ID	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    LIGHT_ADDRESS	varchar	64	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    MONITOR_NUMBER	varchar	36	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
    MONITOR_NAME	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0*/
    private String lightAddress;

/*    @ManyToOne
    //@JoinColumn(name = "maintain_number")
    MaintainOrder maintainOrder;*/

    String maintainNumber;
    public MaintainInfo(){}

    public MaintainInfo(MaintainInfo maintainInfo) {
        this.id=maintainInfo.getId();
        this.lightAddress = maintainInfo.getLightAddress();
      //  this.maintainOrder =maintainInfo.getMaintainOrder();
        this.maintainNumber=maintainInfo.getMaintainNumber();
    }

    public String getLightAddress() {
        return lightAddress;
    }

    public void setLightAddress(String lightAddress) {
        this.lightAddress = lightAddress;
    }

    public String getMaintainNumber() {
        return maintainNumber;
    }

    public void setMaintainNumber(String maintainNumber) {
        this.maintainNumber = maintainNumber;
    }
    /*public MaintainOrder getMaintainOrder() {
        return maintainOrder;
    }

    public void setMaintainOrder(MaintainOrder maintainOrder) {
        this.maintainOrder = maintainOrder;
    }*/
}
