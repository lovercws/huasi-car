package org.huasi.car.merchant.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺服务 实体对象
 * @author ganliang
 * @version 2016年8月10日 下午3:56:57
 */
public class MerService implements Serializable{

	private static final long serialVersionUID = -2572274313523092312L;

	private Integer srvId;// 服务id
    private Integer merId;// 商家店铺id
    private Integer classifyId;// 商铺分类id

    private String srvName;// 服务名称
    private Float srvCurPrice;// 服务的当前价格
    private Float srvRelPrice;// 服务的真是价格

    private Integer srvSellCount;// 服务销售数量
    private Integer srvValCount;// 服务评论数量
    private Integer srvScoreStar;// 服务评分星级（1-5星级）

    private String srvFacadeImg;// 服务门面头像(小图)
    private String srvDesc;// 服务描述
    private Date srvCreateTime;// 服务创建的日期

    private Integer srvStatus;// 服务的状态(0 服务禁用、1服务正常使用、2 服务删除)

    public Integer getSrvId() {
        return srvId;
    }

    public void setSrvId(Integer srvId) {
        this.srvId = srvId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getSrvName() {
        return srvName;
    }

    public void setSrvName(String srvName) {
        this.srvName = srvName == null ? null : srvName.trim();
    }

    public Float getSrvCurPrice() {
        return srvCurPrice;
    }

    public void setSrvCurPrice(Float srvCurPrice) {
        this.srvCurPrice = srvCurPrice;
    }

    public Float getSrvRelPrice() {
        return srvRelPrice;
    }

    public void setSrvRelPrice(Float srvRelPrice) {
        this.srvRelPrice = srvRelPrice;
    }

    public Integer getSrvSellCount() {
        return srvSellCount;
    }

    public void setSrvSellCount(Integer srvSellCount) {
        this.srvSellCount = srvSellCount;
    }

    public Integer getSrvValCount() {
        return srvValCount;
    }

    public void setSrvValCount(Integer srvValCount) {
        this.srvValCount = srvValCount;
    }

    public Integer getSrvScoreStar() {
        return srvScoreStar;
    }

    public void setSrvScoreStar(Integer srvScoreStar) {
        this.srvScoreStar = srvScoreStar;
    }

    public String getSrvFacadeImg() {
        return srvFacadeImg;
    }

    public void setSrvFacadeImg(String srvFacadeImg) {
        this.srvFacadeImg = srvFacadeImg == null ? null : srvFacadeImg.trim();
    }

    public String getSrvDesc() {
        return srvDesc;
    }

    public void setSrvDesc(String srvDesc) {
        this.srvDesc = srvDesc == null ? null : srvDesc.trim();
    }

    public Date getSrvCreateTime() {
        return srvCreateTime;
    }

    public void setSrvCreateTime(Date srvCreateTime) {
        this.srvCreateTime = srvCreateTime;
    }

    public Integer getSrvStatus() {
        return srvStatus;
    }

    public void setSrvStatus(Integer srvStatus) {
        this.srvStatus = srvStatus;
    }
}