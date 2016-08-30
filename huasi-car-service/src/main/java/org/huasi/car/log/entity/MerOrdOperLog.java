package org.huasi.car.log.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺订单操作日志记录表 
 * @author ganliang
 * @version 2016年8月10日 下午4:01:05
 */
public class MerOrdOperLog implements Serializable{

	private static final long serialVersionUID = -1318484264206889851L;

	private Integer ordlogId;// 历史记录id
    private Integer userId;// 用户id
    private String ordCode;// 订单内码（订单流水号）

    private Short ordlogType;// 订单操作类型(0 下单；1 取消；2 付款失败；3付款成功;4 评价)
    private String ordlogDesc;// 订单记录描述
    private Date ordlogCreateTime;// 订单生成时间

    public Integer getOrdlogId() {
        return ordlogId;
    }

    public void setOrdlogId(Integer ordlogId) {
        this.ordlogId = ordlogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode == null ? null : ordCode.trim();
    }

    public Short getOrdlogType() {
        return ordlogType;
    }

    public void setOrdlogType(Short ordlogType) {
        this.ordlogType = ordlogType;
    }

    public String getOrdlogDesc() {
        return ordlogDesc;
    }

    public void setOrdlogDesc(String ordlogDesc) {
        this.ordlogDesc = ordlogDesc == null ? null : ordlogDesc.trim();
    }

    public Date getOrdlogCreateTime() {
        return ordlogCreateTime;
    }

    public void setOrdlogCreateTime(Date ordlogCreateTime) {
        this.ordlogCreateTime = ordlogCreateTime;
    }
}