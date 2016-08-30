package org.hausi.car.jpush.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hausi.car.jpush.exception.JPushDeviceException;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.common.resp.DefaultResult;
import cn.jpush.api.device.AliasDeviceListResult;
import cn.jpush.api.device.OnlineStatus;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.device.TagListResult;

/**
 * jpush device
 * 
 * @author ganliang
 */
public class JPushDeviceService {

	private static final Logger log = Logger.getLogger(JPushDeviceService.class);

	public JPushClient jPushClient;// 极光推送客户端

	public void setjPushClient(JPushClient jPushClient) {
		this.jPushClient = jPushClient;
	}

	/**
	 * 根据注册id，获取tags
	 * 
	 * @param registrationId
	 *            手机注册id
	 * @return
	 * @throws JPushDeviceException
	 */
	public List<String> getDeviceTags(String registrationId) throws JPushDeviceException {
		log.info("getDeviceTags,registrationId[" + registrationId + "]");
		try {
			TagAliasResult deviceTagAlias = jPushClient.getDeviceTagAlias(registrationId);
			List<String> tags = deviceTagAlias.tags;
			log.info("tags " + tags);
			return tags;
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 根据注册id，获取alias[一个注册id只能有一个alias]
	 * 
	 * @param registrationId
	 *            手机注册id
	 * @throws JPushDeviceException
	 */
	public String getDeviceAlias(String registrationId) throws JPushDeviceException {
		log.info("getDeviceAlias,registrationId[" + registrationId + "]");
		try {
			TagAliasResult deviceTagAlias = jPushClient.getDeviceTagAlias(registrationId);
			String alias = deviceTagAlias.alias;
			log.info("tags " + alias);
			return alias;
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 根据设备的注册id 更新别名、标签
	 * 
	 * @param registrationId
	 *            注册id
	 * @param clearAlias
	 *            标签
	 * @param clearTag
	 *            别名
	 * @throws JPushDeviceException
	 */
	public boolean updateDeviceTagAlias(String registrationId, boolean clearAlias, boolean clearTag)
			throws JPushDeviceException {
		log.info("updateDeviceTagAlias,registrationId[" + registrationId + "],clearAlias[" + clearAlias + "],clearTag["
				+ clearTag + "]");
		try {
			DefaultResult result = jPushClient.updateDeviceTagAlias(registrationId, clearAlias, clearTag);
			log.info("result " + result);
			return result.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 根据设备的注册id 更新别名、标签
	 * 
	 * @param registrationId
	 *            注册id
	 * @param alias
	 *            添加的别名
	 * @param tagsToAdd
	 *            添加的标签集合
	 * @throws JPushDeviceException
	 */
	public boolean updateDeviceTagAlias(String registrationId, String alias, Set<String> tagsToAdd)
			throws JPushDeviceException {
		log.info("updateDeviceTagAlias,registrationId[" + registrationId + "],alias[" + alias + "],tagsToAdd["
				+ tagsToAdd + "]");
		try {
			DefaultResult result = jPushClient.updateDeviceTagAlias(registrationId, alias, tagsToAdd, null);
			log.info("result " + result);
			return result.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 绑定手机号码
	 * 
	 * @param registrationId
	 *            注册id
	 * @param mobile
	 *            手机号码
	 * @throws JPushDeviceException
	 */
	public boolean bindMobile(String registrationId, String mobile) throws JPushDeviceException {
		log.info("bindMobile,registrationId[" + registrationId + "],mobile[" + mobile + "]");
		try {
			DefaultResult result = jPushClient.bindMobile(registrationId, mobile);
			log.info("result " + result);
			return result.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	// ------------- tags
	/**
	 * 获取应用的所有标签
	 * 
	 * @return
	 * @throws JPushDeviceException
	 */
	public List<String> getTagList() throws JPushDeviceException {
		log.info("getTagList..........");
		try {
			TagListResult tagList = jPushClient.getTagList();
			List<String> tags = tagList.tags;
			log.info("getTagList " + tags);
			return tags;
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 对标签进行添加用户或者删除用户
	 * 
	 * @param theTag
	 *            标签
	 * @param toAddUsers
	 *            添加用户集合
	 * @param toRemoveUsers
	 *            删除用户集合
	 * @return
	 * @throws JPushDeviceException
	 */
	public boolean addRemoveDevicesFromTag(String theTag, Set<String> toAddUsers, Set<String> toRemoveUsers)
			throws JPushDeviceException {
		log.info("addRemoveDevicesFromTag,theTag[" + theTag + "],toAddUsers[" + toAddUsers + "],toRemoveUsers["
				+ toRemoveUsers + "]");
		try {
			DefaultResult result = jPushClient.addRemoveDevicesFromTag(theTag, toAddUsers, toRemoveUsers);
			log.info("result " + result);
			return result.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 删除标签
	 * 
	 * @param theTag
	 *            标签
	 * @param platform
	 *            平台，为空的时候删除所有的平台
	 * @throws JPushDeviceException
	 */
	public boolean deleteTag(String theTag, String platform) throws JPushDeviceException {
		log.info("deleteTag,theTag[" + theTag + "],platform[" + platform + "]");
		try {
			DefaultResult result = jPushClient.deleteTag(theTag, platform);
			log.info("result " + result);
			return result.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	// ------------- alias
	/**
	 * 获取别名下的用户列表
	 * 
	 * @param alias别名
	 * @param platform平台
	 * @return
	 * @throws JPushDeviceException
	 */
	public List<String> getAliasDeviceList(String alias, String platform) throws JPushDeviceException {
		log.info("getAliasDeviceList,alias[" + alias + "],platform[" + platform + "]");
		try {
			AliasDeviceListResult result = jPushClient.getAliasDeviceList(alias, platform);
			log.info("result " + result);
			return result.registration_ids;
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	/**
	 * 删除别名
	 * 
	 * @param alias别名
	 * @param platform
	 *            平台，为空的时候删除所有的平台
	 * @throws JPushDeviceException
	 */
	public boolean deleteAlias(String alias, String platform) throws JPushDeviceException {
		log.info("bindMobile,alias[" + alias + "],platform[" + platform + "]");
		try {
			DefaultResult result = jPushClient.deleteAlias(alias, platform);
			log.info("result " + result);
			return result.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}

	// -------------- devices status
	/**
	 * 获取用户是否在线
	 * 
	 * @param registrationIds
	 * @return
	 * @throws JPushDeviceException
	 */
	public Map<String, Boolean> getUserOnlineStatus(String... registrationIds) throws JPushDeviceException {
		log.info("getUserOnlineStatus,registrationIds[" + registrationIds + "]");
		try {
			Map<String, OnlineStatus> onlineStatusMap = jPushClient.getUserOnlineStatus(registrationIds);
			Map<String, Boolean> onLineStatus = new HashMap<String, Boolean>();
			for (Entry<String, OnlineStatus> entry : onlineStatusMap.entrySet()) {
				onLineStatus.put(entry.getKey(), entry.getValue().getOnline());
			}
			log.info("result " + onLineStatus);
			return onLineStatus;
		} catch (APIConnectionException e) {
			throw new JPushDeviceException("Connection error", e);
		} catch (APIRequestException e) {
			throw new JPushDeviceException("API request error", e);
		}
	}
}
