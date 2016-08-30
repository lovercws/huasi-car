package org.huasi.car.merchant.service;

import java.util.List;

import org.huasi.car.merchant.entity.Merchant;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerchantService {

	/**
	 * 搜索商铺信息
	 * @param searchContent 搜索内容
	 * @return
	 */
	public List<Merchant> searchMerchantByContent(String searchContent);

	/**
	 * 获取商户详情
	 * @param merId
	 * @return
	 */
	public Merchant getMerchantById(int merId);

	/**
	 * 获取附近商家
	 * @param lang 当前用户的经度
	 * @param lat 当前用户的纬度
	 * @param pageNum 当前页数
	 * @return
	 */
	public List<Merchant> getNearbyMerchant(double lang, double lat, int pageNum);
	
	/**
	 * 根据userId获取用户收藏的商铺
	 * @param userId
	 * @return
	 */
	public List<Merchant> getMerchantByUserId(int userId);

	/**
	 * 智能排序最近用户
	 * @param classifyId 分类id	
	 * @param areaCode 区域id
	 * @param merLang 经度
	 * @param merLat 纬度
	 * @param pagenum 分页数据
	 * @return
	 */
	public List<Merchant> matchMerchantByNearby(String classifyId, String areaCode, double merLang, double merLat,
			int pagenum);

	/**
	 * 智能排序评价最好 选择商铺
	 * @param classifyId 分类id
	 * @param areaCode 区域id
	 * @param pagenum 分页数量
	 * @return
	 */
	public List<Merchant> matchMerchantByEvaluation(String classifyId, String areaCode, int pagenum);

	/**
	 * 智能排序人气最高 选择商铺
	 * @param classifyId 分类id
	 * @param areaCode 区域id
	 * @param pagenum 分页数量
	 * @return
	 */
	public List<Merchant> matchMerchantByPopular(String classifyId, String areaCode, int pagenum);

}
