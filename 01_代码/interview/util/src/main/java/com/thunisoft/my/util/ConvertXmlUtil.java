package com.thunisoft.my.util;

import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * @author chenzhen-1
 * @create 2019-07-05 11:09
 */
public class ConvertXmlUtil {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory
            .getLogger(ConvertXmlUtil.class);



    /**
     * 将xml文件转换成对象
     * @param path 路径
     * @param map  别名map
     * @return
     */
    public static Object convertXmlToObjectByFile(String path, Map<String, Class<?>> map) {
        XStream stream = new XStream();
        stream.autodetectAnnotations(true);
        putXStreamAlias(stream, map);
        FileInputStream fileInputStream = null;
        InputStreamReader fileReader = null;
        Object object = null;
        try {
            File file = new File(path);
            fileInputStream = new FileInputStream(file);
            fileReader = new InputStreamReader(fileInputStream, "utf-8");
            object = stream.fromXML(fileReader);
        } catch (FileNotFoundException e) {
            logger.error("路径【" + path + "】文件没有找到！", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("路径【" + path + "】文件不支持utf-8的转码！", e);
        } finally{
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                logger.error("文件输入流异常！", e);
            }
        }
        return object;
    }

    /**
     * @param inputStream 文件流
     * @param map 别名Map
     * @return
     */
    public static Object convertXmlToObjectByInputStream(InputStream inputStream, Map<String, Class<?>> map){
        XStream stream = new XStream();
        putXStreamAlias(stream, map);
        stream.autodetectAnnotations(true);
        Object object = null;
        try {
            object = stream.fromXML(inputStream);
        } finally{
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
//                logger.error("文件输入流异常！", e);
            }
        }
        return object;
    }

    /**
     * 将xml转换成Object
     * @param xml xml
     * @param map 别名Map
     * @return
     */
    public static Object convertXmlToObject(String xml, Map<String, Class<?>> map){
        XStream stream = new XStream();
        putXStreamAlias(stream, map);
        stream.autodetectAnnotations(true);
        Object obj  =  stream.fromXML(xml);
        return obj;
    }

    /**
     * 放入别名
     * @param stream xml操作对象
     * @param map 别名Map
     */
    private static void putXStreamAlias(XStream stream, Map<String, Class<?>> map){
        if (map != null) {
            for (Map.Entry<String, Class<?>> key : map.entrySet()) {
                stream.alias(key.getKey(), key.getValue());
            }
        }
    }
    /**
     * 将转换对象转成xml格式
     * @param obj obj
     * @param map 别名Map
     * @return
     */
    public static String convertObjectToXml(Object obj, Map<String, Class<?>> map){
        XStream stream = new XStream();
        stream.autodetectAnnotations(true);//使用注解修改属性名
        putXStreamAlias(stream, map);
        return stream.toXML(obj);
    }

}

