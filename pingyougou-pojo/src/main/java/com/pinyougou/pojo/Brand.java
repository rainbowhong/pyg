package com.pinyougou.pojo;

import java.io.Serializable;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 11:49 2018/10/29
 * Modified By:
 */
public class Brand implements Serializable{

    private long id;
    private String name;
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
