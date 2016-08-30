package org.huasi.car.controller.merchant;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.huasi.car.merchant.entity.MerClassify;
import org.huasi.car.merchant.enums.MerClassifyLevelEnum;
import org.huasi.car.merchant.service.MerClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 显示商铺分类
 * @author ganliang
 * @version 2016年8月10日 下午3:17:21
 */
@Controller
@RequestMapping("/mer/classify")
public class MerchantClassifyController extends BaseController{

	@Autowired
	private MerClassifyService classifyService;
	
	/**
	 * 获取所有的商家分类
	 * @param level 分类等级 0（默认）:显示所有的分类 1:只显示大分类；2:显示二级分类
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllClassify(String level) {
		int lev=MerClassifyLevelEnum.ALL.value();
		if(level!=null&&!"".equals(level)&&ValidateUtils.isNumeric(level)){
			lev=Integer.parseInt(level);
		}
		//获取所有的分类
		List<MerClassify> classifys=classifyService.getAllClassify(lev);
		return new ResponseEntity(classifys);
	}
	
	/**
	 * 获取商家分类下的所有子分类
	 * @param prtClassifyId 父分类id
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value={"/{prtClassifyId}/child"},method = RequestMethod.GET)
	public ResponseEntity getClassifyByPrtClassifyId(@PathVariable String prtClassifyId) {
		//获取商家分类下的所有子分类
		List<MerClassify> classifys=classifyService.getClassifyByPrtClassifyId(prtClassifyId);
		return new ResponseEntity(classifys);
	}
	
	/**
	 * 根据分类id 获取分类信息
	 * @param classifyId 分类id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/{classifyId}"},method = RequestMethod.GET)
	public ResponseEntity getClassifyById(@PathVariable String classifyId){
		MerClassify classify=classifyService.getClassifyByClassifyId(classifyId);
		return new ResponseEntity(classify);
	}
}
