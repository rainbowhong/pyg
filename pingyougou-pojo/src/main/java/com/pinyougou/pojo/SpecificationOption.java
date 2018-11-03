package com.pinyougou.pojo;

import javax.persistence.*;

/**
 * SpecificationOption 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name = "tb_specification_option")
public class SpecificationOption implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "option_name")
	private String optionName;
	@Column(name = "spec_id")
	private Long specId;
	@Column(name="orders")
	private Integer orders;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setOptionName(String optionName){
		this.optionName = optionName;
	}
	public String getOptionName(){
		return this.optionName;
	}
	public void setSpecId(Long specId){
		this.specId = specId;
	}
	public Long getSpecId(){
		return this.specId;
	}
	public void setOrders(Integer orders){
		this.orders = orders;
	}
	public Integer getOrders(){
		return this.orders;
	}

}