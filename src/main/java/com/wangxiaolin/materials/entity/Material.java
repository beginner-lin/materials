package com.wangxiaolin.materials.entity;

/**
 * @author wangxiaolin
 * @date 2019/12/20 - 13:43
 */
public class Material {
    private Integer Mid;
    private String Mname;
    private String spec;
    private String category;
    private String unit;
    private Double price;

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "Mid=" + Mid +
                ", Mname='" + Mname + '\'' +
                ", spec='" + spec + '\'' +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
