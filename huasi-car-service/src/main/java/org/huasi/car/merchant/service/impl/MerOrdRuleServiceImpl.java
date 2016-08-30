package org.huasi.car.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.merchant.dao.MerOrdRuleDao;
import org.huasi.car.merchant.entity.MerOrdRule;
import org.huasi.car.merchant.service.MerOrdRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerOrdRuleServiceImpl implements MerOrdRuleService {

	@Autowired
	private MerOrdRuleDao merOrdRuleDao;

	@Override
	public List<MerOrdRule> getAllMerOrdRule() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ordruleStatus", PublicEnum.NORMAL.value());
		return merOrdRuleDao.listByColumn(paramMap);
	}

}
