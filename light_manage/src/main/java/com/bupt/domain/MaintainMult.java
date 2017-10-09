package com.bupt.domain;

import java.util.List;

/**
 * Created by CJ on 2017/9/28.
 */
public class MaintainMult {
    private String  decisionMakerNumber;
    private String decisionMakerName;  //下发采购单人员编号


    private List<Temp> arr;

    public String getDecisionMakerNumber() {
        return decisionMakerNumber;
    }

    public void setDecisionMakerNumber(String decisionMakerNumber) {
        this.decisionMakerNumber = decisionMakerNumber;
    }

    public String getDecisionMakerName() {
        return decisionMakerName;
    }

    public void setDecisionMakerName(String decisionMakerName) {
        this.decisionMakerName = decisionMakerName;
    }

    public List<Temp> getArr() {
        return arr;
    }

    public void setArr(List<Temp> arr) {
        this.arr = arr;
    }

    public class Temp {
        private String id;
        //   private String name;
        //   private Double power;
        //    private Double price;
        private String type;
        //     private String countDetail;
        private String goodsNam;
        private String lightAddress;
        private String switchNumber;

        public String getGoodsNam() {
            return goodsNam;
        }

        public void setGoodsNam(String goodsNam) {
            this.goodsNam = goodsNam;
        }

        public String getLightAddress() {
            return lightAddress;
        }

        public void setLightAddress(String lightAddress) {
            this.lightAddress = lightAddress;
        }

        public String getSwitchNumber() {
            return switchNumber;
        }

        public void setSwitchNumber(String switchNumber) {
            this.switchNumber = switchNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
    }
