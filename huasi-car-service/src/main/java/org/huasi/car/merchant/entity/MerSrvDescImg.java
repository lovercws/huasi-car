package org.huasi.car.merchant.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺服务描述图片实体对象 
 * @author ganliang
 * @version 2016年8月10日 下午3:57:28
 */
public class MerSrvDescImg implements Serializable{

	private static final long serialVersionUID = -7437123643991231251L;

	private Integer imgId;// 图片id
    private Integer srvId;// 服务id
    private String imgUrl;// 图片地址

    private Date imgCreateTime;// 图片创建的日期
    private Short imgType;// 图片的类型

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getSrvId() {
        return srvId;
    }

    public void setSrvId(Integer srvId) {
        this.srvId = srvId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getImgCreateTime() {
        return imgCreateTime;
    }

    public void setImgCreateTime(Date imgCreateTime) {
        this.imgCreateTime = imgCreateTime;
    }

    public Short getImgType() {
        return imgType;
    }

    public void setImgType(Short imgType) {
        this.imgType = imgType;
    }
}