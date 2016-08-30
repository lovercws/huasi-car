package org.huasi.car.controller.merchant;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.merchant.entity.MerOrdRule;
import org.huasi.car.merchant.service.MerOrdRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 商户智能排序
 * @author ganliang
 * @version 2016年8月11日 上午8:48:26
 */
@Controller
@RequestMapping("/mer/orderRule")
public class MerchantOrderRuleController extends BaseController {

	@Autowired
	private MerOrdRuleService merOreRuleService;

	/**
	 * 获取所有的智能排序规则
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllMerOrdRule() {
		List<MerOrdRule> list = merOreRuleService.getAllMerOrdRule();
		return new ResponseEntity(list);
	}

}
