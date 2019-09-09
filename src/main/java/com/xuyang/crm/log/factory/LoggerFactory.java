package com.xuyang.crm.log.factory;

import com.xuyang.crm.log.def.LoggerDef;
import com.xuyang.crm.log.factory.type.LoggerType0;
import com.xuyang.crm.log.factory.type.LoggerType1;
import com.xuyang.crm.log.factory.type.LoggerType2;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/9 08:30
 * @Description:
 */
@Slf4j
@Component
public class LoggerFactory {

    private static LoggerType0 loggerType0;

    @Autowired
    public void setLoggerType0(LoggerType0 loggerType0) {
        LoggerFactory.loggerType0 = loggerType0;
    }

    private static LoggerType1 loggerType1;

    @Autowired
    public void setLoggerType1(LoggerType1 loggerType1) {
        LoggerFactory.loggerType1 = loggerType1;
    }

    private static LoggerType2 loggerType2;

    @Autowired
    public void setLoggerType2(LoggerType2 loggerType2) {
        LoggerFactory.loggerType2 = loggerType2;
    }

    public static LoggerAbstract getLoggerAbstract(String loggerType) throws Exception{
        if(loggerType.equals(LoggerDef.LOGGER_TYPE_1)){
            return loggerType1;
        }else if(loggerType.equals(LoggerDef.LOGGER_TYPE_2)){
            return loggerType2;
        }else{
            return loggerType0;
        }
    }
}
