package com.pinyougou.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Goods 实体类
 *
 * @version 1.0
 * @date 2018-10-30 20:09:53
 */
@Table(name = "tb_goods")
public class Goods implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /** 主键 */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /** 商家id */
    @Column(name="seller_id")
    private String sellerId;
    /** SPU名称 */
    @Column(name="goods_name")
    private String goodsName;
    /** 默认SKU */
    @Column(name="default_item_id")
    private Long defaultItemId;
    /** 状态 */
    @Column(name="audit_status")
    private String auditStatus;
    /** 是否上架 */
    @Column(name="is_marketable")
    private String isMarketable;
    /** 品牌id */
    @Column(name="brand_id")
    private Long brandId;
    /** 副标题 */
    @Column(name="caption")
    private String caption;
    /** 一级分类 */
    @Column(name="category1_id")
    private Long category1Id;
    /** 二级分类 */
    @Column(name="category2_id")
    private Long category2Id;
    /** 三级分类 */
    @Column(name="category3_id")
    private Long category3Id;
    /** 小图 */
    @Column(name="small_pic")
    private String smallPic;
    /** 商城价 */
    @Column(name="price")
    private BigDecimal price;
    /** 分类模版id */
    @Column(name="type_template_id")
    private Long typeTemplateId;
    /** 是否启用规格 */
    @Column(name="is_enable_spec")
    private String isEnableSpec;
    /** 是否删除 */
    @Column(name="is_delete")
    private String isDelete;


    @Transient
    private List<Item> items;
    @Transient
    private GoodsDesc goodsDesc;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public GoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    /**
     * setter and getter method
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setDefaultItemId(Long defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    public Long getDefaultItemId() {
        return this.defaultItemId;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public String getIsMarketable() {
        return this.isMarketable;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory1Id() {
        return this.category1Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public Long getCategory2Id() {
        return this.category2Id;
    }

    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    public Long getCategory3Id() {
        return this.category3Id;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String getSmallPic() {
        return this.smallPic;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setTypeTemplateId(Long typeTemplateId) {
        this.typeTemplateId = typeTemplateId;
    }

    public Long getTypeTemplateId() {
        return this.typeTemplateId;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public String getIsEnableSpec() {
        return this.isEnableSpec;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsDelete() {
        return this.isDelete;
    }

}