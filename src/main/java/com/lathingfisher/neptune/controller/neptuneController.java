package com.lathingfisher.neptune.controller;

import com.alibaba.fastjson.JSONObject;
import com.lathingfisher.neptune.service.NeptuneService;
import com.lathingfisher.neptune.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/15 15:49
 */
@Controller
public class neptuneController {

    @Autowired
    public NeptuneService neptuneService;

    @RequestMapping("/neptune")
    @ResponseBody
    public Map<String, Object> neptune(String type, String value) {


        List<Map> maps = neptuneService.selectAll();




        Map<String, Object> resultData = new HashMap<>();
//        List<Map<String, String>> maps = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();

//        if ("3".equals(value)) {
//            resultData.put("result", "error");
//        } else {
//
//            map.put("date", "2016-05-07");
//            map.put("name", "王小虎");
//            map.put("address", "上海市普陀区金沙江路 1518 弄");
//            map.put("value", value);
//            map.put("type", type);
//            maps.add(map);
//            resultData.put("data", maps);
//            resultData.put("result", "success");
//        }

        resultData.put("result", "error");

        return resultData;
    }

//    @RequestMapping()

    public static void main1(String[] args) {

        try {

            //获取全部直播的总数
            JSONObject result = HttpUtil.getResult("https://api.live.bilibili.com/room/v1/Area/getLiveRoomCountByAreaID?areaId=0");
            Object data = result.get("data");
            Map<String, Integer> data1 = (Map) data;
            Integer totalNum = data1.get("num");

//            System.out.println(totalNum);

            //计算出总共多少页
            double ceil = Math.ceil(Double.valueOf(totalNum) / 30);

            //循环遍历
            for (int i = 0; i <= ceil; i++) {

                JSONObject result1 = HttpUtil.getResult("https://api.live.bilibili.com/room/v1/room/get_user_recommend?page" + i);

                Object msg = result1.get("msg");

                if (msg != null) {

                    if ("ok".equals(msg.toString())) {

                        List<Map<String, Object>> dataList = (List) result1.get("data");

                        for (Map<String, Object> stringObjectMap : dataList) {


                        }

                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
