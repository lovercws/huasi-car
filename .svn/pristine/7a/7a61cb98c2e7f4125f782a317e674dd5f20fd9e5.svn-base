package org.huasi.car.controller.comment;

import java.util.List;

import org.huasi.car.comment.entity.MerOrdComment;
import org.huasi.car.comment.service.MerOrdCommentService;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 商铺订单评论
 * @author ganliang
 * @version 2016年8月15日 下午1:51:56
 */
@Controller
@RequestMapping("/mer/comment")
public class MerOrdCommentController extends BaseController{

	@Autowired
	private MerOrdCommentService merOrdCommentService;

	/**
	 * 获取商铺下的订单评论
	 * @param merId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{merId}" }, method = { RequestMethod.GET})
	public ResponseEntity getMerOrdCommentByMerId(@PathVariable int merId) {
		List<MerOrdComment> comments = merOrdCommentService.getMerOrdCommentByMerId(merId);
		return new ResponseEntity(comments);
	}
	
	/**
	 * 添加订单评论
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = {RequestMethod.POST })
	public ResponseEntity addMerOrdComment(MerOrdComment merOrdComment){
		merOrdComment = merOrdCommentService.addMerOrdComment(merOrdComment);
		return new ResponseEntity(merOrdComment);
	}
	
	/**
	 * 对服务下的某个评论进行回复
	 * @param commId 评论id
	 * @param commMerReply 回复
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/replay/{commId}" }, method = {RequestMethod.POST })
	public ResponseEntity addOrdCommReplayByCommId(@PathVariable String commId,String commMerReply){
		if(!ValidateUtils.isNumeric(commId)){
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, commId);
		}
		boolean replayComm = merOrdCommentService.addOrdCommReplayByCommId(Integer.parseInt(commId), commMerReply);
		return new ResponseEntity(replayComm);
	}
}
