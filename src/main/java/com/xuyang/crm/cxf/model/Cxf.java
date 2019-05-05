package com.xuyang.crm.cxf.model;

import com.xuyang.crm.cxf.def.BaseDef;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author 许洋
 * @create 2018-12-17 12:30
 **/
@XmlRootElement(name = "root")
@XmlType(name = "cxf", namespace = BaseDef.NS)
@Data
public class Cxf {

    private String userId;
}
