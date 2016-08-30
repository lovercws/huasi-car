package org.huasi.car.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 订单详情实体对象
 * @author ganliang
 * @version 2016年8月10日 下午3:59:03
 */
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -908108366829673899L;

	private Integer ordDetailId;// 订单详细id
	private Integer ordId;// 订单id
	private String outTradeNo;// 订单流水号
	private Integer userId;// 购买服务的用户id

	private String srvName;// 服务名称
	private Integer srvId;// 服务id
	private Integer merId;// 商铺id

	private Integer ordDetailPrice;// 服务的单价

	private Integer ordDetailCount;// 单件的数量（最多100件）
	private Integer ordDetailTotalPrice;// 该订单详情的总价格

	private Date createTime;// 订单生成时间

	public Integer getOrdDetailId() {
		return ordDetailId;
	}

	public void setOrdDetailId(Integer ordDetailId) {
		this.ordDetailId = ordDetailId;
	}

	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSrvName() {
		return srvName;
	}

	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}

	public Integer getSrvId() {
		return srvId;
	}

	public void setSrvId(Integer srvId) {
		this.srvId = srvId;
	}

	public Integer getMerId() {
		return merId;
	}

	public void setMerId(Integer merId) {
		this.merId = merId;
	}

	public Integer getOrdDetailPrice() {
		return ordDetailPrice;
	}

	public void setOrdDetailPrice(Integer ordDetailPrice) {
		this.ordDetailPrice = ordDetailPrice;
	}

	public Integer getOrdDetailCount() {
		return ordDetailCount;
	}

	public void setOrdDetailCount(Integer ordDetailCount) {
		this.ordDetailCount = ordDetailCount;
	}

	public Integer getOrdDetailTotalPrice() {
		return ordDetailTotalPrice;
	}

	public void setOrdDetailTotalPrice(Integer ordDetailTotalPrice) {
		this.ordDetailTotalPrice = ordDetailTotalPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}