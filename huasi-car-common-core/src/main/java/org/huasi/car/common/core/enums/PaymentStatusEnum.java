package org.huasi.car.common.core.enums;

/**
 * @desc 账单记录状态
 * @author ganliang
 * @version 2016年8月26日 上午10:42:31
 */
public enum PaymentStatusEnum {

	/**
	 * 订单生成 未付款；待付款
	 */
	PAYMENTING,

	/**
	 * 订单付款失败
	 */
	PAYMENT_FAIL,

	/**
	 * 订单付款成功 等待商户同意
	 */
	PAYMENT_SUCCESS;

}
