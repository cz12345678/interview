package com.error.learn.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);

        // 添加自定义参数
        errorAttributes.put("自定义参数K1", "自定义参数V1");
        errorAttributes.put("自定义参数K2", "自定义参数V2");

        // 获取请求域中的参数
        Map<String, Object> extMap = (Map<String, Object>) requestAttributes.getAttribute("extMap", 0);
        errorAttributes.put("extMap", extMap);

        return errorAttributes;
    }
}
