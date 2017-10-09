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
    private String type;

    private String lightId;

    public String getLightId() {
        return lightId;
    }

    public void setLightId(String lightId) {
        this.lightId = lightId;
    }

    private String maintainNumber;

    public MaintainInfo(){}

    public MaintainInfo(MaintainInfo maintainInfo) {
        this.id=maintainInfo.getId();
        this.type = maintainInfo.getType();
        this.maintainNumber=maintainInfo.getMaintainNumber();
        this.lightId=maintainInfo.getLightId();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaintainNumber() {
        return maintainNumber;
    }

   public void setMaintainNumber(String maintainNumber) {
        this.maintainNumber = maintainNumber;
    }

}
