package org.huasi.car.controller.comment;

import org.huasi.car.comment.entity.MerOrdCommLike;
import org.huasi.car.comment.service.MerOrdCommLikeService;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *	对商铺服务的评论进行点赞
 */
@Controller
@RequestMapping("/mer/commlike")
public class MerOrdCommLikeController extends BaseController {
	
	@Autowired
	private MerOrdCommLikeService merOrdCommLikeService;
	
	/**
	 * 对商铺服务订单的评论进行点赞或者取消点赞
	 * @param merOrdCommLike
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = {RequestMethod.POST })
	public ResponseEntity addMerOrdCommLike(String commId,String userId){
		MerOrdCommLike merOrdCommLike = merOrdCommLikeService.getMerOrdCommLike(commId, userId);
		
		ResponseEntity responseEntity = null;
		if(merOrdCommLike != null){
			// 如果已经点赞，点击时采用取消点赞
			int commlikeId = merOrdCommLike.getCommlikeId();
			if(!ValidateUtils.isNumeric(String.valueOf(commlikeId))){
				return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, commlikeId);
			}else{
				boolean isDelete = merOrdCommLikeService.deleteMerOrdCommLike(String.valueOf(commlikeId));
				responseEntity = new ResponseEntity(isDelete);
			}
		}else{
			// 如果不存在，说明没有点赞过
			merOrdCommLike = merOrdCommLikeService.addMerOrdCommLike(commId, userId);
			responseEntity = new ResponseEntity(merOrdCommLike);
		}
		return responseEntity;
	}

}
