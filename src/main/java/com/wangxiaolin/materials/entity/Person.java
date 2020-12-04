package com.wangxiaolin.materials.entity;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 13:45
 */
public class Person {
    private Integer Pid;
    private String Ptype;
    private String Pname;
    private Integer Rid;

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
    }

    public String getPtype() {
        return Ptype;
    }

    public void setPtype(String ptype) {
        Ptype = ptype;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }
}
