package com.wangxiaolin.materials.entity;

import java.util.Date;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 13:45
 */
public class Outputr {
    private Integer Ono;
    private Integer Mid;
    private Integer Rid;
    private Integer count;
    private Double value;
    private Date dateTime;
    private Integer user_Pid;
    private Integer deal_Pid;
    private String remark;

    public Integer getOno() {
        return Ono;
    }

    public void setOno(Integer ono) {
        Ono = ono;
    }

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getUser_Pid() {
        return user_Pid;
    }

    public void setUser_Pid(Integer user_Pid) {
        this.user_Pid = user_Pid;
    }

    public Integer getDeal_Pid() {
        return deal_Pid;
    }

    public void setDeal_Pid(Integer deal_Pid) {
        this.deal_Pid = deal_Pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
