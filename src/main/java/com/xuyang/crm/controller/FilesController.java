package com.xuyang.crm.controller;

import com.xuyang.crm.model.Files;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;

@Slf4j
@Data
@RestController
public class FilesController {

    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ResponseBody
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestBody @RequestParam("file") CommonsMultipartFile file) throws Exception {
        //用来检测程序运行时间
        log.debug("文件名称："+file.getOriginalFilename());
        try {
            //获取输出流
            OutputStream os=new FileOutputStream("D:\\file\\server\\" + file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1)) {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
            log.debug("文件上传成功");
            return "文件上传成功";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @ResponseBody
    @RequestMapping(value = "fileUpload2", method = RequestMethod.POST)
    public String  fileUpload2(@RequestBody @RequestParam("file") CommonsMultipartFile file) throws Exception {
        try {
            log.debug("fileName："+file.getOriginalFilename());
            String path="D:\\file\\server\\" + file.getOriginalFilename();
            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            log.debug("上传成功");
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败："+ e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> export(@RequestBody @RequestParam("fileName") String fileName,
                                         @RequestBody @RequestParam("filePath") String filePath) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        File file = new File(filePath);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
