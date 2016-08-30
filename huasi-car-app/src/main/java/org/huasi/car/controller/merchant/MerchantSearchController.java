package org.huasi.car.controller.merchant;

import java.util.List;

import org.huasi.car.common.core.enums.OrdRuleEnum;
import org.huasi.car.common.core.page.PageParam;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.huasi.car.merchant.entity.Merchant;
import org.huasi.car.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 商铺搜索控制器 
 * @author ganliang
 * @version 2016年8月11日 下午2:20:22
 */
@Controller
@RequestMapping("/mer/merchant")
public class MerchantSearchController {

	@Autowired
	private MerchantService merchantService;
	
	/**
	 * 搜索商铺信息 1 分类名称；2商铺名称；3服务名称
	 * 根据关键词搜索商铺
	 * @param searchContent 搜索内容
	 * @param userId 搜索用户id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/search"},method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity search(String userId,String searchContent) {
		List<Merchant> merchants=merchantService.searchMerchantByContent(searchContent);
		return new ResponseEntity(merchants);
	}

	/**
	 * 根据 商铺分类、商铺区域、智能排序 匹配商铺信息
	 * @param merchant 商铺实体信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/match"},method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity match(String classifyId,String areaCode,String ordruleId,String merLang,String merLat, String pageNum){
		List<Merchant> merchants=null;
		//默认智能排序
		if(ordruleId==null||"".equals(ordruleId)||!ValidateUtils.isNumeric(ordruleId)){
			ordruleId=OrdRuleEnum.DEFAULT_ORDRULE.value();
		}
		//默认为第一页
		int pagenum=PageParam.DEFAULT_PAGE_NUM;
		if(pageNum!=null&&!"".equals(pageNum)&&ValidateUtils.isNumeric(pageNum)){
			pagenum=Integer.parseInt(pageNum);
		}
		//智能排序距离最近
		if(OrdRuleEnum.INTELLIGENT_ORDERING.value().equals(ordruleId)){
			//经度 纬度必须参数
			if(!ValidateUtils.isDouble(merLang)||!ValidateUtils.isDouble(merLat)){
				return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR);
			}
			merchants=merchantService.matchMerchantByNearby(classifyId,areaCode,Double.parseDouble(merLang),Double.parseDouble(merLat),pagenum);
		}
		//评价最好
		else if(OrdRuleEnum.EVALUATION_BEST.value().equals(ordruleId)){
			merchants=merchantService.matchMerchantByEvaluation(classifyId,areaCode,pagenum);
		}
		//人气最高
		else if(OrdRuleEnum.POPULAR_MOST.value().equals(ordruleId)){
			merchants=merchantService.matchMerchantByPopular(classifyId,areaCode,pagenum);
		}
		//返回错误
		else{
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR,ordruleId);
		}
		return new ResponseEntity(merchants);
	}
	
	/**
	 * 获取附近商家
	 * @param merLang 当前用户的经度
	 * @param merLat 当前用户的纬度
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/nearby"},method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity getNearbyMerchant(String merLang, String merLat, String pageNum){
		if(!ValidateUtils.isDouble(merLang)||!ValidateUtils.isDouble(merLat)){
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR);
		}
		//默认为第一页
		int pagenum=PageParam.DEFAULT_PAGE_NUM;
		if(pageNum!=null&&!"".equals(pageNum)&&ValidateUtils.isNumeric(pageNum)){
			pagenum=Integer.parseInt(pageNum);
		}
		List<Merchant> merchants=merchantService.getNearbyMerchant(Double.parseDouble(merLang),Double.parseDouble(merLat),pagenum);
		return new ResponseEntity(merchants);
	}
}
