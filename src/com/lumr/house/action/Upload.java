package com.lumr.house.action;

import com.lumr.house.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * Created by fsweb on 17-4-20.
 */
public class Upload extends ActionSupport {
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    @Override
    public String execute() throws Exception {
        String savePath = ServletActionContext.getServletContext().getRealPath("/upload");
        System.out.println(upload.getPath());
        System.out.println(savePath);
        System.out.println(uploadFileName);
        int i = uploadFileName.lastIndexOf(".");
        String fileType = uploadFileName.substring(i);//名字后缀
        Users user = (Users)ActionContext.getContext().getSession().get("user");
        if (upload!=null){
            File file = new File(savePath,user.getName()+fileType);
            FileUtils.copyFile(upload,file);
            addActionMessage("上传成功");
        }
        return SUCCESS;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
}
