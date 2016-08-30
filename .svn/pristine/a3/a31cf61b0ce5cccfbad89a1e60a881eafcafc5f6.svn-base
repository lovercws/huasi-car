package org.huasi.car.controller.system;

import java.util.List;

import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.system.entity.SysImageCarousel;
import org.huasi.car.system.service.SysImageCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 首页图片轮播
 * @author ganliang
 * @version 2016年8月18日 上午11:19:23
 */
@Controller
@RequestMapping("/system/carousel")
public class ImageCarouselController {

	@Autowired
	private SysImageCarouselService carouselService;

	/**
	 * 获取首页轮播图片
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllImageCarousel() {
		List<SysImageCarousel> carousels = carouselService.getAllImageCarousel();
		return new ResponseEntity(carousels);
	}

}
