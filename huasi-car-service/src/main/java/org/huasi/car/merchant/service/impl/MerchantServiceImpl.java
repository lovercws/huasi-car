package org.huasi.car.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.common.core.page.PageParam;
import org.huasi.car.merchant.dao.MerchantDao;
import org.huasi.car.merchant.entity.Merchant;
import org.huasi.car.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDao merchantDao;

	@Override
	public List<Merchant> searchMerchantByContent(String searchContent) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchContent", searchContent);
		paramMap.put("merStatus", PublicEnum.NORMAL.value());
		return merchantDao.listBy(paramMap);
	}

	@Override
	public Merchant getMerchantById(int merId) {
		return merchantDao.getById(String.valueOf(merId));
	}

	@Override
	public List<Merchant> getNearbyMerchant(double merLang, double merLat,int pageNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merStatus", PublicEnum.NORMAL.value());
		paramMap.put("userLang", merLang);
		paramMap.put("userLat", merLat);
		
		int beginPageIndex=(pageNum-1)*PageParam.DEFAULT_NUM_PER_PAGE;
		int endPageIndex=pageNum*PageParam.DEFAULT_NUM_PER_PAGE;
		paramMap.put("beginPageIndex", beginPageIndex);
		paramMap.put("endPageIndex", endPageIndex);
		return merchantDao.getNearbyMerchant(paramMap);
	}

	@Override
	public List<Merchant> matchMerchantByNearby(String classifyId, String areaCode, double merLang, double merLat,
			int pagenum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("classifyId", classifyId);
		paramMap.put("areaCode", areaCode);
		paramMap.put("merStatus", PublicEnum.NORMAL.value());
		paramMap.put("userLang", merLang);
		paramMap.put("userLat", merLat);
		
		int beginPageIndex=(pagenum-1)*PageParam.DEFAULT_NUM_PER_PAGE;
		int endPageIndex=pagenum*PageParam.DEFAULT_NUM_PER_PAGE;
		paramMap.put("beginPageIndex", beginPageIndex);
		paramMap.put("endPageIndex", endPageIndex);
		return merchantDao.matchMerchantByNearby(paramMap);
	}

	@Override
	public List<Merchant> matchMerchantByEvaluation(String classifyId, String areaCode, int pagenum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("classifyId", classifyId);
		paramMap.put("areaCode", areaCode);
		paramMap.put("merStatus", PublicEnum.NORMAL.value());
		
		int beginPageIndex=(pagenum-1)*PageParam.DEFAULT_NUM_PER_PAGE;
		int endPageIndex=pagenum*PageParam.DEFAULT_NUM_PER_PAGE;
		paramMap.put("beginPageIndex", beginPageIndex);
		paramMap.put("endPageIndex", endPageIndex);
		return merchantDao.matchMerchantByEvaluation(paramMap);
	}

	@Override
	public List<Merchant> matchMerchantByPopular(String classifyId, String areaCode, int pagenum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("classifyId", classifyId);
		paramMap.put("areaCode", areaCode);
		paramMap.put("merStatus", PublicEnum.NORMAL.value());
		
		int beginPageIndex=(pagenum-1)*PageParam.DEFAULT_NUM_PER_PAGE;
		int endPageIndex=pagenum*PageParam.DEFAULT_NUM_PER_PAGE;
		paramMap.put("beginPageIndex", beginPageIndex);
		paramMap.put("endPageIndex", endPageIndex);
		return merchantDao.matchMerchantByPopular(paramMap);
	}

	@Override
	public List<Merchant> getMerchantByUserId(int userId) {
		return merchantDao.getMerchantByUserId(userId);
	}

}
