package com.pinyougou.pojo;

import javax.persistence.*;

/**
 * ContentCategory 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
@Table(name = "tb_content_category")
public class ContentCategory implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

}