package org.huasi.car.user.entity;


import java.io.Serializable;

/**
 * @desc 第三方登陆关系表 
 * @author ganliang
 * @version 2016年8月10日 下午3:47:51
 */
public class AppUserThirdparty implements Serializable{

	private static final long serialVersionUID = -2379358819632083542L;

	private Integer id;// 主键
    private Integer userId;// 用户id
    private String openId;// 第三方登陆的令牌

    private String provider;// 第三方登陆的来源（qq,wechart,sina）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }
}