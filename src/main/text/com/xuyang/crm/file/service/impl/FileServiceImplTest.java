package com.xuyang.crm.file.service.impl;

import com.xuyang.crm.file.service.FileService;
import com.xuyang.crm.model.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class FileServiceImplTest {

    @Autowired
    private FileService fileService;
    @Test
    public void filesInfo() {
        Files files =new Files();
        files.setFileID("1");

        try {
            Files filesInfo = fileService.filesInfo(files);
            if(filesInfo == null){
                System.out.println("有问题");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
