package com.xuyang.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Slf4j
@ToString
@Document(collection = "Files")
public class Files implements Serializable {

    private static final long serialVersionUID = -831903812173794075L;

    @Id
    @JsonProperty(value = "fileID")
    private String fileID;

    @Field
    @JsonProperty(value = "systemName")
    private String systemName;

    @Field
    @JsonProperty(value = "fileName")
    private String fileName;

    @Field
    @JsonProperty(value = "fileByte")
    private String fileByte;

    @Field
    @JsonProperty(value = "fileNum")
    private String fileNum;

    @Field
    @JsonProperty(value = "createTime")
    private String createTime;

    @Field
    @JsonProperty(value = "filePath")
    private String filePath;

    @Field
    @JsonProperty(value = "fileType")
    private String fileType;

    private MultipartFile multipartFile;
}
