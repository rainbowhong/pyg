package com.pinyougou.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Seller 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name="tb_seller")
public class Seller implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/** 登录名 */
	@Id
	@Column(name="seller_id")
	private String sellerId;
	/** 公司名称 */
	@Column(name="name")
	private String name;
	/** 店铺名称 */
	@Column(name="nick_name")
	private String nickName;
	/** 登录密码 */
	@Column(name="password")
	private String password;
	/** 公司邮箱 */
	@Column(name="email")
	private String email;
	/** 手机 */
	@Column(name="mobile")
	private String mobile;
	/** 公司电话 */
	@Column(name="telephone")
	private String telephone;
	/** 状态 */
	@Column(name="status")
	private String status;
	/** 公司详细地址 */
	@Column(name="address_detail")
	private String addressDetail;
	/** 联系人姓名 */
	@Column(name="linkman_name")
	private String linkmanName;
	/** 联系人QQ */
	@Column(name="linkman_qq")
	private String linkmanQq;
	/** 联系人手机 */
	@Column(name="linkman_mobile")
	private String linkmanMobile;
	/** 联系人EMAIL */
	@Column(name="linkman_email")
	private String linkmanEmail;
	/** 营业执照号 */
	@Column(name="license_number")
	private String licenseNumber;
	/** 税务登记证号 */
	@Column(name="tax_number")
	private String taxNumber;
	/** 组织机构代码证 */
	@Column(name="org_number")
	private String orgNumber;
	/** 邮编 */
	@Column(name="address")
	private Long address;
	/** 公司LOGO */
	@Column(name="logo_pic")
	private String logoPic;
	/** 创建时间 */
	@Column(name="create_time")
	private Date createTime;
	/** 法定代表人 */
	@Column(name="legal_person")
	private String legalPerson;
	/** 法定代表人身份证号 */
	@Column(name="legal_person_card_id")
	private String legalPersonCardId;
	/** 开户行名称 */
	@Column(name="bank_name")
	private String bankName;
	/** 开户行支行 */
	@Column(name="bank_user")
	private String bankUser;
	/** 银行账号 */
	@Column(name="brief")
	private String brief;

	/** setter and getter method */
	public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
	public String getSellerId(){
		return this.sellerId;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	public String getNickName(){
		return this.nickName;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	public String getTelephone(){
		return this.telephone;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setAddressDetail(String addressDetail){
		this.addressDetail = addressDetail;
	}
	public String getAddressDetail(){
		return this.addressDetail;
	}
	public void setLinkmanName(String linkmanName){
		this.linkmanName = linkmanName;
	}
	public String getLinkmanName(){
		return this.linkmanName;
	}
	public void setLinkmanQq(String linkmanQq){
		this.linkmanQq = linkmanQq;
	}
	public String getLinkmanQq(){
		return this.linkmanQq;
	}
	public void setLinkmanMobile(String linkmanMobile){
		this.linkmanMobile = linkmanMobile;
	}
	public String getLinkmanMobile(){
		return this.linkmanMobile;
	}
	public void setLinkmanEmail(String linkmanEmail){
		this.linkmanEmail = linkmanEmail;
	}
	public String getLinkmanEmail(){
		return this.linkmanEmail;
	}
	public void setLicenseNumber(String licenseNumber){
		this.licenseNumber = licenseNumber;
	}
	public String getLicenseNumber(){
		return this.licenseNumber;
	}
	public void setTaxNumber(String taxNumber){
		this.taxNumber = taxNumber;
	}
	public String getTaxNumber(){
		return this.taxNumber;
	}
	public void setOrgNumber(String orgNumber){
		this.orgNumber = orgNumber;
	}
	public String getOrgNumber(){
		return this.orgNumber;
	}
	public void setAddress(Long address){
		this.address = address;
	}
	public Long getAddress(){
		return this.address;
	}
	public void setLogoPic(String logoPic){
		this.logoPic = logoPic;
	}
	public String getLogoPic(){
		return this.logoPic;
	}
	public void setBrief(String brief){
		this.brief = brief;
	}
	public String getBrief(){
		return this.brief;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	public void setLegalPerson(String legalPerson){
		this.legalPerson = legalPerson;
	}
	public String getLegalPerson(){
		return this.legalPerson;
	}
	public void setLegalPersonCardId(String legalPersonCardId){
		this.legalPersonCardId = legalPersonCardId;
	}
	public String getLegalPersonCardId(){
		return this.legalPersonCardId;
	}
	public void setBankUser(String bankUser){
		this.bankUser = bankUser;
	}
	public String getBankUser(){
		return this.bankUser;
	}
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	public String getBankName(){
		return this.bankName;
	}

}