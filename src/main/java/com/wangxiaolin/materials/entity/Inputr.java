package com.wangxiaolin.materials.entity;

import java.util.Date;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 13:44
 */
public class Inputr {
    private Integer Ino;
    private Integer Mid;
    private Integer Rid;
    private Integer count;
    private Double value;
    private Date dateTime;
    private Integer deal_Pid;
    private Integer save_Pid;
    private String remark;

    public Integer getIno() {
        return Ino;
    }

    public void setIno(Integer ino) {
        Ino = ino;
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

    public Integer getDeal_Pid() {
        return deal_Pid;
    }

    public void setDeal_Pid(Integer deal_Pid) {
        this.deal_Pid = deal_Pid;
    }

    public Integer getSave_Pid() {
        return save_Pid;
    }

    public void setSave_Pid(Integer save_Pid) {
        this.save_Pid = save_Pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
