package com.lathingfisher.neptune.neptuneController;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @auther mxh
 * @time 2019/5/20 13:48
 */
public class ZhiHuTest {

    public static void main(String[] args) throws IOException {

        String urls = "https://api.live.bilibili.com/room/v1/room/get_user_recommend?page=0";
        URL url = new URL(urls);
        //打开和url之间的连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        PrintWriter out = null;
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
        System.out.println("获取到的报文数据为：" + jsonss);
    }

}