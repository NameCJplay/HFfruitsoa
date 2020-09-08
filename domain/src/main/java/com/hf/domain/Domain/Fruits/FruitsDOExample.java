package com.hf.domain.Domain.Fruits;

import com.hf.domain.Domain.Classify.ClassifyDO;

import java.util.List;

public class FruitsDOExample {

    //编号
    private Integer fruitsId;
    //商品所属分类id
    private Integer fruitsClassifyId;
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
    private String fruitsCreateDate;
    //预计到期时间(保质期)
    private Integer fruitsMaturityDate;
    //供应商+电话
    private String fruitsSupplier;
    //1：热销  2：非热销
    private Integer fruitsHot;
    //1：正常  2：停售  3：已售空
    private Integer fruitsStatus;

    private List<ClassifyDO> classlist;

    public List<ClassifyDO> getClasslist() {
        return classlist;
    }

    public void setClasslist(List<ClassifyDO> classlist) {
        this.classlist = classlist;
    }

    public FruitsDOExample(Integer fruitsId, Integer fruitsClassifyId, String fruitsName, Double fruitsCprice, Double fruitsPrice, String fruitsUnit, Integer fruitsStock, String fruitsImg, String createtime, int mutitytime, String fruitsSupplier, Integer fruitsHot, Integer fruitsStatus) {
    }

    public FruitsDOExample(int fruitsId, int fruitsClassifyId, String fruitsName, Double fruitsCprice, Double fruitsPrice, String fruitsUnit, Integer fruitsStock, String fruitsImg, String fruitsCreateDate, int fruitsMaturityDate, String fruitsSupplier, Integer fruitsHot, Integer fruitsStatus) {
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
    public FruitsDOExample(FruitsDO fruitsDO){
        this.fruitsId = fruitsDO.getFruitsId().intValue();
        this.fruitsClassifyId = fruitsDO.getFruitsClassifyId().intValue();
        this.fruitsName = fruitsDO.getFruitsName();
        this.fruitsCprice = fruitsDO.getFruitsCprice();
        this.fruitsPrice = fruitsDO.getFruitsPrice();
        this.fruitsUnit = fruitsDO.getFruitsUnit();
        this.fruitsStock = fruitsDO.getFruitsStock();
        this.fruitsImg = fruitsDO.getFruitsImg();
        this.fruitsCreateDate = null;
        this.fruitsMaturityDate = null;
        this.fruitsSupplier = fruitsDO.getFruitsSupplier();
        this.fruitsHot = fruitsDO.getFruitsHot();
        this.fruitsStatus = fruitsDO.getFruitsStatus();
    }

    public Integer getFruitsId() {
        return fruitsId;
    }

    public void setFruitsId(Integer fruitsId) {
        this.fruitsId = fruitsId;
    }

    public Integer getFruitsClassifyId() {
        return fruitsClassifyId;
    }

    public void setFruitsClassifyId(Integer fruitsClassifyId) {
        this.fruitsClassifyId = fruitsClassifyId;
    }

    public String getFruitsName() {
        return fruitsName;
    }

    public void setFruitsName(String fruitsName) {
        this.fruitsName = fruitsName;
    }

    public Double getFruitsCprice() {
        return fruitsCprice;
    }

    public void setFruitsCprice(Double fruitsCprice) {
        this.fruitsCprice = fruitsCprice;
    }

    public Double getFruitsPrice() {
        return fruitsPrice;
    }

    public void setFruitsPrice(Double fruitsPrice) {
        this.fruitsPrice = fruitsPrice;
    }

    public String getFruitsUnit() {
        return fruitsUnit;
    }

    public void setFruitsUnit(String fruitsUnit) {
        this.fruitsUnit = fruitsUnit;
    }

    public Integer getFruitsStock() {
        return fruitsStock;
    }

    public void setFruitsStock(Integer fruitsStock) {
        this.fruitsStock = fruitsStock;
    }

    public String getFruitsImg() {
        return fruitsImg;
    }

    public void setFruitsImg(String fruitsImg) {
        this.fruitsImg = fruitsImg;
    }

    public String getFruitsCreateDate() {
        return fruitsCreateDate;
    }

    public void setFruitsCreateDate(String fruitsCreateDate) {
        this.fruitsCreateDate = fruitsCreateDate;
    }

    public Integer getFruitsMaturityDate() {
        return fruitsMaturityDate;
    }

    public void setFruitsMaturityDate(Integer fruitsMaturityDate) {
        this.fruitsMaturityDate = fruitsMaturityDate;
    }

    public String getFruitsSupplier() {
        return fruitsSupplier;
    }

    public void setFruitsSupplier(String fruitsSupplier) {
        this.fruitsSupplier = fruitsSupplier;
    }

    public Integer getFruitsHot() {
        return fruitsHot;
    }

    public void setFruitsHot(Integer fruitsHot) {
        this.fruitsHot = fruitsHot;
    }

    public Integer getFruitsStatus() {
        return fruitsStatus;
    }

    public void setFruitsStatus(Integer fruitsStatus) {
        this.fruitsStatus = fruitsStatus;
    }

    public FruitsDOExample() {
    }


    public FruitsDOExample(Integer fruitsId, Integer fruitsClassifyId, String fruitsName, Double fruitsCprice, Double fruitsPrice, String fruitsUnit, Integer fruitsStock, String fruitsImg, String fruitsCreateDate, Integer fruitsMaturityDate, String fruitsSupplier, Integer fruitsHot, Integer fruitsStatus) {
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

    @Override
    public String toString() {
        return "FruitsDOExample{" +
                "fruitsId=" + fruitsId +
                ", fruitsClassifyId=" + fruitsClassifyId +
                ", fruitsName='" + fruitsName + '\'' +
                ", fruitsCprice=" + fruitsCprice +
                ", fruitsPrice=" + fruitsPrice +
                ", fruitsUnit='" + fruitsUnit + '\'' +
                ", fruitsStock=" + fruitsStock +
                ", fruitsImg='" + fruitsImg + '\'' +
                ", fruitsCreateDate='" + fruitsCreateDate + '\'' +
                ", fruitsMaturityDate='" + fruitsMaturityDate + '\'' +
                ", fruitsSupplier='" + fruitsSupplier + '\'' +
                ", fruitsHot=" + fruitsHot +
                ", fruitsStatus=" + fruitsStatus +
                '}';
    }
}
