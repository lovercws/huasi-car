/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.huasi.car.common.core.enums;

/**
 * 支付类型枚举类
 */
public enum PayTypeEnum {

	APP("WXPAY APP支付"),

	SCANPAY("扫码支付"),

	H5PAY("H5支付"),

	DIRECT_PAY("即时到账"),

	F2F_PAY("条码支付"),

	ALI_TEST("支付宝测试");

	/** 所属支付方式 */
	private String way;

	public String getWay() {
		return way;
	}

	PayTypeEnum(String way) {
		this.way = way;
	}

}
