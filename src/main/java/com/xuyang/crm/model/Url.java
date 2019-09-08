package com.xuyang.crm.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@ToString
public class Url implements Serializable {

    private static final long serialVersionUID = 7363527384175558994L;

    private String ip;

    private String uri;

    private String url;

    private String returnIp;

    private String params;

    private String host;

    private int port;
}
