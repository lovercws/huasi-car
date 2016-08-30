package org.huasi.car.controller.info;

import java.util.List;

import org.huasi.car.common.core.page.PageParam;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.huasi.car.info.entity.Active;
import org.huasi.car.info.entity.ActiveClassify;
import org.huasi.car.info.service.ActiveClassifyService;
import org.huasi.car.info.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 资讯分类控制器
 * @author duanzhixin
 * @version 2016年8月19日 上午9:30:34
 */
@Controller
@RequestMapping("/info/classify")
public class ActiveClassifyController {

	@Autowired
	private ActiveClassifyService activeClassifyService;
	
	@Autowired
	private ActiveService activeService;

	/**
	 * 获取所有的资讯分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllInfoClassify() {
		List<ActiveClassify> classifys = activeClassifyService.getAllActiveClassify();
		return new ResponseEntity(classifys);
	}
	
	/**
	 * 获取动态的类别下的所有动态
	 * @param classifyId 动态分类id
	 * @param pageNum 分页数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/{classifyId}/active"},method = { RequestMethod.GET })
	public ResponseEntity getActiveByClassifyId(@PathVariable String classifyId, String pageNum) {
		// 默认为第一页
		int pagenum = PageParam.DEFAULT_PAGE_NUM;
		if (pageNum != null && !"".equals(pageNum) && ValidateUtils.isNumeric(pageNum)) {
			pagenum = Integer.parseInt(pageNum);
		}
		List<Active> actives = activeService.getActiveByClassifyId(classifyId, pagenum);
		return new ResponseEntity(actives);
	}

}
