package com.lathingfisher.neptune.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @auther mxh
 * @time 2019/5/20 13:48
 */
public class HttpUtil {

    public static JSONObject getResult(String urls) throws IOException {

//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        URL url = new URL(urls);
        //打开和url之间的连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //请求方式
        conn.setRequestMethod("GET");
        //设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
        //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
        //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。get请求不需要设置
//        conn.setDoOutput(true);
//        conn.setDoInput(true);
        //获取URLConnection对象对应的输出流
        conn.connect();
        //获取URLConnection对象对应的输入流
        InputStream is = conn.getInputStream();
        //构造一个字符流缓存
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str;
        JSONObject jsonss = null;
        while ((str = br.readLine()) != null) {
            jsonss = JSONObject.parseObject(str);
        }
//        System.out.println("获取到的报文数据为：" + jsonss);
        return jsonss;
    }

    public static List<Map<String,Object>> getData(JSONObject jsonObject) {
        JSONObject data = (JSONObject) jsonObject.get("data");
        List<Map<String,Object>> list = (List)data.get("list");
        return list;
    }

}