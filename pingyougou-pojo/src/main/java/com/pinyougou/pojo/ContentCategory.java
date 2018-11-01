package com.pinyougou.pojo;

/**
 * ContentCategory 实体类
 * @date 2018-10-30 20:09:53
 * @version 1.0
 */
public class ContentCategory implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
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