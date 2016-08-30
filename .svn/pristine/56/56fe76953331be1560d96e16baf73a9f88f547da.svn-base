package org.huasi.car.controller.info;

import java.util.List;

import org.huasi.car.common.core.page.PageParam;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.huasi.car.info.entity.Active;
import org.huasi.car.info.entity.ActiveComment;
import org.huasi.car.info.service.ActiveCommentService;
import org.huasi.car.info.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 资讯动态 
 * @author duanzhixin
 * @version 2016年8月22日 上午9:12:51
 */
@Controller
@RequestMapping("/info/active")
public class ActiveController {

	@Autowired
	private ActiveService activeService;
	
	@Autowired
	private ActiveCommentService activeCommentService;

	/**
	 * 获取分页动态（排序规则：最近、评论最高）
	 * @param pageNum分页数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.GET })
	public ResponseEntity getAllActive(String pageNum) {
		// 默认为第一页
		int pagenum = PageParam.DEFAULT_PAGE_NUM;
		if (pageNum != null && !"".equals(pageNum) && ValidateUtils.isNumeric(pageNum)) {
			pagenum = Integer.parseInt(pageNum);
		}
		List<Active> actives = activeService.getAllActive(pagenum);
		return new ResponseEntity(actives);
	}
	
	/**
	 * 获取动态下的所有评论
	 * @param activeId 动态id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{activeId}/comment" }, method = RequestMethod.GET)
	public ResponseEntity getAllComment(@PathVariable String activeId) {
		if (!ValidateUtils.isNumeric(activeId)) {
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, activeId);
		}
		List<ActiveComment> comments = activeCommentService.getActiveCommentByActiveId(activeId);
		return new ResponseEntity(comments);
	}
}
