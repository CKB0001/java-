package com.edu.action.card;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.edu.db_util.DbToExcel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

@Namespace("/card")
@Scoped(Scope.REQUEST)
@ParentPackage("struts-default")  //表示继承的父包
public class UploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    /**
     * 上传单个文件方式，必须设置下面的3个属性，File属性名与提交页面的属性名一致，
     * 其他两项必须用该属性名开始并且名称
     */
	private File file;//上传文件对象
	private String fileContentType;//上传文件内容类型
	private String fileFileName;//上传文件名

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	@Action( //表示请求的Action及处理方法
			value="upload", 		   
			results={@Result(name="success",location="/find",type="redirectAction")}
		)	
	public String upload() throws Exception {	
		//获取服务器容器对象
		ServletContext servletContext = ServletActionContext.getServletContext();
		//获取实际存放上传文件的文件夹（项目根目录下的文件夹upload），若不存在，自动创建该文件夹
		String dir = servletContext.getRealPath("/upload");
		System.out.println(dir);		
		File saveFile=new File(dir,fileFileName);
		FileUtils.copyFile(file,saveFile);
		DbToExcel.excelToDb(dir+"/"+fileFileName, "Card", "(name,sex,department,mobile,phone,email,address)", 7);
		return "success";
	}
}
