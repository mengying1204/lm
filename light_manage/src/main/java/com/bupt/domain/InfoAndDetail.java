package com.bupt.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Stadpole on 2017/9/27.
 */
public class InfoAndDetail {
    private String  purchaseNumber;
    private String purchaseManagerNumbert;  //下发采购单人员编号
    private String purchaseManagerName;  //下发采购单人员姓名
    private Double countInfo;
    private List<PurchaseDetail> arr;
    public class PurchaseDetail{
    private String id;
    private String name;
    private Double power;
    private Double price;
    private String type;
    private String countDetail;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPower() {
            return power;
        }

        public void setPower(Double power) {
            this.power = power;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCountDetail() {
            return countDetail;
        }

        public void setCountDetail(String countDetail) {
            this.countDetail = countDetail;
        }
    }
    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getPurchaseManagerNumbert() {
        return purchaseManagerNumbert;
    }

    public void setPurchaseManagerNumbert(String purchaseManagerNumbert) {
        this.purchaseManagerNumbert = purchaseManagerNumbert;
    }

    public String getPurchaseManagerName() {
        return purchaseManagerName;
    }

    public void setPurchaseManagerName(String purchaseManagerName) {
        this.purchaseManagerName = purchaseManagerName;
    }

    public Double getCountInfo() {
        return countInfo;
    }

    public void setCountInfo(Double countInfo) {
        this.countInfo = countInfo;
    }

    public List<PurchaseDetail> getArr() {
        return arr;
    }

    public void setArr(List<PurchaseDetail> arr) {
        this.arr = arr;
    }
}
