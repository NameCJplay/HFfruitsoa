package com.hf.domain.Domain.Orders;

import java.util.Date;

public class OrdersDataDo {

    private Long ordersDeptId;
    private String time;
    private Integer total;
    private Double gross;
    private Double profit;
    //查询标识 1-年 2-月 3-周 4-日 5-时
    private Integer iden;
    //订单状态 1：待付款 2：已付款 3：交易成功 4：交易取消
    private Integer statu;
    private String start;
    private String end;

    public OrdersDataDo() {
    }

    public OrdersDataDo(Long ordersDeptId, String time, Integer total, Double gross,
                        Double profit, Integer iden, Integer statu, String start, String end) {
        this.ordersDeptId = ordersDeptId;
        this.time = time;
        this.total = total;
        this.gross = gross;
        this.profit = profit;
        this.iden = iden;
        this.statu = statu;
        this.start = start;
        this.end = end;
    }

    public Long getOrdersDeptId() {
        return ordersDeptId;
    }

    public void setOrdersDeptId(Long ordersDeptId) {
        this.ordersDeptId = ordersDeptId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getGross() {
        return gross;
    }

    public void setGross(Double gross) {
        this.gross = gross;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Integer getIden() {
        return iden;
    }

    public void setIden(Integer iden) {
        this.iden = iden;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "OrdersDataDo{" +
                "ordersDeptId=" + ordersDeptId +
                ", time='" + time + '\'' +
                ", total=" + total +
                ", gross=" + gross +
                ", profit=" + profit +
                ", iden=" + iden +
                ", statu=" + statu +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
