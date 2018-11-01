package com.pinyougou.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 11:49 2018/10/29
 * Modified By:
 */
@Table(name = "tb_brand")
public class Brand implements Serializable {

    /*主键ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    /*品牌名称*/
    @Column(name = "name")
    private String name;

    @Column(name = "first_char")
    private String firstChar;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
