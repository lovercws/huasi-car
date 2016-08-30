package org.huasi.car.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.exception.BizException;
import org.huasi.car.system.dao.SysCityDao;
import org.huasi.car.system.entity.SysCity;
import org.huasi.car.user.dao.AppUserDao;
import org.huasi.car.user.entity.AppUser;
import org.huasi.car.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDao userDao;
	
	@Autowired
	private SysCityDao cityDao;

	@Override
	public AppUser getUserByIphone(String userPhone) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userPhone", userPhone);
		return userDao.getByColumn(paramMap);
	}
	
	@Override
	public AppUser getUserByUserId(String userId) {
		return userDao.getById(userId);
	}

	@Override
	public AppUser addUser(AppUser user) {
		return userDao.insert(user);
	}

	@Override
	public boolean updateUserNickName(String userId, String userNickname) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("userNickname", userNickname);
		return userDao.update(paramMap) > 0;
	}

	@Override
	public boolean updateUserPhone(String userId, String userPhone) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("userPhone", userPhone);
		return userDao.update(paramMap) > 0;
	}

	@Override
	public boolean updateUserAvatorUrl(String userId, String avatorUrl) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("avatorUrl", avatorUrl);
		return userDao.update(paramMap) > 0;
	}

	@Override
	public String updateUserCityInfo(String userId, String userCity) {
		//系统会缓存整个城市信息 因此这里查询 速度更加快速
		List<SysCity> citys = cityDao.listByColumn(new HashMap<String,Object>());
		String cCode=null;
		for (SysCity sysCity : citys) {
			if(sysCity.getcName().contains(userCity)){
				cCode=sysCity.getcCode();//获取城市内码
				break;
			}
		}
		if(cCode==null){
			throw new BizException("城市找不到"+userCity);
		}
		
		//更新城市信息
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("userCity", cCode);
		int update = userDao.update(paramMap);
		if(update<1){
			throw new BizException("更新失败");
		}
		return cCode;
	}

}
