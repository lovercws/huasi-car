package org.huasi.car.user.service;

import org.huasi.car.user.entity.AppUser;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS, readOnly = true)
public interface AppUserService {

	/**
	 * 根据手机号码获取用户信息 -- 可以用来判断手机号是否已经注册
	 * 
	 * @param userPhone
	 *            手机号码
	 * @return
	 */
	public AppUser getUserByIphone(String userPhone);
	
	/**
	 * 根据userId，获取用户信息
	 * @param userId
	 * @return
	 */
	public AppUser getUserByUserId(String userId);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public AppUser addUser(AppUser user);

	/**
	 * 修改用户昵称
	 * @param userId
	 * @param userNickName
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updateUserNickName(String userId, String userNickname);

	/**
	 * 修改用户的手机号
	 * @param userId
	 * @param userPhone
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updateUserPhone(String userId, String userPhone);

	/**
	 * 修改用户的头像地址
	 * @param userId
	 * @param avatorUrl
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updateUserAvatorUrl(String userId, String avatorUrl);

	/**
	 * 更新用户城市信息
	 * @param userId 用户id
	 * @param userCity 城市内码
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateUserCityInfo(String userId, String userCity);

}
