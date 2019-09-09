package com.xuyang.crm.email.service;

import com.xuyang.crm.model.Email;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:27
 * @Description:
 */
public interface EmailMongoDB {

    /**
     * 查询单个文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public Email emailInfo(Email email) throws Exception;

    /**
     * 查询多个文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public List<Email> emailList(Email email) throws Exception;

    /**
     * 新增文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public void insertEmail(Email email) throws Exception;

    /**
     * 新增文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public void updateEmail(Email email) throws Exception;

    /**
     * 新增文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public void deleteEmail(Email email) throws Exception;
}
