package com.wangxiaolin.materials.entity;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 13:45
 */
public class Rest {
    private Integer Mid;
    private Integer Rid;
    private Integer count;
    private Double value;
    private String remark;

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
