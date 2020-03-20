package com.thunisoft.test.jjr;



import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 判断是否是法定节假日
 *
 */
public class JjrDateTest {
    public static  String getData(String addess){
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;

        StringBuffer sb = new StringBuffer();
        try{
            url = new URL(addess);
            in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8") );
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {
        } finally{
            try{
                if(in!=null) {
                    in.close();
                }
            }catch(IOException ex) {
            }
        }
        String  data =sb.toString();
        return data;
    }

    //json串转化为json对象
    public static JSONObject getjson(String data) {
        JSONObject json = JSONObject.fromObject(data);
        return json;
    }

    public static void main(String[] args) {
        String  s1 = getData("http://api.goseek.cn/Tools/holiday?date=20191012");
        JSONObject json =  getjson(s1);
        String value=json.get("data").toString();
        System.out.println(value);
    }

}
