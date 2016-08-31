package org.huasi.car.user.entity;

import java.io.Serializable;

/**
 * @desc 商家用户
 * @author ganliang
 * @version 2016年8月10日 下午3:48:14
 */
public class MerUser implements Serializable {

	private static final long serialVersionUID = -8652757655240084171L;

	private Integer userId;// 商铺用户id
	private String username;// 商铺用户名称
	private String password;// 商铺用户密码
	private String salt;// 商铺用户密码

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "MerUser [userId=" + userId + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ "]";
	}

}