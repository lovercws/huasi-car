package org.huasi.car.info.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 动态类
 */
public class Active implements Serializable {

	private static final long serialVersionUID = -2232507444130954818L;

	private int activeId;// 动态主键Id
	private int activeClassifyId;// 动态分类id
	private String activeName;// 动态名称
	private String activeDesc;// 动态描述
	private int activeCommCount;// 动态评论数量
	private int activeLikeCount;// 动态评论的点赞数量
	private String activeImg;// 动态图片
	private int activeStatus;// 动态的状态 0禁用；1正常；2删除
	private Date activeCreateTime;// 发布时间

	public int getActiveId() {
		return activeId;
	}

	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}

	public int getActiveClassifyId() {
		return activeClassifyId;
	}

	public void setActiveClassifyId(int activeClassifyId) {
		this.activeClassifyId = activeClassifyId;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public String getActiveDesc() {
		return activeDesc;
	}

	public void setActiveDesc(String activeDesc) {
		this.activeDesc = activeDesc;
	}

	public int getActiveCommCount() {
		return activeCommCount;
	}

	public void setActiveCommCount(int activeCommCount) {
		this.activeCommCount = activeCommCount;
	}

	public int getActiveLikeCount() {
		return activeLikeCount;
	}

	public void setActiveLikeCount(int activeLikeCount) {
		this.activeLikeCount = activeLikeCount;
	}

	public String getActiveImg() {
		return activeImg;
	}

	public void setActiveImg(String activeImg) {
		this.activeImg = activeImg;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getActiveCreateTime() {
		return activeCreateTime;
	}

	public void setActiveCreateTime(Date activeCreateTime) {
		this.activeCreateTime = activeCreateTime;
	}

}
