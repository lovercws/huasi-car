package org.huasi.car.common.core.enums;

/**
 * @desc 智能排序
 * @author ganliang
 * @version 2016年8月17日 下午3:20:57
 */
public enum OrdRuleEnum {

	/**
	 * 智能排序
	 */
	INTELLIGENT_ORDERING("1"),

	/**
	 * 评价最好
	 */
	EVALUATION_BEST("2"),

	/**
	 * 人气最高
	 */
	POPULAR_MOST("3");

	/**
	 * 默认智能排序
	 */
	public static final OrdRuleEnum DEFAULT_ORDRULE=INTELLIGENT_ORDERING;
	
	/** 描述 */
	private String status;

	private OrdRuleEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String value() {
		return status;
	}
}
