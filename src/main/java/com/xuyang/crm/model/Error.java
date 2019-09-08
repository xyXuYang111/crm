package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@ToString
public class Error implements Serializable {

    private static final long serialVersionUID = -5720384293499919683L;

    private String date;

    private String methodName;

    private String param;

    private String msg;
}
