package org.huasi.car.common.core.enums;

/**
 * @desc 平台交易类型
 * @author ganliang
 * @version 2016年8月25日 上午11:46:00
 */
public enum TradeTypeEnum {

	/**
	 * 订单消费
	 */
	EXPEND("消费"),

	/**
	 * 充值
	 */
	RECHARGE("充值");

	public String desc;

	private TradeTypeEnum(String desc) {
		this.desc = desc;
	}

}
