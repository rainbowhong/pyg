package com.pinyougou.pojo;

import javax.persistence.*;

/**
 * Content 实体类
 * @date 2018-10-30 20:09:52
 * @version 1.0
 */
@Table(name = "tb_content")
public class Content implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "category_id")
	private Long categoryId;
	@Column(name = "title")
	private String title;
	@Column(name = "url")
	private String url;
	@Column(name = "pic")
	private String pic;
	@Column(name = "status")
	private String status = "0";
	@Column(name = "sort_order")
	private Integer sortOrder;

	/** setter and getter method */
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	public Long getCategoryId(){
		return this.categoryId;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return this.url;
	}
	public void setPic(String pic){
		this.pic = pic;
	}
	public String getPic(){
		return this.pic;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setSortOrder(Integer sortOrder){
		this.sortOrder = sortOrder;
	}
	public Integer getSortOrder(){
		return this.sortOrder;
	}

}