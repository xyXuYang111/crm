package com.xuyang.crm.cxf;

import lombok.extern.slf4j.Slf4j;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;
import java.net.URL;

/**
 * cxf的请求访问
 *
 * @author 许洋
 * @create 2018-12-18 14:39
 **/
@Slf4j
public class CxfConnection {
    /**
     * axis方式请求服务
     * @param text 文本内容
     * @param serviceName 服务名：webservice接口
     * @param nameSpaceUrl 服务地址
     * @param address 服务值
     * @return
     * @throws Exception
     */
    public static String axisConnection(String text, String serviceName, String nameSpaceUrl, String address) throws Exception{

        log.info("同步内容：" + text);
        //创建一个Service实例
        Service service = new Service();
        //创建Call实例
        Call call = (Call) service.createCall();
        //指明服务所在位置
        call.setTargetEndpointAddress(new URL(address));
        //为Call设置服务的位置 指定namespace， 要调用syncSuppInfo 中的方法名
        call.setOperationName(new QName(nameSpaceUrl, serviceName));
        //指定参数个数
        call.addParameter("userId", XMLType.XSD_STRING, ParameterMode.IN);
        //传入的参数需要封装到object数组中，返回值可直接获取
        String resultXml = (String) call.invoke(new Object[]{text});

        System.out.println("Result is : " + resultXml);
        log.info("返回报文："+resultXml);

        return resultXml;
    }


}
