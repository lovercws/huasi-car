package org.huasi.car.merchant.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺排序规则（智能排序） 
 * @author ganliang
 * @version 2016年8月10日 下午3:55:48
 */
public class MerOrdRule implements Serializable{

	private static final long serialVersionUID = -2115687735547840710L;

	private Integer ordruleId;// 规则id
    private String ordruleName;// 规则名称
    private Date ordruleCreateTime;// 创建的日期

    private Integer ordruleStatus;// 区域的状态(0 区域禁用、1区域正常使用、2 区域删除)
    private Short ordruleOrder;// 规则排序 值打的排在前面

    public Integer getOrdruleId() {
        return ordruleId;
    }

    public void setOrdruleId(Integer ordruleId) {
        this.ordruleId = ordruleId;
    }

    public String getOrdruleName() {
        return ordruleName;
    }

    public void setOrdruleName(String ordruleName) {
        this.ordruleName = ordruleName == null ? null : ordruleName.trim();
    }

    public Date getOrdruleCreateTime() {
        return ordruleCreateTime;
    }

    public void setOrdruleCreateTime(Date ordruleCreateTime) {
        this.ordruleCreateTime = ordruleCreateTime;
    }

    public Integer getOrdruleStatus() {
        return ordruleStatus;
    }

    public void setOrdruleStatus(Integer ordruleStatus) {
        this.ordruleStatus = ordruleStatus;
    }

    public Short getOrdruleOrder() {
        return ordruleOrder;
    }

    public void setOrdruleOrder(Short ordruleOrder) {
        this.ordruleOrder = ordruleOrder;
    }
}