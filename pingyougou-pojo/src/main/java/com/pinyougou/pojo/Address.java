package com.pinyougou.pojo;

import javax.persistence.*;

/**
 * Address 实体类
 * @date 2018-10-30 20:09:52
 * @version 1.0
 */
@Table(name = "tb_address")
public class Address implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "province_id")
	private String provinceId;
	@Column(name = "city_id")
	private String cityId;
	@Column(name = "town_id")
	private String townId;
	@Column(name = "mobile")
	private String mobile;
	@Column(name="address")
	private String address;
	@Column(name = "contact")
	private String contact;
	@Column(name="is_default")
	private String isDefault;
	@Column(name = "notes")
	private String notes;
	@Column(name = "create_date")
	private java.util.Date createDate;
	@Column(name="alias")
	private String alias;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return this.userId;
	}
	public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	}
	public String getProvinceId(){
		return this.provinceId;
	}
	public void setCityId(String cityId){
		this.cityId = cityId;
	}
	public String getCityId(){
		return this.cityId;
	}
	public void setTownId(String townId){
		this.townId = townId;
	}
	public String getTownId(){
		return this.townId;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public String getContact(){
		return this.contact;
	}
	public void setIsDefault(String isDefault){
		this.isDefault = isDefault;
	}
	public String getIsDefault(){
		return this.isDefault;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}
	public String getNotes(){
		return this.notes;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setAlias(String alias){
		this.alias = alias;
	}
	public String getAlias(){
		return this.alias;
	}

}