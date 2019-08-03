package com.thunisoft.my.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author chenzhen-1
 * @create 2019-07-05 11:13
 *
 * Gson 使用
 *
 */
public class ConvertJsonUtil {
    /**
     * 解析json转换成对象
     * @param json json串
     * @param cla 对象
     * @return
     */
    public static Object parseJsonToObject(String json, Class<?> cla) {
        Gson gson = new Gson();
        return gson.fromJson(json, cla);
    }

    /**
     * 解析json转换成map
     * @param json json串
     * @param typeToken 泛型类型
     * @return
     */
    public static Map<?, ?> parseJsonToMap(String json, TypeToken<?> typeToken) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeToken.getType());
    }

    /**
     * 将Object解析成JSON
     * @param object 对象
     * @return
     */
    public static String parseObjectToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> String object_to_json(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        try {
            json = URLEncoder.encode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static <T> T json_to_object(String json, Class<T> t) {
        try {
            json = URLDecoder.decode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        T fromJson = gson.fromJson(json, t);
        return fromJson;
    }


    public static <T> String list_to_json(List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try {
            json = URLEncoder.encode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;

    }


}

