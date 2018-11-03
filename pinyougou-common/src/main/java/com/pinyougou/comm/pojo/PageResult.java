package com.pinyougou.comm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 21:29 2018/11/1
 * Modified By:
 */
public class PageResult implements Serializable {
    /** 分页数据 */
    private long total;
    /** 总记录数 */
    private List<?> rows;

    public PageResult() {
    }

    public PageResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
