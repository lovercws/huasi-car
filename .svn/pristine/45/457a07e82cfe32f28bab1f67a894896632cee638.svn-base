package org.hausi.car.jpush.enums;

/**
 * JPush官方文档声明的请求状态
 * 
 * @author ganliang
 *
 */
public enum JPushStatus {

	/**
	 * 成功
	 */
	OK(200),

	/**
	 * 错误的请求 该请求是无效的。相应的描述信息会说明原因
	 */
	BAD_REQUEST(400),

	/**
	 * 未授权
	 */
	NOT_AUTHENTICATION(401),

	/**
	 * 拒绝连接 理解该请求，但不被接受。相应的描述信息会说明原因
	 */
	CONNECTION_REFUSE(403),

	/**
	 * 无法找到 资源不存在，请求的用户的不存在，请求的格式不被支持。
	 */
	NOTFOUND(404),

	/**
	 * 请求方法不合适 该接口不支持该方法的请求。
	 */
	METHOD_UNSUPPORT(405),

	/**
	 * 已下线 请求的资源已下线。请参考相关公告。
	 */
	RESOURCE_OFFLINE(410),

	/**
	 * 过多的请求 请求超出了频率限制。相应的描述信息会解释具体的原因。
	 */
	TOO_MANY_CONNECTION(429),

	/**
	 * 内部服务错误 服务器内部出错了。请联系我们尽快解决问题。
	 */
	SERVERERROR(500),

	/**
	 * 无效代理 业务服务器下线了或者正在升级。请稍后重试。
	 */
	VOID_AGENCY(502),

	/**
	 * 服务暂时失效 服务器无法响应请求。请稍后重试。
	 */
	TEMPORARY_SERVICE_FAILURE(503),

	/**
	 * 代理超时 服务器在运行，但是无法响应请求。请稍后重试。
	 */
	AGENT_TIMEOUT(504);

	private final int value;

	private JPushStatus(final int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
}
