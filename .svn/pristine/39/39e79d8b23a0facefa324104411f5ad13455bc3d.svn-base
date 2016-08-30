package org.huasi.car.controller.merchant;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.huasi.car.merchant.entity.MerCollect;
import org.huasi.car.merchant.entity.Merchant;
import org.huasi.car.merchant.service.MerCollectService;
import org.huasi.car.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 商铺收藏 
 * @author ganliang
 * @version 2016年8月19日 下午12:07:56
 */
@Controller
@RequestMapping("/mer/collect")
public class MerCollectController extends BaseController{

	@Autowired
	private MerCollectService merCollectService;
	
	@Autowired
	private MerchantService merchantService;
	
	/**
	 * 用户收藏商铺
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = {RequestMethod.POST})
	public ResponseEntity collectMerchant(String merId,String userId){
		MerCollect merCollect = merCollectService.getMerchantCollect(merId, userId);
		
		ResponseEntity responseEntity = null;
		if(merCollect != null){
			// 如果已经收藏过，就告知已经被收藏；
			return new ResponseEntity(HttpCode.MERCHANT_HAS_COLLECTED);
		}else{
			// 如果没有收藏过，则收藏
			merCollect = merCollectService.collectMerchant(merId, userId);
			responseEntity = new ResponseEntity(merCollect);
		}
		
		return responseEntity;
	}
	
	/**
	 * 获取用户收藏的商铺
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}" }, method = {RequestMethod.GET})
	public ResponseEntity getMerchantByUserId(@PathVariable String userId){
		if(!ValidateUtils.isNumeric(userId)){
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, userId);
		}
		List<Merchant> merchants = merchantService.getMerchantByUserId(Integer.parseInt(userId));
		return new ResponseEntity(merchants);
	}
}
