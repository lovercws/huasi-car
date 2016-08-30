package org.huasi.car.system.entity;

import java.io.Serializable;

/**
 * @desc 车辆商标 字典表
 * @author ganliang
 * @version 2016年8月10日 下午4:03:25
 */
public class SysCarBrand implements Serializable{

	private static final long serialVersionUID = 4852536738424541531L;

	private Integer brandId;// 主键id（自增）
    private String brandInitial;// 车标的首字母
    private String brandName;// 车商标

    private String brandEname;// 商标的英文名字
    private String brandLogo;// 车商标图片地址
    private String brandCountry;// 车标国家

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandInitial() {
        return brandInitial;
    }

    public void setBrandInitial(String brandInitial) {
        this.brandInitial = brandInitial == null ? null : brandInitial.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandEname() {
        return brandEname;
    }

    public void setBrandEname(String brandEname) {
        this.brandEname = brandEname == null ? null : brandEname.trim();
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry == null ? null : brandCountry.trim();
    }
}