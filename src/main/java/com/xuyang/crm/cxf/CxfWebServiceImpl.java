package com.xuyang.crm.cxf;

import com.xuyang.crm.cxf.def.BaseDef;
import com.xuyang.crm.cxf.model.Cxf;

import javax.jws.WebService;

/**
 * webserie的实现类
 *
 * @author 许洋
 * @create 2018-11-30 0:13
 **/
@WebService(endpointInterface="com.xuyang.crm.cxf.CxfWebService",serviceName="CxfWebService",targetNamespace= BaseDef.NS)
public class CxfWebServiceImpl implements CxfWebService{

    @Override
    public String getUserName(String userId) {
        System.out.println("1111"+userId);
        return "1111"+userId;
    }

    @Override
    public String getUser(String userId) {
        System.out.println("2222"+userId);
        return "2222"+userId;
    }

    @Override
    public String getCxf(String userId) {
        Cxf cxf = new Cxf();
        cxf.setUserId(userId);
        return cxf.toString();
    }
}
