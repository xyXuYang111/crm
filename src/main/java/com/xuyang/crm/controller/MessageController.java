package com.xuyang.crm.controller;

import com.xuyang.crm.log.service.LoggerMongoDB;
import com.xuyang.crm.log.service.LoggerService;
import com.xuyang.crm.message.service.MessageMongoDB;
import com.xuyang.crm.message.service.MessageService;
import com.xuyang.crm.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/8 13:32
 * @Description:
 */
@Slf4j
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageMongoDB messageMongoDB;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private LoggerMongoDB loggerMongoDB;

    @RequestMapping(value = "getMessageSqlList")
    public String getMessageSqlList(Model model, Message message) throws Exception{
        log.debug("通过sql的方式查询文本信息");
        List<Message> messageList = messageService.messageList(message);
        model.addAttribute("messageList", messageList);
        return "message/show";
    }

    @RequestMapping(value = "getMessageMongoDBList")
    public String getMessageMongoDBList(Model model, Message message) throws Exception{
        log.debug("通过sql的方式查询文本信息");
        List<Message> messageList = messageMongoDB.messageList(message);
        model.addAttribute("messageList", messageList);
        return "message/show";
    }

    @RequestMapping(value = "insertMessage", method = RequestMethod.POST)
    public String insertMessage(Model model, Message message) throws Exception{
        log.debug("新增点滴");
        messageMongoDB.insertMessage(message);
        messageService.insertMessage(message);
        return "message/message";
    }

    @RequestMapping(value = "getMessageSqlInfo")
    public String getMessageSqlInfo(Model model, Message message) throws Exception{
        log.debug("通过sql的方式查询文本信息");
        Message messageInfo = messageService.messageInfo(message);
        model.addAttribute("messageInfo", messageInfo);
        return "show3/index";
    }

    @RequestMapping(value = "getMessageMongoDBInfo")
    public String getMessageMongoDBInfo(Model model, Message message) throws Exception{
        log.debug("通过sql的方式查询文本信息");
        Message messageInfo = messageMongoDB.messageInfo(message);
        model.addAttribute("messageInfo", messageInfo);
        return "show3/index";
    }
}
