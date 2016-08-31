package org.huasi.car.merchant.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺实体对象
 * @author ganliang
 * @version 2016年8月10日 下午3:51:04
 */
public class Merchant implements Serializable {

	private static final long serialVersionUID = 6940709076141660665L;

	private Integer merId;// 商铺id
	private String merCode;// 商铺代码
	private String merName;// 商铺名称

	private String merDesc;// 商铺的描述
	private String merBusinessHour;// 商铺的营业时间
	private String merFacadeImg;// 商铺的门面图片（头像 小）

	private Integer merCompStar;// 商铺综合评分星级（1-5星）
	private Integer merCapStar;// 商铺能力评分
	private Integer merServStar;// 商铺服务评分

	private Integer merOrdCount;// 商铺评价数量
	private Integer merEvaCount;// 商铺评价数量
	private Double merLat;// 商铺的纬度
	private Double merLang;// 商铺的经度

	private String merContact;// 商铺的座机电话
	private String merPhone;// 商铺的手机号码
	private String merDetailArea;// 商铺的详细地址

	private String pName;// 商铺的区域 省区域名称
	private String pCode;// 商铺的区域 省区域内码
	private String cName;// 市区域名称
	private String cCode;// 市区域内码
	private String aName;// 地区区域名称
	private String aCode;// 地区区域内码

	private Short merImgCount;// 商铺描述的图片数量（商铺的图片数量小于100）
	private Boolean merIsGroup;// True支持团购，默认false
	private Short merStatus;// 分类的状态(0 分类禁用、1分类正常使用、2 分类删除)

	private Date merCreateTime;// 店铺创建时间
	private Integer merUserId;// 创建店铺的商家用户

	private String classifyNames;// 商铺分类名称集合（分类以‘,’号分隔）

	public Integer getMerId() {
		return merId;
	}

	public void setMerId(Integer merId) {
		this.merId = merId;
	}

	public String getMerCode() {
		return merCode;
	}

	public void setMerCode(String merCode) {
		this.merCode = merCode == null ? null : merCode.trim();
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName == null ? null : merName.trim();
	}

	public String getMerDesc() {
		return merDesc;
	}

	public void setMerDesc(String merDesc) {
		this.merDesc = merDesc == null ? null : merDesc.trim();
	}

	public String getMerBusinessHour() {
		return merBusinessHour;
	}

	public void setMerBusinessHour(String merBusinessHour) {
		this.merBusinessHour = merBusinessHour == null ? null : merBusinessHour.trim();
	}

	public String getMerFacadeImg() {
		return merFacadeImg;
	}

	public void setMerFacadeImg(String merFacadeImg) {
		this.merFacadeImg = merFacadeImg == null ? null : merFacadeImg.trim();
	}

	public Integer getMerCompStar() {
		return merCompStar;
	}

	public void setMerCompStar(Integer merCompStar) {
		this.merCompStar = merCompStar;
	}

	public Integer getMerCapStar() {
		return merCapStar;
	}

	public void setMerCapStar(Integer merCapStar) {
		this.merCapStar = merCapStar;
	}

	public Integer getMerServStar() {
		return merServStar;
	}

	public void setMerServStar(Integer merServStar) {
		this.merServStar = merServStar;
	}

	public Integer getMerOrdCount() {
		return merOrdCount;
	}

	public void setMerOrdCount(Integer merOrdCount) {
		this.merOrdCount = merOrdCount;
	}

	public Integer getMerEvaCount() {
		return merEvaCount;
	}

	public void setMerEvaCount(Integer merEvaCount) {
		this.merEvaCount = merEvaCount;
	}

	public Double getMerLat() {
		return merLat;
	}

	public void setMerLat(Double merLat) {
		this.merLat = merLat;
	}

	public Double getMerLang() {
		return merLang;
	}

	public void setMerLang(Double merLang) {
		this.merLang = merLang;
	}

	public String getMerContact() {
		return merContact;
	}

	public void setMerContact(String merContact) {
		this.merContact = merContact == null ? null : merContact.trim();
	}

	public String getMerPhone() {
		return merPhone;
	}

	public void setMerPhone(String merPhone) {
		this.merPhone = merPhone == null ? null : merPhone.trim();
	}

	public String getMerDetailArea() {
		return merDetailArea;
	}

	public void setMerDetailArea(String merDetailArea) {
		this.merDetailArea = merDetailArea == null ? null : merDetailArea.trim();
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getaCode() {
		return aCode;
	}

	public void setaCode(String aCode) {
		this.aCode = aCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public Short getMerImgCount() {
		return merImgCount;
	}

	public void setMerImgCount(Short merImgCount) {
		this.merImgCount = merImgCount;
	}

	public Boolean getMerIsGroup() {
		return merIsGroup;
	}

	public void setMerIsGroup(Boolean merIsGroup) {
		this.merIsGroup = merIsGroup;
	}

	public Short getMerStatus() {
		return merStatus;
	}

	public void setMerStatus(Short merStatus) {
		this.merStatus = merStatus;
	}

	public Date getMerCreateTime() {
		return merCreateTime;
	}

	public void setMerCreateTime(Date merCreateTime) {
		this.merCreateTime = merCreateTime;
	}

	public Integer getMerUserId() {
		return merUserId;
	}

	public void setMerUserId(Integer merUserId) {
		this.merUserId = merUserId;
	}

	/////// 非实体对象
	private String classifyId;// 分类id
	private String ordruleId;// 智能排序id

	public String getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getOrdruleId() {
		return ordruleId;
	}

	public void setOrdruleId(String ordruleId) {
		this.ordruleId = ordruleId;
	}

	public String getClassifyNames() {
		return classifyNames;
	}

	public void setClassifyNames(String classifyNames) {
		this.classifyNames = classifyNames;
	}

	///////////////////////////////
	private double distance;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
