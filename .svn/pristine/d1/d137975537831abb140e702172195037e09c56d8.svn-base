package org.hausi.car.jpush.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.hausi.car.jpush.exception.JPushMessageException;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

/**
 * 极光推送消息
 * @author ganliang
 */
public class JPushMessageService {

	private static final Logger log = Logger.getLogger(JPushMessageService.class);
	public JPushClient jPushClient;//极光推送客户端
	public void setjPushClient(JPushClient jPushClient) {
		this.jPushClient = jPushClient;
	}
	///////////////////////////////////////////////////////// android message Alias ///////////////////////////////////////////////////////////
	/**
	 * android手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithAlias(String title, String msgContent, String... alias) throws JPushMessageException {
		return sendAndroidMessageWithAlias(title, msgContent, null, alias);
	}
	/**
	 * android手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithAlias(String title, String msgContent,String smsContent,int smsDelayTime,String... alias) throws JPushMessageException {
		return sendAndroidMessageWithAlias(title, msgContent, SMS.content(smsContent, smsDelayTime), alias);
	}
	/**
	 * android手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithAlias(String title, String msgContent,SMS sms,String... alias) throws JPushMessageException{
		log.info("push android message,title["+title+"],msgContent["+msgContent+"],alias["+alias+"]");
		try {
			PushResult pushResult = jPushClient.sendAndroidMessageWithAlias(title, msgContent, alias);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// android message registrationID ///////////////////////////////////////////////////////////
	/**
	 * android手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param registrationID 极光手机注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithRegistrationID(String title, String msgContent,String registrationID) throws JPushMessageException {
		return sendAndroidMessageWithRegistrationID(title, msgContent, null, registrationID);
	}
	/**
	 * android手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	  *@param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param registrationID 极光手机注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithRegistrationID(String title, String msgContent,String smsContent,int smsDelayTime,String registrationID) throws JPushMessageException {
		return sendAndroidMessageWithRegistrationID(title, msgContent, SMS.content(smsContent, smsDelayTime), registrationID);
	}
	/**
	 * android手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param registrationID 极光手机注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithRegistrationID(String title, String msgContent,SMS sms,String registrationID) throws JPushMessageException {
		log.info("push android message,title["+title+"],msgContent["+msgContent+"],sms["+sms+"],registrationID["+registrationID+"]");
		try {
			PushResult pushResult = jPushClient.sendAndroidMessageWithRegistrationID(title, msgContent, sms, registrationID);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// android Notification alias ///////////////////////////////////////////////////////////
	/**
	 * android手机发送通知
	 * @param title 消息标题
	 * @param alert 通知内容
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithAlias(String title, String alert,String... alias) throws JPushMessageException {
		return sendAndroidNotificationWithAlias(title, alert, null, null, alias);
	}
	/**
	 * android手机发送通知
	 * @param title 消息标题
	 * @param alert 通知内容
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithAlias(String title, String alert,SMS sms,String... alias) throws JPushMessageException {
		return sendAndroidNotificationWithAlias(title, alert, sms, null, alias);
	}
	/**
	 * android手机发送通知
	 * @param title 通知标题
	 * @param alert 通知内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithAlias(String title, String alert,String smsContent,int smsDelayTime,String... alias) throws JPushMessageException {
		return sendAndroidNotificationWithAlias(title, alert, SMS.content(smsContent, smsDelayTime), null, alias);
	}
	/**
	 * android手机发送提醒
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param extras 额外的参数
	 * @param registrationID 极光手机注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithAlias(String title, String alert,SMS sms,Map<String,String> extras,String... alias) throws JPushMessageException {
		log.info("push android notification,title["+title+"],msgContent["+alert+"],sms["+sms+"],extras["+extras+"],alias["+alias+"]");
		try {
			PushResult pushResult = jPushClient.sendAndroidNotificationWithAlias(title, alert, sms, extras, alias);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// android Notification registrationID ///////////////////////////////////////////////////////////
	/**
	 * android手机发送通知
	 * @param title 通知标题
	 * @param alert 通知内容
	 * @param registrationID 设备注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithRegistrationID(String title, String alert,String registrationID) throws JPushMessageException {
		return sendAndroidNotificationWithRegistrationID(title, alert, null, null, registrationID);
	}
	/**
	 * android手机发送通知
	 * @param title 通知标题
	 * @param alert 通知内容
	 * @param registrationID 设备注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithRegistrationID(String title, String alert,SMS sms,String registrationID) throws JPushMessageException {
		return sendAndroidNotificationWithRegistrationID(title, alert, sms, null, registrationID);
	}
	/**
	 * android手机发送通知
	 * @param title 通知标题
	 * @param alert 通知内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param registrationID 设备注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithRegistrationID(String title, String alert,String smsContent,int smsDelayTime,String registrationID) throws JPushMessageException {
		return sendAndroidNotificationWithRegistrationID(title, alert, SMS.content(smsContent, smsDelayTime), null, registrationID);
	}
	/**
	 * android手机发送通知
	 * @param title 通知标题
	 * @param alert 通知内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param extras 额外的参数
	 * @param registrationID 极光手机注册id
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithRegistrationID(String title, String alert,SMS sms,Map<String,String> extras,String registrationID) throws JPushMessageException {
		log.info("push android notification,title["+title+"],msgContent["+alert+"],sms["+sms+"],extras["+extras+"],registrationID["+registrationID+"]");
		try {
			PushResult pushResult = jPushClient.sendAndroidNotificationWithRegistrationID(title, alert, sms, extras, registrationID);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios message Alias ///////////////////////////////////////////////////////////
	/**
	 * ios手机发送消息
	 * @param title 消息标题
	 * @param alert 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithAlias(String title, String msgContent,String... alias) throws JPushMessageException {
		return sendIosMessageWithAlias(title, msgContent, null, alias);
	}
	/**
	 * ios手机发送消息
	 * @param title 消息标题
	 * @param alert 消息内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithAlias(String title, String msgContent,String smsContent,int smsDeleayTime,String... alias) throws JPushMessageException {
		return sendIosMessageWithAlias(title, msgContent, SMS.content(smsContent, smsDeleayTime), alias);
	}
	/**
	 * ios手机发送消息
	 * @param title 消息标题
	 * @param alert 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信[ios不会延迟 会立即发送sms消息]
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithAlias(String title, String msgContent,SMS sms,String... alias) throws JPushMessageException {
		log.info("push ios message,title["+title+"],msgContent["+msgContent+"],sms["+sms+"],alias["+alias+"]");
		try {
			PushResult pushResult = jPushClient.sendIosMessageWithAlias(title, msgContent,sms, alias);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios message RegistrationID ///////////////////////////////////////////////////////////
	/**
	 * ios手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param registrationID 设备注册id,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithRegistrationID(String title, String msgContent,String... registrationID) throws JPushMessageException {
		return sendIosMessageWithRegistrationID(title, msgContent, null, registrationID);
	}
	/**
	 * ios手机发送消息
	 * @param title 消息标题
	 * @param alert 消息内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param registrationID 设备注册id,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithRegistrationID(String title, String msgContent,String smsContent,int smsDeleayTime,String... registrationID) throws JPushMessageException {
		return sendIosMessageWithRegistrationID(title, msgContent, SMS.content(smsContent, smsDeleayTime), registrationID);
	}
	/**
	 * ios手机发送消息
	 * @param title 消息标题
	 * @param msgContent 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param registrationID 设备注册id,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithRegistrationID(String title, String msgContent,SMS sms,String... registrationID) throws JPushMessageException {
		log.info("push ios message,title["+title+"],msgContent["+msgContent+"],sms["+sms+"],registrationID["+registrationID+"]");
		try {
			PushResult pushResult = jPushClient.sendIosMessageWithRegistrationID(title, msgContent, sms, registrationID);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios notification alias ///////////////////////////////////////////////////////////
	/**
	 * ios手机发送通知
	 * @param alert 通知内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param extras 额外的参数
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosNotificationWithAlias(String alert,String smsContent,int smsDelayTime,Map<String,String> extras,String... alias) throws JPushMessageException {
		return sendIosNotificationWithAlias(alert, SMS.content(smsContent, smsDelayTime), extras, alias);
	}
	/**
	 * ios手机发送通知
	 * @param alert 通知内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param extras 额外的参数
	 * @param alias 设备别名,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosNotificationWithAlias(String alert,SMS sms,Map<String,String> extras,String... alias) throws JPushMessageException {
		log.info("push ios notification,alert["+alert+"],sms["+sms+"],extras["+extras+"],alias["+alias+"]");
		try {
			PushResult pushResult = jPushClient.sendIosNotificationWithAlias(alert, sms, extras, alias);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios notification registrationID ///////////////////////////////////////////////////////////
	/**
	 * ios手机发送通知
	 * @param alert 通知内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param extras 额外的参数
	 * @param registrationID 设备注册id,可变参数,支持多个别名
	 * @throws JPushMessageException 
	 */
	public boolean sendIosNotificationWithRegistrationID(String alert,String smsContent,int smsDelayTime,Map<String,String> extras,String... registrationID) throws JPushMessageException {
		return sendIosNotificationWithRegistrationID(alert, SMS.content(smsContent, smsDelayTime), extras, registrationID);
	}
	/**
	 * ios手机发送通知
	 * @param alert 通知内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @param extras 额外的参数
	 * @param registrationID 设备注册id,可变参数,支持多个
	 * @throws JPushMessageException 
	 */
	public boolean sendIosNotificationWithRegistrationID(String alert,SMS sms,Map<String,String> extras,String... registrationID) throws JPushMessageException {
		log.info("push ios notification,alert["+alert+"],sms["+sms+"],extras["+extras+"],registrationID["+registrationID+"]");
		try {
			PushResult pushResult = jPushClient.sendIosNotificationWithRegistrationID(alert, extras, registrationID);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios、android message all///////////////////////////////////////////////////////////
	/**
	 * 对所有的设备发送消息
	 * @param msgContent 消息内容
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageAll(String msgContent) throws JPushMessageException{
		return sendMessageAll(msgContent, null);
	}
	/**
	 * 对所有的设备发送消息
	 * @param msgContent 消息内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageAll(String msgContent,String smsContent,int smsDelayTime) throws JPushMessageException{
		return sendMessageAll(msgContent, SMS.content(smsContent, smsDelayTime));
	}
	/**
	 * 对所有的设备发送消息
	 * @param msgContent 消息内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageAll(String msgContent,SMS sms) throws JPushMessageException{
		log.info("push all message,msgContent["+msgContent+"],sms["+sms+"]");
		try {
			PushResult pushResult = jPushClient.sendMessageAll(msgContent, sms);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios、android message registrationID///////////////////////////////////////////////////////////
	/**
	 * 根据设备注册id发送消息
	 * @param title
	 * @param msgContent
	 * @param registrationID 设备注册id,可变参数,支持多个
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageWithRegistrationID(String title,String msgContent,String... registrationID) throws JPushMessageException{
		return sendIosMessageWithRegistrationID(title, msgContent, null, registrationID);
	}
	/**
	 * 根据设备注册id发送消息
	 * @param title
	 * @param msgContent
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @param registrationID
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageWithRegistrationID(String title,String msgContent,String smsContent,int smsDelayTime,String... registrationID) throws JPushMessageException{
		return sendMessageWithRegistrationID(title, msgContent, SMS.content(smsContent, smsDelayTime), registrationID);
	}
	/**
	 * 根据设备注册id发送消息
	 * @param title
	 * @param msgContent
	 * @param registrationID
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageWithRegistrationID(String title,String msgContent,SMS sms,String... registrationID) throws JPushMessageException{
		log.info("push all message,title["+title+"],msgContent["+msgContent+"],sms["+sms+"],registrationID:["+registrationID+"]");
		try {
			PushResult pushResult = jPushClient.sendMessageWithRegistrationID(title, msgContent,sms,registrationID);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	///////////////////////////////////////////////////////// ios、android notification all///////////////////////////////////////////////////////////
	/**
	 * 对所有的设备发送通知
	 * @param alert 通知内容
	 * @throws JPushMessageException 
	 */
	public boolean sendNotificationAll(String alert) throws JPushMessageException{
		return sendNotificationAll(alert, null);
	}
	/**
	 * 对所有的设备发送通知
	 * @param alert 通知内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 发送短信的延迟时间
	 * @throws JPushMessageException 
	 */
	public boolean sendNotificationAll(String alert,String smsContent,int smsDelayTime) throws JPushMessageException{
		return sendNotificationAll(alert, SMS.content(smsContent, smsDelayTime));
	}
	/**
	 * 对所有的设备发送通知
	 * @param alert 通知内容
	 * @param sms 在一定的延迟之后,如果用户没有收到消息,则发送一条短信
	 * @throws JPushMessageException 
	 */
	public boolean sendNotificationAll(String alert,SMS sms) throws JPushMessageException{
		log.info("push all Notification,alert["+alert+"],sms["+sms+"]");
		try {
			PushResult pushResult = jPushClient.sendNotificationAll(alert, sms);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	/**
	 * 根据payload发送消息
	 * @param payload
	 * @throws JPushMessageException 
	 */
	public boolean sendPush(PushPayload payload) throws JPushMessageException {
		log.info("push payload,payload["+payload+"]");
		try {
			PushResult pushResult = jPushClient.sendPush(payload);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	/**
	 * 根据payload发送消息
	 * @param payload
	 * @throws JPushMessageException 
	 */
	public boolean sendPushValidate(PushPayload payload) throws JPushMessageException {
		log.info("push validate,payload["+payload+"]");
		try {
			PushResult pushResult = jPushClient.sendPush(payload);
			log.info("Got result - " + pushResult);
			return pushResult.isResultOK();
		} catch (APIConnectionException e) {
			throw new JPushMessageException("Connection error",e);
		} catch (APIRequestException e) {
			throw new JPushMessageException("API request error",e);
		}
	}
	
	/////////////////////////////////////////////////////////android message tag ///////////////////////////////////////////////////////////
	/**
	 * 发送android消息
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithTags(String msgContent,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				   .setPlatform(Platform.android())
				   .setAudience(Audience.tag_and(tag))
				   .setMessage(Message.content(msgContent))
				   .build();
		return sendPush(pushPayload);
	}
	/**
	 * 发送android消息
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidMessageWithTags(String msgContent,String smsContent,int smsDelayTime,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.tag_and(tag))
				.setSMS(SMS.content(smsContent, smsDelayTime))
				.setMessage(Message.content(msgContent))
				.build();
		return sendPush(pushPayload);
	}
	
	/////////////////////////////////////////////////////////android Notification tag ///////////////////////////////////////////////////////////
	/**
	 * 发送ios通知
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendIosNotificationWithTags(String alert,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.tag_and(tag))
				.setNotification(Notification.alert(alert))
				.build();
		return sendPush(pushPayload);
	}
	/**
	 * 发送ios通知
	 * @param msgContent 消息内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 延迟多久,未收到消息，即发送短信
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendIosNotificationWithTags(String alert,String smsContent,int smsDelayTime,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.tag_and(tag))
				.setSMS(SMS.content(smsContent, smsDelayTime))
				.setNotification(Notification.alert(alert))
				.build();
		return sendPush(pushPayload);
	}
	
	/////////////////////////////////////////////////////////ios message tag ///////////////////////////////////////////////////////////
	/**
	 * 发送ios消息
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithTags(String msgContent,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and(tag))
				.setMessage(Message.content(msgContent))
				.build();
		return sendPush(pushPayload);
	}
	/**
	 * 发送ios消息
	 * @param msgContent 消息内容
	 * @param smsContent 短信内容
	 * @param smsDelayTime 延迟多久,未收到消息，即发送短信
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendIosMessageWithTags(String msgContent,String smsContent,int smsDelayTime,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and(tag))
				.setSMS(SMS.content(smsContent, smsDelayTime))
				.setMessage(Message.content(msgContent))
				.build();
		return sendPush(pushPayload);
	}
	
	/////////////////////////////////////////////////////////ios Notification tag ///////////////////////////////////////////////////////////
	/**
	 * 发送android通知
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithTags(String alert,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.tag_and(tag))
				.setNotification(Notification.alert(alert))
				.build();
		return sendPush(pushPayload);
	}
	/**
	 * 发送android通知
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendAndroidNotificationWithTags(String alert,String smsContent,int smsDelayTime,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.tag_and(tag))
				.setSMS(SMS.content(smsContent, smsDelayTime))
				.setNotification(Notification.alert(alert))
				.build();
		return sendPush(pushPayload);
	}
	
	/**
	 * 发送消息
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendMessageWithTag(String msgContent,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.all())
				.setMessage(Message.content(msgContent))
				.build();
		return sendPush(pushPayload);
	}
	
	/**
	 * 发送通知
	 * @param msgContent 消息内容
	 * @param tag 标签 可变参数,可以有多个
	 * @throws JPushMessageException 
	 */
	public boolean sendNotificationWithTag(String alert,String... tag) throws JPushMessageException{
		PushPayload pushPayload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.all())
				.setNotification(Notification.alert(alert))
				.build();
		return sendPush(pushPayload);
	}
	
}
