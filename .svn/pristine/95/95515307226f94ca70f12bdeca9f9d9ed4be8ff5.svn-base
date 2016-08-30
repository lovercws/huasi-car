package org.huasi.car.fdfs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.huasi.car.fdfs.bean.FDFSFile;
import org.huasi.car.fdfs.config.FDFSConfig;

/**
 * 分布式文件系统fastdfs
 * @author ganliang
 */
public class FDFSAttachmentServiceImpl implements FDFSAttachmentService {

	private static final Logger log = Logger.getLogger(FDFSAttachmentServiceImpl.class);

	private static TrackerClient trackerClient;
	private static TrackerServer trackerServer;

	private static StorageServer storageServer;
	private static StorageClient storageClient;

	@Override
	public String[] upload(String[] filePaths) throws IOException {
		File[] files=new File[filePaths.length];
		for (int i = 0; i < filePaths.length; i++) {
			files[i]=new File(filePaths[i]);
		}
		return upload(files);
	}
	
	@Override
	public String[] upload(List<String> filePaths) throws IOException {
		File[] files=new File[filePaths.size()];
		for (int i = 0; i < filePaths.size(); i++) {
			files[i]=new File(filePaths.get(i));
		}
		return upload(files);
	}
	
	@Override
	public String[] upload(File[] files) throws IOException {
		if (files == null || files.length < 1) {
			throw new IllegalArgumentException();
		}
		String[] urls = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			urls[i] = this.upload(files[i]);
		}
		return urls;
	}
	
	@Override
	public String upload(String fileName) throws IOException {
		return upload(new File(fileName));
	}

	@Override
	public String upload(File file) throws IOException {
		byte[] content = FileUtils.readFileToByteArray(file);
		String extension = FilenameUtils.getExtension(file.getName());
		FDFSFile fdfsFile = new FDFSFile(file.getName(), content, extension);
		return this.upload(fdfsFile);
	}

	@Override
	public String upload(FDFSFile fdfsFile) throws IOException {
		// 设置文件的宽、高、作者
		NameValuePair[] meta_list = new NameValuePair[3];
		meta_list[0] = new NameValuePair("width", fdfsFile.getWidth());
		meta_list[1] = new NameValuePair("heigth", fdfsFile.getHeight());
		meta_list[2] = new NameValuePair("author", fdfsFile.getAuthor());

		try {
			String[] upload_file = storageClient.upload_file(fdfsFile.getContent(), fdfsFile.getExt(), meta_list);
			return upload_file[0] + FDFSConfig.SEPARATOR + upload_file[1];
		} catch (IOException e) {
			throw new IOException(e);
		} catch (MyException e) {
			throw new IOException(e);
		}
	}

	@Override
	public byte[] download(String groupName, String remoteFileName) throws IOException {
		try {
			return storageClient.download_file(groupName, remoteFileName);
		} catch (MyException e) {
			throw new IOException(e);
		}
	}

	@Override
	public boolean delete(String groupName, String remoteFileName) throws IOException {
		try {
			int delete_file = storageClient.delete_file(groupName, remoteFileName);
			return delete_file == 0;
		} catch (IOException | MyException e) {
			throw new IOException(e);
		}
	}

	@Override
	public FileInfo getFileInfo(String groupName, String remoteFileName) throws IOException {
		try {
			return storageClient.get_file_info(groupName, remoteFileName);
		} catch (IOException | MyException e) {
			throw new IOException(e);
		}
	}

	/**
	 * 初始化fastdfs连接
	 */
	public void init() {
		try {
			if(configPath==null){
				throw new IllegalArgumentException("fastdfs配置文件不存在");
			}
			if(!configPath.startsWith("/")){
				configPath="/"+configPath;
			}
			//String path = FDFSAttachmentServiceImpl.class.getResource(configPath).getPath();
			/*if(path==null){
				throw new IllegalArgumentException("fastdfs配置文件 not found");
			}*/
			/*String classPath = new File(FDFSAttachmentServiceImplTest.class.getResource("/").getFile())
					.getCanonicalPath();
			String fdfsClientConfigFilePath = classPath + File.separator + FDFSConfig.CLIENT_CONFIG_FILE;*/
			//path = path.replace("!", "");
			log.info("读取fdfs配置文件:" + configPath);

			ClientGlobal.init(configPath);

			trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();

			storageClient = new StorageClient(trackerServer, storageServer);
			log.info("fastdfs分布式文件系统初始化完毕");
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (MyException e) {
			log.error(e);
		}
	}

	@Override
	public void destory() {
		try {
			if (storageServer != null) {
				storageServer.close();
			}
			if (trackerServer != null) {
				trackerServer.close();
			}
		} catch (IOException e) {
			log.error(e);
		}
	}

	private String configPath;//fastdfs 客户端配置文件
	public String getConfigPath() {
		return configPath;
	}
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
}
