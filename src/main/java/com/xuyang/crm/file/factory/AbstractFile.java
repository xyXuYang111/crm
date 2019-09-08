package com.xuyang.crm.file.factory;

import com.xuyang.crm.file.service.FileMongoDB;
import com.xuyang.crm.file.service.FileService;
import com.xuyang.crm.log.service.LoggerMongoDB;
import com.xuyang.crm.log.service.LoggerService;
import com.xuyang.crm.model.Files;
import com.xuyang.crm.model.Logger;
import com.xuyang.crm.util.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 21:06
 * @Description:
 */
@Component
@Slf4j
@Data
public abstract class AbstractFile implements FileOperate {

    protected Files files;

    @Autowired
    private FileService fileService;

    @Autowired
    private FileMongoDB fileMongoDB;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private LoggerMongoDB loggerMongoDB;

    @Override
    public void fileUpload() throws Exception {
        String filePath = files.getFilePath();

        MultipartFile multipartFile = files.getMultipartFile();

        //获取输出流
        OutputStream os = new FileOutputStream(filePath);
        //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
        InputStream is = multipartFile.getInputStream();
        int temp;
        //一个一个字节的读取并写入
        while ((temp = is.read()) != (-1)) {
            os.write(temp);
        }
        os.flush();
        os.close();
        is.close();

        //文件信息入库
        fileService.insertFiles(files);

        Files filesInfo = new Files();
        filesInfo.setFileID(files.getFileID());
        filesInfo.setFileType(files.getFileType());
        filesInfo.setFilePath(files.getFilePath());
        filesInfo.setSystemName(files.getSystemName());
        filesInfo.setFileName(files.getFileName());
        filesInfo.setCreateTime(DateUtil.getNowSecond());
        //文件信息入库
        fileMongoDB.insertFile(filesInfo);

        Logger logger = new Logger();
        logger.setLogContent(files.toString());
        logger.setLogType("文件");
        //日志记录
        loggerService.insertLogger(logger);
        loggerMongoDB.insertLogger(logger);
    }

    @Override
    public void fileDown() throws Exception {

    }
}
