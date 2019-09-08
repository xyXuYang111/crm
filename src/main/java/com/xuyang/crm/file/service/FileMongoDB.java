package com.xuyang.crm.file.service;

import com.xuyang.crm.model.Files;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 22:59
 * @Description:
 */
public interface FileMongoDB {

    /**
     * 查询单个文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public Files fileInfo(Files files) throws Exception;

    /**
     * 查询多个文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public List<Files> fileList(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void insertFile(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void updateFile(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void deleteFile(Files files) throws Exception;
}
