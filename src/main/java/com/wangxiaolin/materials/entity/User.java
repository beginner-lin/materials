package com.wangxiaolin.materials.entity;

/**
 * @author wangxiaolin
 * @date 2019/12/26 - 17:56
 */
public class User {
    private Integer uId;
    private String uName;
    private String uPwd;
    private Integer state;
    private String actualName;
    private String UserSex;
    private String introduce;
    private String image;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "user{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", state=" + state +
                ", actualName='" + actualName + '\'' +
                ", UserSex='" + UserSex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
