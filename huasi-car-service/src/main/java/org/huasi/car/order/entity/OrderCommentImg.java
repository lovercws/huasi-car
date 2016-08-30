package org.huasi.car.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺订单评论图片 
 * @author ganliang
 * @version 2016年8月10日 下午4:05:02
 */
public class OrderCommentImg implements Serializable{

	private static final long serialVersionUID = -7224117267887568264L;

	private Integer imgId;// 图片id
    private Integer commId;// 评论id
    private String imgUrl;// 图片地址

    private Date imgCreateTime;// 图片创建的日期
    private Short imgType;// 图片的类型

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
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