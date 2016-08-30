package org.huasi.car.fdfs.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.csource.fastdfs.FileInfo;
import org.huasi.car.fdfs.FileAttachmentService;
import org.huasi.car.fdfs.bean.FDFSFile;

public interface FDFSAttachmentService extends FileAttachmentService {
	
	/**
	 * 保存多个文件
	 * @param files 文件数组
	 * @return
	 * @throws IOException
	 */
	public String[] upload(File[] files) throws IOException;
	
	/**
	 * 保存多个文件
	 * @param files 文件数组
	 * @return
	 * @throws IOException
	 */
	public String[] upload(String[] files) throws IOException;
	
	/**
	 * 保存多个文件
	 * @param files 文件数组
	 * @return
	 * @throws IOException
	 */
	public String[] upload(List<String> files) throws IOException;
	
	/**
	 * 文件上传
	 * @param file文件
	 * @return
	 * @throws IOException 
	 */
	public String upload(File file) throws IOException;
	
	/**
	 * fdfs文件上传
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public String upload(String filePath) throws IOException;
	
	
	/**
	 * fdfs文件上传
	 * @param fdfsFile
	 * @return
	 * @throws IOException
	 */
	public String upload(FDFSFile fdfsFile) throws IOException;
	
	/**
	 * 下载文件
	 * @param groupName 组名
	 * @param remoteFileName 文件名
	 * @throws IOException 
	 */
	public byte[] download(String groupName, String remoteFileName) throws IOException;

	/**
	 * 删除文件
	 * @param groupName 组名
	 * @param remoteFileName 文件名
	 * @return
	 * @throws IOException 
	 */
	public boolean delete(String groupName, String remoteFileName) throws IOException;
	
	/**
	 * 获取文件的信息
	 * @param groupName
	 * @param remoteFileName
	 * @return
	 * @throws IOException
	 */
	public FileInfo getFileInfo(String groupName, String remoteFileName) throws IOException;

	/**
	 * 初始化 fastdfs
	 */
	public void init();
	
	/**
	 * 释放fastdfs资源 
	 */
	public void destory();
}
