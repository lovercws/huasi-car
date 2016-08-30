package org.huasi.car.merchant.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺收藏实体对象 
 * @author ganliang
 * @version 2016年8月10日 下午3:54:41
 */
public class MerCollect implements Serializable{

	private static final long serialVersionUID = 1073448823812514370L;

	private Integer collectId;// 店铺收藏id
    private Integer merId;// 店铺id
    private Integer userId;// 收藏店铺的用户id

    private Date collectCreateTime;// 收藏时间

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCollectCreateTime() {
        return collectCreateTime;
    }

    public void setCollectCreateTime(Date collectCreateTime) {
        this.collectCreateTime = collectCreateTime;
    }
}