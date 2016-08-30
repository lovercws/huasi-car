package org.huasi.car.controller.info;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.info.entity.ActiveComment;
import org.huasi.car.info.service.ActiveCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 动态评论
 * @author duanzhixin
 * @version 2016年8月22日 上午9:13:20
 */
@Controller
@RequestMapping("/info/comment")
public class ActiveCommentController extends BaseController {

	@Autowired
	private ActiveCommentService activeCommentService;

	/**
	 * 对动态进行评论
	 * @param activeComment
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST})
	public ResponseEntity commentActive(ActiveComment activeComment) {
		activeComment = activeCommentService.addActiveComment(activeComment);
		return new ResponseEntity();
	}
	
}
