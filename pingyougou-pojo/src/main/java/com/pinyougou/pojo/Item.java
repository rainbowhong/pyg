package com.pinyougou.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Item 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name = "tb_item")
public class Item implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="sell_point")
	private String sellPoint;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="stock_count")
	private Integer stockCount;
	@Column(name="num")
	private Integer num;
	@Column(name="barcode")
	private String barcode;
	@Column(name="image")
	private String image;
	@Column(name="categoryid")
	private Long categoryid;
	@Column(name="status")
	private String status;
	@Column(name="create_time")
	private Date createTime;
	@Column(name="update_time")
	private Date updateTime;
	@Column(name="item_sn")
	private String itemSn;
	@Column(name="cost_pirce")
	private BigDecimal costPirce;
	@Column(name="market_price")
	private BigDecimal marketPrice;
	@Column(name="is_default")
	private String isDefault;
	@Column(name="goods_id")
	private Long goodsId;
	@Column(name="seller_id")
	private String sellerId;
	@Column(name="cart_thumbnail")
	private String cartThumbnail;
	@Column(name="category")
	private String category;
	@Column(name="brand")
	private String brand;
	@Column(name="spec")
	private String spec;
	@Column(name="seller")
	private String seller;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCostPirce() {
		return costPirce;
	}

	public void setCostPirce(BigDecimal costPirce) {
		this.costPirce = costPirce;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setSellPoint(String sellPoint){
		this.sellPoint = sellPoint;
	}
	public String getSellPoint(){
		return this.sellPoint;
	}

	public void setStockCount(Integer stockCount){
		this.stockCount = stockCount;
	}
	public Integer getStockCount(){
		return this.stockCount;
	}
	public void setNum(Integer num){
		this.num = num;
	}
	public Integer getNum(){
		return this.num;
	}
	public void setBarcode(String barcode){
		this.barcode = barcode;
	}
	public String getBarcode(){
		return this.barcode;
	}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return this.image;
	}
	public void setCategoryid(Long categoryid){
		this.categoryid = categoryid;
	}
	public Long getCategoryid(){
		return this.categoryid;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}
	public void setItemSn(String itemSn){
		this.itemSn = itemSn;
	}
	public String getItemSn(){
		return this.itemSn;
	}

	public void setIsDefault(String isDefault){
		this.isDefault = isDefault;
	}
	public String getIsDefault(){
		return this.isDefault;
	}
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	public Long getGoodsId(){
		return this.goodsId;
	}
	public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
	public String getSellerId(){
		return this.sellerId;
	}
	public void setCartThumbnail(String cartThumbnail){
		this.cartThumbnail = cartThumbnail;
	}
	public String getCartThumbnail(){
		return this.cartThumbnail;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public String getCategory(){
		return this.category;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public String getBrand(){
		return this.brand;
	}
	public void setSpec(String spec){
		this.spec = spec;
	}
	public String getSpec(){
		return this.spec;
	}
	public void setSeller(String seller){
		this.seller = seller;
	}
	public String getSeller(){
		return this.seller;
	}

}