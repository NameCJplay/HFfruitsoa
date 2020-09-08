package com.hf.domain.Domain.Orders;

import java.io.Serializable;
import java.util.Date;





public class OrdersDetailsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long detailsId;
	//订单编号
	private String detailsOrdersnumber;
	//商品编号
	private Long detailsFruitsid;
	//商品名称
	private String detailsFruitsname;
	//商品数量
	private Double detailsCount;
	//商品价格
	private Double detailsPrice;
	//合计
	private Double detailsGross;
	//折扣
	private Double detailsDiscount;
	//折扣后价格
	private Double detailsDcprice;
	//商品成本价
	private Double detailsCprice;
	//利润
	private Double detailsProfit;

	public OrdersDetailsDO(Long detailsId, String detailsOrdersnumber, Long detailsFruitsid, String detailsFruitsname, Double detailsCount, Double detailsPrice, Double detailsGross, Double detailsDiscount, Double detailsDcprice, Double detailsCprice, Double detailsProfit) {
		this.detailsId = detailsId;
		this.detailsOrdersnumber = detailsOrdersnumber;
		this.detailsFruitsid = detailsFruitsid;
		this.detailsFruitsname = detailsFruitsname;
		this.detailsCount = detailsCount;
		this.detailsPrice = detailsPrice;
		this.detailsGross = detailsGross;
		this.detailsDiscount = detailsDiscount;
		this.detailsDcprice = detailsDcprice;
		this.detailsCprice = detailsCprice;
		this.detailsProfit = detailsProfit;
	}

	@Override
	public String toString() {
		return "OrdersDetailsDO{" +
				"detailsId=" + detailsId +
				", detailsOrdersnumber='" + detailsOrdersnumber + '\'' +
				", detailsFruitsid=" + detailsFruitsid +
				", detailsFruitsname='" + detailsFruitsname + '\'' +
				", detailsCount=" + detailsCount +
				", detailsPrice=" + detailsPrice +
				", detailsGross=" + detailsGross +
				", detailsDiscount=" + detailsDiscount +
				", detailsDcprice=" + detailsDcprice +
				", detailsCprice=" + detailsCprice +
				", detailsProfit=" + detailsProfit +
				'}';
	}

	/**
	 * 设置：编号
	 */
	public void setDetailsId(Long detailsId) {
		this.detailsId = detailsId;
	}
	/**
	 * 获取：编号
	 */
	public Long getDetailsId() {
		return detailsId;
	}
	/**
	 * 设置：订单编号
	 */
	public void setDetailsOrdersnumber(String detailsOrdersnumber) {
		this.detailsOrdersnumber = detailsOrdersnumber;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDetailsOrdersnumber() {
		return detailsOrdersnumber;
	}
	/**
	 * 设置：商品编号
	 */
	public void setDetailsFruitsid(Long detailsFruitsid) {
		this.detailsFruitsid = detailsFruitsid;
	}
	/**
	 * 获取：商品编号
	 */
	public Long getDetailsFruitsid() {
		return detailsFruitsid;
	}
	/**
	 * 设置：商品名称
	 */
	public void setDetailsFruitsname(String detailsFruitsname) {
		this.detailsFruitsname = detailsFruitsname;
	}
	/**
	 * 获取：商品名称
	 */
	public String getDetailsFruitsname() {
		return detailsFruitsname;
	}
	/**
	 * 设置：商品数量
	 */
	public void setDetailsCount(Double detailsCount) {
		this.detailsCount = detailsCount;
	}
	/**
	 * 获取：商品数量
	 */
	public Double getDetailsCount() {
		return detailsCount;
	}
	/**
	 * 设置：商品价格
	 */
	public void setDetailsPrice(Double detailsPrice) {
		this.detailsPrice = detailsPrice;
	}
	/**
	 * 获取：商品价格
	 */
	public Double getDetailsPrice() {
		return detailsPrice;
	}
	/**
	 * 设置：合计
	 */
	public void setDetailsGross(Double detailsGross) {
		this.detailsGross = detailsGross;
	}
	/**
	 * 获取：合计
	 */
	public Double getDetailsGross() {
		return detailsGross;
	}
	/**
	 * 设置：折扣
	 */
	public void setDetailsDiscount(Double detailsDiscount) {
		this.detailsDiscount = detailsDiscount;
	}
	/**
	 * 获取：折扣
	 */
	public Double getDetailsDiscount() {
		return detailsDiscount;
	}
	/**
	 * 设置：折扣后价格
	 */
	public void setDetailsDcprice(Double detailsDcprice) {
		this.detailsDcprice = detailsDcprice;
	}
	/**
	 * 获取：折扣后价格
	 */
	public Double getDetailsDcprice() {
		return detailsDcprice;
	}
	/**
	 * 设置：商品成本价
	 */
	public void setDetailsCprice(Double detailsCprice) {
		this.detailsCprice = detailsCprice;
	}
	/**
	 * 获取：商品成本价
	 */
	public Double getDetailsCprice() {
		return detailsCprice;
	}
	/**
	 * 设置：利润
	 */
	public void setDetailsProfit(Double detailsProfit) {
		this.detailsProfit = detailsProfit;
	}
	/**
	 * 获取：利润
	 */
	public Double getDetailsProfit() {
		return detailsProfit;
	}
}
