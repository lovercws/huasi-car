package org.huasi.car.interceptor;

import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.utils.SecurityUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @desc 令牌拦截器
 * @author ganliang
 * @version 2016年8月8日 下午3:36:06
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = Logger.getLogger(TokenInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//令牌禁用 直接跳过拦截器
		if(!usable){
			return true;
		}
		BaseController controller = new BaseController();
		
		String clientToken = request.getParameter(field);
		String responseBody=null;
        if(clientToken==null){
        	responseBody = controller.setResponseBody(HttpCode.TOKEN_NOT_SETTING, null);
        	log.debug("令牌未设置 "+responseBody);
        }else{
        	//获取服务端令牌
    		ServerToken serverToken = new ServerToken(request);
    		String token = serverToken.getToken(algorithm,privateKey,field);
    		// 比对客户端和服务端令牌
    		if (clientToken.equals(token)) {
    			log.debug("令牌验证成功 ");
    			return true;
    		}
    		// 向客户端返回数据
    		responseBody = controller.setResponseBody(HttpCode.TOKEN_SETTING_ERROR, null);
    		log.debug("令牌验证失败 "+responseBody);
        }
		response.getWriter().print(responseBody);
		
		return false;
	}
   
	private String field;
	private String privateKey;
	private String algorithm;
	private boolean usable;
	public void setField(String field) {
		this.field = field;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public void setUsable(boolean usable) {
		this.usable = usable;
	}

	/**
	 * @desc 令牌验证
	 * @author ganliang
	 * @version 2016年8月8日 下午4:13:15
	 */
	private static class ServerToken {
		private HttpServletRequest request;
		public ServerToken(HttpServletRequest request) {
			super();
			this.request = request;
		}
		/**
		 * 获取令牌
		 * @param algorithm 算法
		 * @param privateKey 私钥
		 * @param field 令牌字段
		 * @return
		 */
		public String getToken(String algorithm,String privateKey,String field) {
			// 获取请求的所有参数
			int parameterHashCode=0;
			int parameterCount=0;
			for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
				//过滤令牌字段
				if(entry.getKey().equals(field)){
					continue;
				}
				String[] values = entry.getValue();
				if(values!=null&&values.length>0){
					parameterHashCode+=values[0].hashCode();
				}
				parameterCount++;
			}
			if(algorithm==null||"".equals(algorithm)){
				algorithm="RSA";
			}
			String serverToken=null;
			String tokenStr=parameterHashCode/parameterCount+privateKey;
			switch (algorithm.toUpperCase()) {
			case "MD5"://MD5 加密 单向加密
				serverToken=SecurityUtil.encryptMd5(tokenStr);
				break;
			case "BASE64": //base64编码
				serverToken=SecurityUtil.encryptBASE64(tokenStr.getBytes());
				break;
			case "DES": //des 加密
				serverToken=SecurityUtil.encryptDes(tokenStr);
				break;
			case "SHA": //SHA加密
				serverToken=SecurityUtil.encryptSHA(tokenStr);
				break;
			case "HMAC": //HMAC加密
				serverToken=SecurityUtil.encryptHMAC(tokenStr);
				break;
			case "RSA": //RSA签名
				serverToken = SecurityUtil.signRSA(tokenStr, privateKey);
				break;
			default:
				//默认使用MD5加密
				serverToken=SecurityUtil.encryptMd5(tokenStr);
				break;
			}
			return serverToken;
		}
	}
}