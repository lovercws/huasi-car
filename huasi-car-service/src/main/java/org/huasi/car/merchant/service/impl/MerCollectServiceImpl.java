package org.huasi.car.merchant.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.huasi.car.merchant.dao.MerCollectDao;
import org.huasi.car.merchant.entity.MerCollect;
import org.huasi.car.merchant.service.MerCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerCollectServiceImpl implements MerCollectService{
	
	@Autowired
	private MerCollectDao merCollectDao;

	@Override
	public MerCollect collectMerchant(String merId, String userId) {
		MerCollect merCollect = new MerCollect();
		merCollect.setMerId(Integer.parseInt(merId));
		merCollect.setUserId(Integer.parseInt(userId));
		merCollect.setCollectCreateTime(new Date());
		return merCollectDao.insert(merCollect);
	}

	@Override
	public MerCollect getMerchantCollect(String merId, String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merId", merId);
		paramMap.put("userId", userId);
		return merCollectDao.getByColumn(paramMap);
	}
	
}
