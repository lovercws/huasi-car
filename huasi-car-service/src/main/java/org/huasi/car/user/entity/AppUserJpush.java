package org.huasi.car.user.entity;


import java.io.Serializable;

/**
 * @desc 用户极光关系表 
 * @author ganliang
 * @version 2016年8月10日 下午3:47:35
 */
public class AppUserJpush implements Serializable{
	
	private static final long serialVersionUID = 6184055536325476345L;

	private Integer jpushId;// 主键
    private Integer userId;// 用户主键
    private String jpushTags;// Jpush标签（多个标签以”,”号分隔）

    private String jpushAlias;// Jpush别名（一个用户只能有一个别名）
    private String jpushRegistrationid;// Jpush注册id

    public Integer getJpushId() {
        return jpushId;
    }

    public void setJpushId(Integer jpushId) {
        this.jpushId = jpushId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJpushTags() {
        return jpushTags;
    }

    public void setJpushTags(String jpushTags) {
        this.jpushTags = jpushTags == null ? null : jpushTags.trim();
    }

    public String getJpushAlias() {
        return jpushAlias;
    }

    public void setJpushAlias(String jpushAlias) {
        this.jpushAlias = jpushAlias == null ? null : jpushAlias.trim();
    }

    public String getJpushRegistrationid() {
        return jpushRegistrationid;
    }

    public void setJpushRegistrationid(String jpushRegistrationid) {
        this.jpushRegistrationid = jpushRegistrationid == null ? null : jpushRegistrationid.trim();
    }
}