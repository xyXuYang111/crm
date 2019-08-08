package com.xuyang.crm.mongo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Auther: cypc
 * @Date: 2019/8/8 19:22
 * @Description:
 */
@Slf4j
@Component
public class MongodbUtil {

    /**
     * 完全匹配
     */
    public static Pattern allPattern(String value){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^");
        stringBuilder.append(value);
        stringBuilder.append("$");
        Pattern allPattern = Pattern.compile(stringBuilder.toString(), Pattern.CASE_INSENSITIVE);
        return allPattern;
    }

    /**
     * 右模糊
     * @param value
     * @return
     */
    public static Pattern rightPattern(String value){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^*");
        stringBuilder.append(value);
        stringBuilder.append(".$");
        Pattern rightPattern = Pattern.compile(stringBuilder.toString(), Pattern.CASE_INSENSITIVE);
        return rightPattern;
    }

    /**
     * 左模糊
     * @param value
     * @return
     */
    public static Pattern leftPattern(String value){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^");
        stringBuilder.append(value);
        stringBuilder.append(".*$");
        Pattern leftPattern = Pattern.compile(stringBuilder.toString(), Pattern.CASE_INSENSITIVE);
        return leftPattern;
    }

    /**
     * 全模糊
     * @param value
     * @return
     */
    public static Pattern pattern(String value){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^.*");
        stringBuilder.append(value);
        stringBuilder.append(".*$");
        Pattern pattern = Pattern.compile(stringBuilder.toString(), Pattern.CASE_INSENSITIVE);
        return pattern;
    }
}
