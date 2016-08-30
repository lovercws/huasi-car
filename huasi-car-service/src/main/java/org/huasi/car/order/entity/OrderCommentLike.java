package org.huasi.car.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺订单评论 赞
 * @author ganliang
 * @version 2016年8月10日 下午4:05:19
 */
public class OrderCommentLike implements Serializable {

	private static final long serialVersionUID = -4029405465357987943L;

	private Integer commlikeId;// 点赞id
	private Integer commId;// 评论id
	private Integer userId;// 点赞的用户id

	private Date commlikeCreateTime;// 图片创建的日期

	public Integer getCommlikeId() {
		return commlikeId;
	}

	public void setCommlikeId(Integer commlikeId) {
		this.commlikeId = commlikeId;
	}

	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCommlikeCreateTime() {
		return commlikeCreateTime;
	}

	public void setCommlikeCreateTime(Date commlikeCreateTime) {
		this.commlikeCreateTime = commlikeCreateTime;
	}
}