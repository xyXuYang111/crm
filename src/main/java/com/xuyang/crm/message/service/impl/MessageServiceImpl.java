package com.xuyang.crm.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyang.crm.message.dao.MessageDao;
import com.xuyang.crm.message.service.MessageService;
import com.xuyang.crm.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/8 13:21
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public Message messageInfo(Message message) throws Exception {
        return messageDao.messageInfo(message);
    }

    @Override
    public List<Message> messageList(Message message) throws Exception {
        return messageDao.messageList(message);
    }

    @Override
    public List<Message> messageList(Message message, int startIndex, int pageSize) throws Exception {
        PageHelper.startPage(startIndex, pageSize);
        PageInfo<Message> messagePageInfo = new PageInfo<>(messageDao.messageList(message));
        return messagePageInfo.getList();
    }

    @Override
    public void insertMessage(Message message) throws Exception {
        messageDao.insertMessage(message);
    }

    @Override
    public void updateMessage(Message message) throws Exception {
        messageDao.updateMessage(message);
    }

    @Override
    public void deleteMessage(Message message) throws Exception {
        messageDao.deleteMessage(message);
    }
}
