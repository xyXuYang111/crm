package com.xuyang.crm.controller;

import com.xuyang.crm.model.Files;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Data
@RestController
public class FilesController {

    /**
     * 字节流传输接口
     * @param files
     */
    @RequestMapping(value = "saveFiles", method = RequestMethod.POST)
    public void saveFiles(@RequestBody Files files){

    }
}
