package com.xuyang.crm.cxf;

import com.xuyang.crm.cxf.def.BaseDef;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * cxf服务
 *
 * @author 许洋
 * @create 2018-11-30 0:09
 **/
@WebService(name = "UserService", targetNamespace = BaseDef.NS)
public interface CxfWebService {

    /**
     * WebService是必须的；@WebParam不是必须的。
     * 如果没有@WebParam的描述，在wsdl文件内描述的方法中，参数名将变为arg0,arg1…以此类推.
     * @param userId
     * @return
     */
    public String getUserName(@WebParam(name = "userId") String userId);

    /**
     * 测试2
     * @param userId
     * @return
     */
    public String getUser(@WebParam(name = "userId") String userId);

    /**
     * 测试：返回user对象
     * @param userId
     * @return
     */
    public String getCxf(@WebParam(name = "userId") String userId);
}
