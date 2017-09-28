package com.bupt.domain;

import java.util.List;

/**
 * Created by Stadpole on 2017/9/27.
 */
public class InfoAndDetail {
    private String purchaseManagerNumber;  //下发采购单人员编号
    private String purchaseManagerName;  //下发采购单人员姓名
    private List<PurchaseDetail> arr;
    public class PurchaseDetail{
    private String id;
    private String name;
    private Double power;
    private Double price;
    private String type;
    private Double countDetail;
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

        public Double getCountDetail() {
            return countDetail;
        }

        public void setCountDetail(Double countDetail) {
            this.countDetail = countDetail;
        }
    }

    public String getPurchaseManagerNumber() {
        return purchaseManagerNumber;
    }

    public void setPurchaseManagerNumber(String purchaseManagerNumber) {
        this.purchaseManagerNumber = purchaseManagerNumber;
    }

    public String getPurchaseManagerName() {
        return purchaseManagerName;
    }

    public void setPurchaseManagerName(String purchaseManagerName) {
        this.purchaseManagerName = purchaseManagerName;
    }


    public List<PurchaseDetail> getArr() {
        return arr;
    }

    public void setArr(List<PurchaseDetail> arr) {
        this.arr = arr;
    }
}
