package com.hf.domain.Domain.Orders;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-07-05 22:27:23
 */
public class OrdersDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long ordersId;
	//订单编号
	private String ordersNumber;
	//用户编号
	private Long ordersUserId;
	//部门编号
	private Long ordersDeptId;
	//总金额
	private Double ordersGross;
	//折扣
	private Double ordersDiscount;
	//折扣价格
	private Double ordersDcprice;
	//利润
	private Double ordersProfit;
	//创建时间
	private Date ordersCreateDate;
	//更改时间
	private Date ordersMaturityDate;
	//交易状态 1：待付款 2：已付款 3：交易成功 4：交易取消
	private Integer ordersStatus;


	public OrdersDO(Long ordersId, String ordersNumber, Long ordersUserId, Long ordersDeptId, Double ordersGross, Double ordersDiscount, Double ordersDcprice, Double ordersProfit, Date ordersCreateDate, Date ordersMaturityDate, Integer ordersStatus) {
		this.ordersId = ordersId;
		this.ordersNumber = ordersNumber;
		this.ordersUserId = ordersUserId;
		this.ordersDeptId = ordersDeptId;
		this.ordersGross = ordersGross;
		this.ordersDiscount = ordersDiscount;
		this.ordersDcprice = ordersDcprice;
		this.ordersProfit = ordersProfit;
		this.ordersCreateDate = ordersCreateDate;
		this.ordersMaturityDate = ordersMaturityDate;
		this.ordersStatus = ordersStatus;
	}

	/**
	 * 设置：编号
	 */
	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}
	/**
	 * 获取：编号
	 */
	public Long getOrdersId() {
		return ordersId;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrdersNumber(String ordersNumber) {
		this.ordersNumber = ordersNumber;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrdersNumber() {
		return ordersNumber;
	}
	/**
	 * 设置：用户编号
	 */
	public void setOrdersUserId(Long ordersUserId) {
		this.ordersUserId = ordersUserId;
	}
	/**
	 * 获取：用户编号
	 */
	public Long getOrdersUserId() {
		return ordersUserId;
	}
	/**
	 * 设置：部门编号
	 */
	public void setOrdersDeptId(Long ordersDeptId) {
		this.ordersDeptId = ordersDeptId;
	}
	/**
	 * 获取：部门编号
	 */
	public Long getOrdersDeptId() {
		return ordersDeptId;
	}
	/**
	 * 设置：总金额
	 */
	public void setOrdersGross(Double ordersGross) {
		this.ordersGross = ordersGross;
	}
	/**
	 * 获取：总金额
	 */
	public Double getOrdersGross() {
		return ordersGross;
	}
	/**
	 * 设置：折扣
	 */
	public void setOrdersDiscount(Double ordersDiscount) {
		this.ordersDiscount = ordersDiscount;
	}
	/**
	 * 获取：折扣
	 */
	public Double getOrdersDiscount() {
		return ordersDiscount;
	}
	/**
	 * 设置：折扣价格
	 */
	public void setOrdersDcprice(Double ordersDcprice) {
		this.ordersDcprice = ordersDcprice;
	}
	/**
	 * 获取：折扣价格
	 */
	public Double getOrdersDcprice() {
		return ordersDcprice;
	}
	/**
	 * 设置：利润
	 */
	public void setOrdersProfit(Double ordersProfit) {
		this.ordersProfit = ordersProfit;
	}
	/**
	 * 获取：利润
	 */
	public Double getOrdersProfit() {
		return ordersProfit;
	}
	/**
	 * 设置：创建时间
	 */
	public void setOrdersCreateDate(Date ordersCreateDate) {
		this.ordersCreateDate = ordersCreateDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getOrdersCreateDate() {
		return ordersCreateDate;
	}
	/**
	 * 设置：更改时间
	 */
	public void setOrdersMaturityDate(Date ordersMaturityDate) {
		this.ordersMaturityDate = ordersMaturityDate;
	}
	/**
	 * 获取：更改时间
	 */
	public Date getOrdersMaturityDate() {
		return ordersMaturityDate;
	}
	/**
	 * 设置：交易状态 1：待付款 2：已付款 3：交易成功 4：交易取消
	 */
	public void setOrdersStatus(Integer ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
	/**
	 * 获取：交易状态 1：待付款 2：已付款 3：交易成功 4：交易取消
	 */
	public Integer getOrdersStatus() {
		return ordersStatus;
	}


	@Override
	public String toString() {
		return "OrdersDO{" +
				"ordersId=" + ordersId +
				", ordersNumber='" + ordersNumber + '\'' +
				", ordersUserId=" + ordersUserId +
				", ordersDeptId=" + ordersDeptId +
				", ordersGross=" + ordersGross +
				", ordersDiscount=" + ordersDiscount +
				", ordersDcprice=" + ordersDcprice +
				", ordersProfit=" + ordersProfit +
				", ordersCreateDate=" + ordersCreateDate +
				", ordersMaturityDate=" + ordersMaturityDate +
				", ordersStatus=" + ordersStatus +
				'}';
	}
}
