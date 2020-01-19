package com.lathingfisher.neptune.neptuneController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/15 15:49
 */
@Controller
public class neptuneController {

    @RequestMapping("/neptune")
    @ResponseBody
    public Map<String, Object> neptune(String type, String value) {
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

}
