package com.xuyang.crm.file.factory;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 21:05
 * @Description:
 */
public interface FileOperate {

    /**
     * 文件上传
     * @param
     */
    public void fileUpload() throws Exception;

    /**
     * 文件下载
     * @param
     */
    public void fileDown() throws Exception;
}
