package com.hf.domain.Domain.Fruits;

import java.io.Serializable;
import java.util.Date;


public class FruitsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long fruitsId;
	//商品所属分类id
	private Long fruitsClassifyId;
	//名称
	private String fruitsName;
	//成本价
	private Double fruitsCprice;
	//单价
	private Double fruitsPrice;
	//单位
	private String fruitsUnit;
	//库存
	private Integer fruitsStock;
	//图片
	private String fruitsImg;
	//创建时间
	private Date fruitsCreateDate;
	//预计到期时间
	private Date fruitsMaturityDate;
	//供应商+电话
	private String fruitsSupplier;
	//1：热销  2：非热销
	private Integer fruitsHot;
	//1：正常  2：停售  3：已售空
	private Integer fruitsStatus;

	private String classname;

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	/**
	 * 设置：编号
	 */
	public void setFruitsId(Long fruitsId) {
		this.fruitsId = fruitsId;
	}
	/**
	 * 获取：编号
	 */
	public Long getFruitsId() {
		return fruitsId;
	}
	/**
	 * 设置：商品所属分类id
	 */
	public void setFruitsClassifyId(Long fruitsClassifyId) {
		this.fruitsClassifyId = fruitsClassifyId;
	}
	/**
	 * 获取：商品所属分类id
	 */
	public Long getFruitsClassifyId() {
		return fruitsClassifyId;
	}
	/**
	 * 设置：名称
	 */
	public void setFruitsName(String fruitsName) {
		this.fruitsName = fruitsName;
	}
	/**
	 * 获取：名称
	 */
	public String getFruitsName() {
		return fruitsName;
	}
	/**
	 * 设置：成本价
	 */
	public void setFruitsCprice(Double fruitsCprice) {
		this.fruitsCprice = fruitsCprice;
	}
	/**
	 * 获取：成本价
	 */
	public Double getFruitsCprice() {
		return fruitsCprice;
	}
	/**
	 * 设置：单价
	 */
	public void setFruitsPrice(Double fruitsPrice) {
		this.fruitsPrice = fruitsPrice;
	}
	/**
	 * 获取：单价
	 */
	public Double getFruitsPrice() {
		return fruitsPrice;
	}
	/**
	 * 设置：单位
	 */
	public void setFruitsUnit(String fruitsUnit) {
		this.fruitsUnit = fruitsUnit;
	}
	/**
	 * 获取：单位
	 */
	public String getFruitsUnit() {
		return fruitsUnit;
	}
	/**
	 * 设置：库存
	 */
	public void setFruitsStock(Integer fruitsStock) {
		this.fruitsStock = fruitsStock;
	}
	/**
	 * 获取：库存
	 */
	public Integer getFruitsStock() {
		return fruitsStock;
	}
	/**
	 * 设置：图片
	 */
	public void setFruitsImg(String fruitsImg) {
		this.fruitsImg = fruitsImg;
	}
	/**
	 * 获取：图片
	 */
	public String getFruitsImg() {
		return fruitsImg;
	}
	/**
	 * 设置：创建时间
	 */
	public void setFruitsCreateDate(Date fruitsCreateDate) {
		this.fruitsCreateDate = fruitsCreateDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getFruitsCreateDate() {
		return fruitsCreateDate;
	}
	/**
	 * 设置：预计到期时间
	 */
	public void setFruitsMaturityDate(Date fruitsMaturityDate) {
		this.fruitsMaturityDate = fruitsMaturityDate;
	}
	/**
	 * 获取：预计到期时间
	 */
	public Date getFruitsMaturityDate() {
		return fruitsMaturityDate;
	}
	/**
	 * 设置：供应商+电话
	 */
	public void setFruitsSupplier(String fruitsSupplier) {
		this.fruitsSupplier = fruitsSupplier;
	}
	/**
	 * 获取：供应商+电话
	 */
	public String getFruitsSupplier() {
		return fruitsSupplier;
	}
	/**
	 * 设置：1：热销  2：非热销
	 */
	public void setFruitsHot(Integer fruitsHot) {
		this.fruitsHot = fruitsHot;
	}
	/**
	 * 获取：1：热销  2：非热销
	 */
	public Integer getFruitsHot() {
		return fruitsHot;
	}
	/**
	 * 设置：1：正常  2：停售  3：已售空
	 */
	public void setFruitsStatus(Integer fruitsStatus) {
		this.fruitsStatus = fruitsStatus;
	}
	/**
	 * 获取：1：正常  2：停售  3：已售空
	 */
	public Integer getFruitsStatus() {
		return fruitsStatus;
	}

	public FruitsDO() {
	}

	public FruitsDO(Long fruitsId, Long fruitsClassifyId, String fruitsName, Double fruitsCprice, Double fruitsPrice, String fruitsUnit, Integer fruitsStock, String fruitsImg, Date fruitsCreateDate, Date fruitsMaturityDate, String fruitsSupplier, Integer fruitsHot, Integer fruitsStatus) {
		this.fruitsId = fruitsId;
		this.fruitsClassifyId = fruitsClassifyId;
		this.fruitsName = fruitsName;
		this.fruitsCprice = fruitsCprice;
		this.fruitsPrice = fruitsPrice;
		this.fruitsUnit = fruitsUnit;
		this.fruitsStock = fruitsStock;
		this.fruitsImg = fruitsImg;
		this.fruitsCreateDate = fruitsCreateDate;
		this.fruitsMaturityDate = fruitsMaturityDate;
		this.fruitsSupplier = fruitsSupplier;
		this.fruitsHot = fruitsHot;
		this.fruitsStatus = fruitsStatus;
	}
	public FruitsDO(FruitsDOExample fep) {
		this.fruitsId = (long)fep.getFruitsId();
		this.fruitsClassifyId = (long)fep.getFruitsClassifyId();
		this.fruitsName = fep.getFruitsName();
		this.fruitsCprice = fep.getFruitsCprice();
		this.fruitsPrice = fep.getFruitsPrice();
		this.fruitsUnit = fep.getFruitsUnit();
		this.fruitsStock = fep.getFruitsStock();
		this.fruitsImg = fep.getFruitsImg();
		this.fruitsCreateDate = null;
		this.fruitsMaturityDate = null;
		this.fruitsSupplier = fep.getFruitsSupplier();
		this.fruitsHot = fep.getFruitsHot();
		this.fruitsStatus = fep.getFruitsStatus();
	}

	@Override
	public String toString() {
		return "FruitsDO{" +
				"fruitsId=" + fruitsId +
				", fruitsClassifyId=" + fruitsClassifyId +
				", fruitsName='" + fruitsName + '\'' +
				", fruitsCprice=" + fruitsCprice +
				", fruitsPrice=" + fruitsPrice +
				", fruitsUnit='" + fruitsUnit + '\'' +
				", fruitsStock=" + fruitsStock +
				", fruitsImg='" + fruitsImg + '\'' +
				", fruitsCreateDate=" + fruitsCreateDate +
				", fruitsMaturityDate=" + fruitsMaturityDate +
				", fruitsSupplier='" + fruitsSupplier + '\'' +
				", fruitsHot=" + fruitsHot +
				", fruitsStatus=" + fruitsStatus +
				'}';
	}
}

/*
*toString
*return ReflectionToStringBuilder.toString(this);     
*
*
*/
