package org.huasi.car.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.merchant.entity.MerClassify;
import org.huasi.car.merchant.entity.MerService;
import org.huasi.car.merchant.enums.MerClassifyLevelEnum;
import org.huasi.car.merchant.service.MerClassifyService;
import org.huasi.car.merchant.service.MerchantSrvService;
import org.huasi.car.system.entity.SysImageCarousel;
import org.huasi.car.system.service.SysImageCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 首页业务处理类
 * @author ganliang
 * @version 2016年8月18日 上午11:54:18
 */
@Controller
@RequestMapping("/system/home")
public class HomePageController {

	@Autowired
	private SysImageCarouselService carouselService;

	@Autowired
	private MerClassifyService classifyService;

	@Autowired
	private MerchantSrvService srvService;

	/**
	 * 首页获取 1图片轮播；2商铺分类；3精品推荐；4附近商家
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity homePage() {
		// 获取图片轮播信息
		List<SysImageCarousel> imageCarousels = carouselService.getAllImageCarousel();

		// 获取一级分类信息
		List<MerClassify> classifys = classifyService.getAllClassify(MerClassifyLevelEnum.FIRST_CLASSIFY.value());

		// 获取精品推荐服务
		List<MerService> services = srvService.getRecommentMerchantService();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("imageCarousels", imageCarousels);
		data.put("classifys", classifys);
		data.put("services", services);
		return new ResponseEntity(data);
	}
}
