package org.huasi.car.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.FileUtil;
import org.huasi.car.common.core.utils.UploadUtil;
import org.huasi.car.fdfs.service.FDFSAttachmentService;
import org.huasi.car.system.entity.SysFeedback;
import org.huasi.car.system.service.SysFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/feedback")
public class FeedbackController extends BaseController {

	@Autowired
	private SysFeedbackService sysFeedbackService;

	@Autowired
	private FDFSAttachmentService fdfsService;

	/**
	 * 获取所有的意见反馈
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllFeedback() {
		List<SysFeedback> feedbacks = sysFeedbackService.getAllFeedback();
		return new ResponseEntity(feedbacks);
	}

	/**
	 * 用户发布意见反馈
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public ResponseEntity addFeedback(HttpServletRequest request,SysFeedback feedback) {
		try {
			// 获取所有上传的文件的绝对路径
			List<String> imgs = UploadUtil.uploadImage(request);
			if (imgs != null && imgs.size() > 0) {
				// 上传文件到fastdfs
				String[] fdfsImgUrls = fdfsService.upload(imgs);
				StringBuilder feedbackImgUrl = new StringBuilder();
				for (String fdfsImgUrl : fdfsImgUrls) {
					feedbackImgUrl.append(fdfsImgUrl + ",");
				}
				// 删除最后一个 , 号
				int lastIndexOf = feedbackImgUrl.lastIndexOf(",");
				if (lastIndexOf != -1) {
					feedbackImgUrl.deleteCharAt(lastIndexOf);
				}
				// 把所有图片地址设置到意见反馈对象中
				feedback.setFeedbackImgUrl(feedbackImgUrl.toString());
				//删除临时文件
				FileUtil.deleteQuietly(imgs);
			}
			feedback = sysFeedbackService.addFeedback(feedback);
		} catch (IOException e) {
			log.error(e);
			return new ResponseEntity(HttpCode.FDFS_FILE_UPLOAD_ERROR, e.getLocalizedMessage());
		}
		return new ResponseEntity(feedback);
	}
}
