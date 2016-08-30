package org.huasi.car.merchant.enums;

public enum MerClassifyLevelEnum {

	/**
	 * 所有级别的分类
	 */
	ALL(0),

	/**
	 * 一级大分类
	 */
	FIRST_CLASSIFY(1),

	/**
	 * 二级分类
	 */
	SECOND_CLASSIFY(2);

	/** 描述 */
	private int level;

	private MerClassifyLevelEnum(int level) {
		this.level = level;
	}

	public int value() {
		return level;
	}
}
