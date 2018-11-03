package com.pinyougou.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * Specification 实体类
 *
 * @version 1.0
 * @date 2018-10-30 20:09:53
 */
@Table(name = "tb_specification")
public class Specification implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "spec_name")
    private String specName;

    @Transient
    private List<SpecificationOption> specificationOptions;

    public List<SpecificationOption> getSpecificationOptions() {
        return specificationOptions;
    }

    public void setSpecificationOptions(List<SpecificationOption> specificationOptions) {
        this.specificationOptions = specificationOptions;
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

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecName() {
        return this.specName;
    }

}