package org.huasi.car.merchant.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺推荐服务实体引用表 
 * @author ganliang
 * @version 2016年8月10日 下午3:56:09
 */
public class MerRecomServ implements Serializable{

	private static final long serialVersionUID = 1854640943856344548L;

	private Integer recomservId;// 主键id
    private Integer srvId;// 服务id
    private Integer recomservOrder;// 推荐排序

    private Date recomservCreateTime;// 推荐时间

    public Integer getRecomservId() {
        return recomservId;
    }

    public void setRecomservId(Integer recomservId) {
        this.recomservId = recomservId;
    }

    public Integer getSrvId() {
        return srvId;
    }

    public void setSrvId(Integer srvId) {
        this.srvId = srvId;
    }

    public Integer getRecomservOrder() {
        return recomservOrder;
    }

    public void setRecomservOrder(Integer recomservOrder) {
        this.recomservOrder = recomservOrder;
    }

    public Date getRecomservCreateTime() {
        return recomservCreateTime;
    }

    public void setRecomservCreateTime(Date recomservCreateTime) {
        this.recomservCreateTime = recomservCreateTime;
    }
}