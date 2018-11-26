package com.pinyougou.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * OrderItem 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name = "tb_order_item")
public class OrderItem implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="item_id")
	private Long itemId;
	@Column(name="goods_id")
	private Long goodsId;
	@Column(name="order_id")
	private Long orderId;
	@Column(name="title")
	private String title;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="num")
	private Integer num;
	@Column(name="total_fee")
	private BigDecimal totalFee;
	@Column(name="pic_path")
	private String picPath;
	@Column(name="seller_id")
	private String sellerId;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setItemId(Long itemId){
		this.itemId = itemId;
	}
	public Long getItemId(){
		return this.itemId;
	}
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	public Long getGoodsId(){
		return this.goodsId;
	}
	public void setOrderId(Long orderId){
		this.orderId = orderId;
	}
	public Long getOrderId(){
		return this.orderId;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setNum(Integer num){
		this.num = num;
	}
	public Integer getNum(){
		return this.num;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public void setPicPath(String picPath){
		this.picPath = picPath;
	}
	public String getPicPath(){
		return this.picPath;
	}
	public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
	public String getSellerId(){
		return this.sellerId;
	}

}