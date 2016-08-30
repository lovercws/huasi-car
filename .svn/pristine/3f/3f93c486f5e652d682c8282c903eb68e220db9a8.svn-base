package org.huasi.car.common.fdfs;

import java.io.File;
import java.io.IOException;

import org.csource.fastdfs.FileInfo;
import org.huasi.car.fdfs.service.FDFSAttachmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FDFSAttachmentServiceImplTest {

	ClassPathXmlApplicationContext context = null;
	FDFSAttachmentService fdfsAttachmentService = null;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("classpath:spring/spring-context-fdfs.xml");
		context.start();
		fdfsAttachmentService = context.getBean(FDFSAttachmentService.class);
	}

	@Test
	public void upload() {
		try {
			String upload = fdfsAttachmentService.upload(new File("c:/unintall.log"));
			System.out.println(upload);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			context.destroy();
		}
	}

	@Test
	public void download() {
		try {
			byte[] download = fdfsAttachmentService.download("group1", "M00/00/00/rBEAAVe6lm2AYxZ1AAAHFbKTmM4607.log");
			System.out.println(new String(download));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			context.destroy();
		}
	}

	public void delete() {
		try {
			boolean delete = fdfsAttachmentService.delete("group1", "M00/00/00/wKgQgVefJ3KAB_UFAAAHFbKTmM4773.log");
			System.out.println(delete);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			context.destroy();
		}
	}

	public void getFileInfo() {
		try {
			FileInfo fileInfo = fdfsAttachmentService.getFileInfo("group1",
					"M00/00/00/wKgQgVefJ3KAB_UFAAAHFbKTmM4773.log");
			System.out.println(fileInfo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			context.destroy();
		}
	}
}
