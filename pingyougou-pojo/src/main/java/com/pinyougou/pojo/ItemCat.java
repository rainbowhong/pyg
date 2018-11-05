package com.pinyougou.pojo;

import javax.persistence.*;

/**
 * ItemCat 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name = "tb_item_cat")
public class ItemCat implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "parent_id")
	private Long parentId;
	@Column(name = "name")
	private String name;
	@Column(name = "type_id")
	private Long typeId;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
	public Long getParentId(){
		return this.parentId;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setTypeId(Long typeId){
		this.typeId = typeId;
	}
	public Long getTypeId(){
		return this.typeId;
	}

}