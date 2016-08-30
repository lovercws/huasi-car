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
 * @desc 公共状态 0 分类禁用、1分类正常使用、2 分类删除
 * @author ganliang
 * @version 2016年8月11日 上午9:35:53
 */
public enum PublicEnum {

	/**
	 * 禁用 0
	 */
	FORBIDDEN(0),

	/**
	 * 正常 1
	 */
	NORMAL(1),

	/**
	 * 删除 2
	 */
	DELETE(2);

	/** 描述 */
	private int status;

	private PublicEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int value() {
		return status;
	}
}
