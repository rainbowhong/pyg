package com.pinyougou.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsDesc 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name = "tb_goods_desc")
public class GoodsDesc implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="goods_id")
	private Long goodsId;
	@Column(name="introduction")
	private String introduction;
	@Column(name="specification_items")
	private String specificationItems;
	@Column(name="custom_attribute_items")
	private String customAttributeItems;
	@Column(name="item_images")
	private String itemImages;
	@Column(name="package_list")
	private String packageList;
	@Column(name="sale_service")
	private String saleService;

	/** setter and getter method */
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	public Long getGoodsId(){
		return this.goodsId;
	}
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	public String getIntroduction(){
		return this.introduction;
	}
	public void setSpecificationItems(String specificationItems){
		this.specificationItems = specificationItems;
	}
	public String getSpecificationItems(){
		return this.specificationItems;
	}
	public void setCustomAttributeItems(String customAttributeItems){
		this.customAttributeItems = customAttributeItems;
	}
	public String getCustomAttributeItems(){
		return this.customAttributeItems;
	}
	public void setItemImages(String itemImages){
		this.itemImages = itemImages;
	}
	public String getItemImages(){
		return this.itemImages;
	}
	public void setPackageList(String packageList){
		this.packageList = packageList;
	}
	public String getPackageList(){
		return this.packageList;
	}
	public void setSaleService(String saleService){
		this.saleService = saleService;
	}
	public String getSaleService(){
		return this.saleService;
	}

}