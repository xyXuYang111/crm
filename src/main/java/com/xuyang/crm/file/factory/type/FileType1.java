package com.xuyang.crm.file.factory.type;

import com.xuyang.crm.file.def.FileDef;
import com.xuyang.crm.file.factory.AbstractFile;
import com.xuyang.crm.util.FileUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 22:31
 * @Description:
 */
@Component
@Slf4j
@Data
@Scope("prototype")
public class FileType1 extends AbstractFile {

    @Override
    public void fileUpload() throws Exception {

        MultipartFile multipartFile = files.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();

        String fileType = FileUtil.fileTyp2(fileName);

        String systemName = UUID.randomUUID().toString();

        StringBuilder filePathBuilder = new StringBuilder();
        filePathBuilder.append(FileDef.FILE_TYPE_1_URL);
        filePathBuilder.append(systemName);
        filePathBuilder.append(fileType);

        files.setFileType("文本");
        files.setFilePath(filePathBuilder.toString());
        files.setFileName(fileName);
        files.setSystemName(systemName + fileType);
        files.setFilePath(filePathBuilder.toString());

        super.fileUpload();
    }

    @Override
    public void fileDown() throws Exception {
        super.fileDown();
    }
}
