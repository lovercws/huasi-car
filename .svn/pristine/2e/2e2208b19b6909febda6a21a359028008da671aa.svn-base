package org.huasi.car.common.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 基本日志实体对象
 * @author ganliang
 * @version 2016年8月12日 下午4:15:19
 */
public class BaseLog implements Serializable {

	private static final long serialVersionUID = 7078859991093893070L;

	private String logId;// 主键ID.
	private String logName;// 日志模块名称

	private Integer usetime;// 注册花费时间 以毫秒为单位
	private String logContent;// 注册返回日志内容

	private Date createTime = new Date();// 创建时间.
	private Integer logStatus = 1;// 日志状态 0 删除 1 正常

	private String ipAddress;// ip地址

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public Integer getUsetime() {
		return usetime;
	}

	public void setUsetime(Integer usetime) {
		this.usetime = usetime;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
