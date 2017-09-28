package com.bupt.domain;

import java.util.List;

/**
 * Created by mengying on 2017/9/28.
 */
public class InstallInfoAndDetail {
    private String  installNumber;
    private String decisionMakerNumber;  //决策人员编号
    private String decisionMakerName;  //决策人员姓名
    private List<InstallInfoAndDetail.Install_detail> arr;
    public class Install_detail{
        private String goodsNumber;
        private String goodsName;
        private String location;
        private String switchNumber;
        private String type;

        public String getType() { return type; }

        public void setType(String type) { this.type = type; }

        public String getGoodsNumber() { return goodsNumber;}

        public void setGoodsNumber(String goodsNumber) { this.goodsNumber = goodsNumber;}

        public String getGoodsName() { return goodsName;}

        public void setGoodsName(String goodsName) { this.goodsName = goodsName; }

        public String getLocation() { return location; }

        public void setLocation(String location) { this.location = location; }

        public String getSwitchNumber() { return switchNumber; }

        public void setSwitchNumber(String switchNumber) { this.switchNumber = switchNumber; }

        @Override
        public String toString() {
            return "Install_detail{" +
                    "goodsNumber='" + goodsNumber + '\'' +
                    ", goodsName='" + goodsName + '\'' +
                    ", location='" + location + '\'' +
                    ", switchNumber='" + switchNumber + '\'' +
                    '}';
        }
    }

    public String getInstallNumber() { return installNumber; }

    public void setInstallNumber(String installNumber) { this.installNumber = installNumber; }

    public String getDecisionMakerNumber() { return decisionMakerNumber; }

    public void setDecisionMakerNumber(String decisionMakerNumber) { this.decisionMakerNumber = decisionMakerNumber; }

    public String getDecisionMakerName() { return decisionMakerName; }

    public void setDecisionMakerName(String decisionMakerName) { this.decisionMakerName = decisionMakerName; }

    public List<Install_detail> getArr() { return arr; }

    public void setArr(List<Install_detail> arr) { this.arr = arr; }

    @Override
    public String toString() {
        return "InstallInfoAndDetail{" +
                "installNumber='" + installNumber + '\'' +
                ", decisionMakerNumber='" + decisionMakerNumber + '\'' +
                ", decisionMakerName='" + decisionMakerName + '\'' +
                ", arr=" + arr +
                '}';
    }
}
