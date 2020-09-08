package com.hf.domain.Domain.Orders;

public class CashierDo {
/*
* 接收购物车传来的参数
* */

    //商品编号detailsFruitsid
    private String detailsFruitsid;
    //商品名
    private String detailsFruitsname;
    //数量
    private String detailsCount;
    //单价
    private String detailsPrice;
    //小计
    private String detailsGross;
    //折扣
    private String detailsDiscount;
    //折扣后总价
    private String detailsDcprice;

    public CashierDo() {
    }

    public String getdetailsFruitsid() {
        return detailsFruitsid;
    }

    public void setdetailsFruitsid(String detailsFruitsid) {
        this.detailsFruitsid = detailsFruitsid;
    }

    public String getDetailsFruitsname() {
        return detailsFruitsname;
    }

    public void setDetailsFruitsname(String detailsFruitsname) {
        this.detailsFruitsname = detailsFruitsname;
    }

    public String getDetailsCount() {
        return detailsCount;
    }

    public void setDetailsCount(String detailsCount) {
        this.detailsCount = detailsCount;
    }

    public String getDetailsPrice() {
        return detailsPrice;
    }

    public void setDetailsPrice(String detailsPrice) {
        this.detailsPrice = detailsPrice;
    }

    public String getDetailsGross() {
        return detailsGross;
    }

    public void setDetailsGross(String detailsGross) {
        this.detailsGross = detailsGross;
    }

    public String getDetailsDiscount() {
        return detailsDiscount;
    }

    public void setDetailsDiscount(String detailsDiscount) {
        this.detailsDiscount = detailsDiscount;
    }

    public String getDetailsDcprice() {
        return detailsDcprice;
    }

    public void setDetailsDcprice(String detailsDcprice) {
        this.detailsDcprice = detailsDcprice;
    }

}
