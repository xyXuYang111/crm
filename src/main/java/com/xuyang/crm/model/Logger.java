package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@ToString
public class Logger implements Serializable {

    private static final long serialVersionUID = -4991901771565207029L;

    private String content;

    private String code;

    private String time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
