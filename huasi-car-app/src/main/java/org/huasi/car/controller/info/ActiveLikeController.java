package org.huasi.car.controller.info;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.info.entity.ActiveLike;
import org.huasi.car.info.service.ActiveLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 动态点赞
 * @author duanzhixin
 * @version 2016年8月22日 上午9:13:39
 */
@Controller
@RequestMapping("/info/like")
public class ActiveLikeController extends BaseController {

	@Autowired
	private ActiveLikeService activeLikeService;

	/**
	 * 对动态进行点赞或者取消点赞
	 * @param activeId
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST})
	public ResponseEntity addInfoLike(String activeId, String userId) {
		ActiveLike activeLike = activeLikeService.getActiveLike(activeId, userId);
		
		ResponseEntity responseEntity = null;
		if(activeLike != null){
			// 如果已经点赞，那么就取消点赞
			boolean isUpdate = activeLikeService.updateActiveLike(activeId, userId);
			responseEntity = new ResponseEntity(isUpdate);
		}else{
			// 如果没有点赞，那么就点击点赞
			activeLike = activeLikeService.addActiveLike(activeId, userId);
			responseEntity = new ResponseEntity(activeLike);
		}
		return responseEntity;
	}
}
