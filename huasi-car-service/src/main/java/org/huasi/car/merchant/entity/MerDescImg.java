package org.huasi.car.merchant.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺描述图片实体对象 
 * @author ganliang
 * @version 2016年8月10日 下午3:54:59
 */
public class MerDescImg implements Serializable{

	private static final long serialVersionUID = -528603688259767159L;

	private Integer imgId;// 图片id
    private Integer merId;// 商铺id
    private String imgUrl;// 图片地址

    private Date imgCreateTime;// 图片创建的日期
    private Short imgType;// 商家描述图片的类型 (1环境图、2门面图)

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
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