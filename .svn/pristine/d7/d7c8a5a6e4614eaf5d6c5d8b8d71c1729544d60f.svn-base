package org.huasi.car.merchant.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺分类
 * @author ganliang
 * @version 2016年8月10日 下午3:51:21
 */
public class MerClassify implements Serializable {

	private static final long serialVersionUID = 5116844187126192111L;

	private Integer classifyId;// 分类id
	private String classifyCode;// 分类代码
	private String classifyName;// 分类名称

	private String classifyImage;// 分类图片地址

	private Integer prtClassifyId;// 父分类id（如果没有父分类，则默认为0 或者null）
	private Integer classifyMerCount;// 分类下商铺的数量
	private Date classifyCreateTime;// 分类创建的日期

	private Short classifyStatus;// 分类的状态(0 分类禁用、1分类正常使用、2 分类删除)
	private Short classifyOrder;// 商家分类的排序

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public String getClassifyCode() {
		return classifyCode;
	}

	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode == null ? null : classifyCode.trim();
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName == null ? null : classifyName.trim();
	}

	public Integer getPrtClassifyId() {
		return prtClassifyId;
	}

	public void setPrtClassifyId(Integer prtClassifyId) {
		this.prtClassifyId = prtClassifyId;
	}

	public Integer getClassifyMerCount() {
		return classifyMerCount;
	}

	public void setClassifyMerCount(Integer classifyMerCount) {
		this.classifyMerCount = classifyMerCount;
	}

	public Date getClassifyCreateTime() {
		return classifyCreateTime;
	}

	public void setClassifyCreateTime(Date classifyCreateTime) {
		this.classifyCreateTime = classifyCreateTime;
	}

	public Short getClassifyStatus() {
		return classifyStatus;
	}

	public void setClassifyStatus(Short classifyStatus) {
		this.classifyStatus = classifyStatus;
	}

	public Short getClassifyOrder() {
		return classifyOrder;
	}

	public void setClassifyOrder(Short classifyOrder) {
		this.classifyOrder = classifyOrder;
	}

	public String getClassifyImage() {
		return classifyImage;
	}

	public void setClassifyImage(String classifyImage) {
		this.classifyImage = classifyImage;
	}

}