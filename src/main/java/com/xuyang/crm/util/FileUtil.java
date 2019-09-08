package com.xuyang.crm.util;

/**
 * @Auther: 许洋
 * @Date: 2019/9/8 00:20
 * @Description:
 */
public class FileUtil {

    public static String fileType(String fileName){
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length -1;
        System.out.println(strArray[suffixIndex]);
        return strArray[suffixIndex];
    }

    public static String fileTyp2(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String fileName(String fileName){
        String caselSh = fileName.substring(0,fileName.lastIndexOf("."));
        System.out.println(caselSh);
        return caselSh;
    }

    public static String fileNameNow(String fileName){
        String temp[]=fileName.split("\\\\");
        String fileNameNow=temp[temp.length-1];
        System.out.println(fileNameNow);
        return fileNameNow;
    }
}
