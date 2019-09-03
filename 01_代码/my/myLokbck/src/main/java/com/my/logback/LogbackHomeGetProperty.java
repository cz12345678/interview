package com.my.logback;

import java.io.File;


import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @describe: 自定义获取日志存放路径的类
 * @author:  chenzhen-1
 * @date: 2019-8-3-下午1:40:44
 */
public class LogbackHomeGetProperty extends PropertyDefinerBase {
	
    /**jetty.home*/
    private static final String JETTY_HOME = "jetty.home";

    /**catalina.home*/
    private static final String CATALINA_HOME = "catalina.home";

    /**zhfy-日志路径*/
    private static final String MY_HOME = "logs";

    @Override
    public String getPropertyValue() {
        String jettyPath = System.getProperty(JETTY_HOME);
        String catalinaPath = System.getProperty(CATALINA_HOME);
        String path = defaultString(jettyPath, catalinaPath);
        if (isBlank(path)) {
        	System.err.println("xxxxxxxxxxxxx000000000000xxxxxxxxxx");
            return MY_HOME;
        }
        File file = new File(path);
        if (file.exists()) {
        	System.err.println("xxxxxxxxxxxxx11111111111xxxxxxxxxx");
            return file.getPath() + File.separator + MY_HOME;
        }
        return MY_HOME;
    }
    
    
    
    private String defaultString(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }
    
    private boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    

}
