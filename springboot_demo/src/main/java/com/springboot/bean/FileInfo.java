package com.springboot.bean;
/**
 * 用于上传下载
 * @author WANGJS-PC
 *
 */
public class FileInfo {
	private String path;

	public FileInfo(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
