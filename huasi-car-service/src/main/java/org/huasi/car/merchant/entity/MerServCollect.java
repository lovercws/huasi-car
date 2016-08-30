package org.huasi.car.merchant.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺服务收藏实体对象 
 * @author ganliang
 * @version 2016年8月10日 下午3:56:36
 */
public class MerServCollect implements Serializable{

	private static final long serialVersionUID = -866532847921708388L;

	private Integer collectId;// 店铺收藏id
    private Integer srvId;// 服务id
    private Integer userId;// 收藏店铺的用户id

    private Date collectCreateTime;// 收藏时间

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getSrvId() {
        return srvId;
    }

    public void setSrvId(Integer srvId) {
        this.srvId = srvId;
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