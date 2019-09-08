package com.xuyang.crm.controller;

import com.xuyang.crm.file.factory.FileFactory;
import com.xuyang.crm.file.factory.FileOperate;
import com.xuyang.crm.file.service.FileMongoDB;
import com.xuyang.crm.file.service.FileService;
import com.xuyang.crm.model.Files;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

@Slf4j
@Data
@Controller
public class FilesController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileMongoDB fileMongoDB;

    /**
     * 文件显示:数据库
     * @return
     */
    @RequestMapping(value = "getFilesSqlList")
    public String getFilesSqlList(Model model, Files files) throws Exception{
        log.debug("文件列表显示");
        List<Files> filesList = fileService.filesList(files);
        model.addAttribute("filesList", filesList);
        return "file/show";
    }

    /**
     * 文件显示:数据库
     * @return
     */
    @RequestMapping(value = "getFilesMongoDBList")
    public String getFilesMongoDBList(Model model, Files files) throws Exception{
        log.debug("文件列表显示");
        List<Files> filesList = fileMongoDB.fileList(files);
        model.addAttribute("filesList", filesList);
        return "file/show2";
    }

    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ResponseBody
    @RequestMapping(value = "fileTextUpload", method = RequestMethod.POST)
    public String fileTextUpload(@RequestParam(value="file") MultipartFile multipartFile) throws Exception {
        //用来检测程序运行时间
        log.debug("文件名称："+multipartFile.getOriginalFilename());
        try {

            Files files = new Files();
            files.setMultipartFile(multipartFile);

            FileOperate fileOperate = FileFactory.getAbstractFile(files);
            fileOperate.fileUpload();;

            log.debug("文件上传成功");
            return "文件上传成功";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.debug("异常信息："+ e.getMessage());
            return e.getMessage();
        }
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @ResponseBody
    @RequestMapping(value = "filePhotoUpload", method = RequestMethod.POST)
    public String  filePhotoUpload(@RequestBody @RequestParam("file") CommonsMultipartFile file) throws Exception {
        try {
            log.debug("fileName："+file.getOriginalFilename());
            String path="D:\\file\\server\\photo\\" + file.getOriginalFilename();
            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            log.debug("上传成功");
            return "上传成功";
        } catch (Exception e) {
            log.debug("异常信息："+ e.getMessage());;
            return "上传失败："+ e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(Files filesParam) throws Exception {

        HttpHeaders headers = new HttpHeaders();

        String fileID = filesParam.getFileID();

        Files files = new Files();
        files.setFileID(fileID);

        Files filesInfo = fileService.filesInfo(files);

        File file = new File(filesInfo.getFilePath());
        String fileName = filesInfo.getFileName();

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/downloadMongoDB")
    public void downloadMongoDB(HttpServletResponse response, Files filesParam) throws Exception {

        log.debug("第二种文件下载方式");
        String fileID = filesParam.getFileID();

        Files filesInfo = new Files();
        filesInfo.setFileID(fileID);
        Files files = fileMongoDB.fileInfo(filesInfo);

        response.setContentType("application/x-msdownload; charset=utf-8");
        File file = new File(files.getFilePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        String fileName = new String(file.getName().getBytes(), "GBK");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        OutputStream ops = response.getOutputStream();
        IOUtils.copy(fileInputStream, ops);

        //关闭文件流
        ops.flush();
        ops.close();
        fileInputStream.close();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFile")
    public void deleteFile(Files filesParam) throws Exception {
        try {
            log.debug("删除文件");

            String fileID = filesParam.getFileID();

            Files files = new Files();
            files.setFileID(fileID);

            fileService.deleteFiles(files);
            log.debug("文件删除成功");
        } catch (Exception e) {
            log.debug("文件删除失败：" + e.getMessage());
        }
    }
}
