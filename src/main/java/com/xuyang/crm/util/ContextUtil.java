package com.xuyang.crm.util;

import com.xuyang.crm.cxf.def.BaseDef;
import org.mybatis.generator.internal.util.EqualsUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ContextUtil {

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取response
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        return ContextUtil.getRequest().getSession();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static String getSessionId() {
        HttpSession session = ContextUtil.getSession();
        return session.getId();
    }

    /**
     * Description: 获取客户端IP地址 <br>
     * @return
     * @author wanghao
     */
    public static String getIpAddr() {
        HttpServletRequest request = ContextUtil.getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * Description: 获取请求路径<br>
     * @author houz
     * @return
     */
    public static String getContextPath() {
        HttpServletRequest request = ContextUtil.getRequest();
        return request.getContextPath();
    }

    /**
     * 获取InputStream
     *
     * @return
     */
    public static String getRealPath(String url) {
        return getRequest().getServletContext().getRealPath(url);
    }

    /**
     * struts2下获取InputStream
     *
     * @return
     */
    public static InputStream getResourceAsStream(String url) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
    }

    public static OutputStream getOutputStream() throws IOException {
        return ContextUtil.getResponse().getOutputStream();
    }

    /**
     * 判断是否是IE浏览器
     */
    public static boolean isMsBrowser(HttpServletRequest request) {
        String[] ieBrowserSignals = {"MSIE", "Trident", "Edge"};
        String userAgent = request.getHeader("User-Agent");
        for (String signal : ieBrowserSignals) {
            if (userAgent.contains(signal)){
                return true;
            }
        }
        return false;
    }

    public static String getCssScript() throws IOException{
        String contextPath = ContextUtil.getContextPath();

        StringBuilder contextBuilder = new StringBuilder();
        contextBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
        contextBuilder.append(contextPath).append("/static/default/css/jquery-ui.min.css\" type=\"text/css\">");
        contextBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
        contextBuilder.append(contextPath).append("/static/layui/css/layui.css\" type=\"text/css\">");

        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/jquery.min.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/jquery-common.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/jquery.validate.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/jquery_form.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/jquery.blockUI.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/layui/layui.all.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/message.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/jquery.autoResize.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/custom/constant.js\"></script>");
        contextBuilder.append("<script language=\"javascript\" type=\"text/javascript\" src=\"");
        contextBuilder.append(contextPath).append("/static/default/js/custom/common.js\"></script>");

        contextBuilder.append("<script>");
        contextBuilder.append("var contextPath = '");
        contextBuilder.append(contextPath);
        contextBuilder.append("';");
        contextBuilder.append("</script>");

        return contextBuilder.toString();
    }
}
