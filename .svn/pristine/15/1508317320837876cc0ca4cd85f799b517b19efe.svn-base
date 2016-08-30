package org.huasi.car.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 订单退款记录
 * @author ganliang
 * @version 2016年8月23日 下午3:30:02
 */
public class OrderRefundRecord implements Serializable {

	private static final long serialVersionUID = -6445120321594787294L;

	private Integer refundId;// 主键
	private int orderId;// 订单id
	private String outTradeNo;// 订单编码
	private String outRefundNo;// 商户退款编码（唯一性）

	private String refundNo;// 退款单号

	private String transactionId;// 微信订单号
	private String deviceInfo;// 设备信息
	private int refundAmount;// 退款金额(以分为单位)

	private String refundStatus;// REFUNDING退款中;REFUND_SUCCESS退款成功；REFUND_FAIL退款失败（用户取消;退款系统失败）
	private String refundWay;// 退款方式

	private Date refundRequestTime;// 退款请求时间
	private Date refundSuccessTime;// 退款成功时间
	private Date refundCompleteTime;// 退款完成时间

	private String requestApplyFrom;// 申请退款的来源（MERCHANT商家、USER用户）
	private int requestApplyMerUserId;// 商家id
	private int requestApplyUserId;// 用户id

	private String refundReason;// 退款原因
	private String refundDesc;// 退款描述

	public Integer getRefundId() {
		return refundId;
	}

	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getRefundWay() {
		return refundWay;
	}

	public void setRefundWay(String refundWay) {
		this.refundWay = refundWay;
	}

	public Date getRefundRequestTime() {
		return refundRequestTime;
	}

	public void setRefundRequestTime(Date refundRequestTime) {
		this.refundRequestTime = refundRequestTime;
	}

	public Date getRefundSuccessTime() {
		return refundSuccessTime;
	}

	public void setRefundSuccessTime(Date refundSuccessTime) {
		this.refundSuccessTime = refundSuccessTime;
	}

	public Date getRefundCompleteTime() {
		return refundCompleteTime;
	}

	public void setRefundCompleteTime(Date refundCompleteTime) {
		this.refundCompleteTime = refundCompleteTime;
	}

	public String getRequestApplyFrom() {
		return requestApplyFrom;
	}

	public void setRequestApplyFrom(String requestApplyFrom) {
		this.requestApplyFrom = requestApplyFrom;
	}

	public int getRequestApplyMerUserId() {
		return requestApplyMerUserId;
	}

	public void setRequestApplyMerUserId(int requestApplyMerUserId) {
		this.requestApplyMerUserId = requestApplyMerUserId;
	}

	public int getRequestApplyUserId() {
		return requestApplyUserId;
	}

	public void setRequestApplyUserId(int requestApplyUserId) {
		this.requestApplyUserId = requestApplyUserId;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundDesc() {
		return refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

}
