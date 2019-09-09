package com.xuyang.crm.email.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyang.crm.email.dao.EmailDao;
import com.xuyang.crm.email.service.EmailService;
import com.xuyang.crm.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/10 01:30
 * @Description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public Email emailInfo(Email email) throws Exception {
        return emailDao.emailInfo(email);
    }

    @Override
    public List<Email> emailList(Email email) throws Exception {
        return emailDao.emailList(email);
    }

    @Override
    public List<Email> emailList(Email email, int startIndex, int pageSize) throws Exception {
        PageHelper.startPage(startIndex, pageSize);
        PageInfo<Email> emailPageInfo = new PageInfo<>(emailDao.emailList(email));
        return emailPageInfo.getList();
    }

    @Override
    public void insertEmail(Email email) throws Exception {
        emailDao.insertEmail(email);
    }

    @Override
    public void updateEmail(Email email) throws Exception {
        emailDao.updateEmail(email);
    }

    @Override
    public void deleteEmail(Email email) throws Exception {
        emailDao.deleteEmail(email);
    }
}
