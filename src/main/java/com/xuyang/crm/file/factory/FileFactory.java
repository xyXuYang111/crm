package com.xuyang.crm.file.factory;

import com.xuyang.crm.Exception.MyException;
import com.xuyang.crm.file.def.FileDef;
import com.xuyang.crm.file.factory.type.FileType0;
import com.xuyang.crm.file.factory.type.FileType1;
import com.xuyang.crm.file.factory.type.FileType2;
import com.xuyang.crm.model.Files;
import com.xuyang.crm.util.FileUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 22:36
 * @Description:
 */
@Component
@Slf4j
@Data
public class FileFactory {

    private static FileType0 fileType0;

    @Autowired
    public void setFileType0(FileType0 fileType0) {
        FileFactory.fileType0 = fileType0;
    }

    private static FileType1 fileType1;

    @Autowired
    public void setFileType1(FileType1 fileType1) {
        FileFactory.fileType1 = fileType1;
    }

    private static FileType2 fileType2;

    @Autowired
    public void setFileType2(FileType2 fileType2) {
        FileFactory.fileType2 = fileType2;
    }

    public static AbstractFile getAbstractFile(Files files) throws Exception{

        if (files == null) {
            log.error("文件信息不存在。");
            new MyException("文件类型不存在");
        }

        String fileName = files.getMultipartFile().getOriginalFilename();

        String fileType = FileUtil.fileType(fileName);

        if (FileDef.FILE_TYPE_1.contains(fileType)) {
            fileType1.setFiles(files);
            return fileType1;
        } else if (FileDef.FILE_TYPE_2.contains(fileType)) {
            fileType2.setFiles(files);
            return fileType2;
        } else {
            fileType0.setFiles(files);
            return fileType0;
        }
    }
}
