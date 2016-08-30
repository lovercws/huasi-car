package org.huasi.car.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.merchant.dao.MerchantSrvDao;
import org.huasi.car.merchant.entity.MerService;
import org.huasi.car.merchant.service.MerchantSrvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantSrvServiceImpl implements MerchantSrvService {

	@Autowired
	private MerchantSrvDao merchantSrvDao;

	@Override
	public List<MerService> getMerchantSrvByMerId(int merId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merId", merId);
		return merchantSrvDao.listByColumn(paramMap);
	}

	@Override
	public List<MerService> getRecommentMerchantService() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("srvStatus", PublicEnum.NORMAL.value());
		return merchantSrvDao.getRecommentMerchantService(paramMap);
	}

}
