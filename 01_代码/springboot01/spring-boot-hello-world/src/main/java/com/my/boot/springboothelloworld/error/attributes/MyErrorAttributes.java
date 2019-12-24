package com.my.boot.springboothelloworld.error.attributes;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义异常返回属性
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 重写getErrorAttributes()方法，加入自己定义的属性值
     * @param webRequest
     * @param includeStackTrace
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        // 获取原来的属性
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        // 添加自己需要添加的属性
        errorAttributes.put("my","my-learn-test");
        return errorAttributes;
    }


}
