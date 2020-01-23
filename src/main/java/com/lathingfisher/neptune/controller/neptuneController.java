package com.lathingfisher.neptune.controller;

import com.alibaba.fastjson.JSONObject;
import com.lathingfisher.neptune.service.NeptuneService;
import com.lathingfisher.neptune.util.HttpUtil;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/15 15:49
 */
@Controller
@SuppressWarnings("all")
@Component
public class neptuneController {

    @Autowired
    public NeptuneService neptuneService;

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @RequestMapping("/neptune")
    @ResponseBody
    public Map<String, Object> neptune(String type, String value) {

        Map<String, Object> resultData = new HashMap<>();

        try {
//            neptuneService.selectSearch("");

            Connection con = Jsoup.connect("http://search.bilibili.com/upuser?keyword=拜托了_喵大人");// 获取连接

            Response rs = con.execute();// 获取响应

            Document d1 = Jsoup.parse(rs.body());// 转换为Dom树

            System.out.println(d1);

            List<Element> et = d1.select("a.face-img");
            for (Element element : et) {
                String href = element.attr("href");


            }

            System.out.println(et);


        } catch (Exception e) {
            e.printStackTrace();
        }
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

    //    @RequestMapping("/testNeptune")
//    @ResponseBody
    @Scheduled(cron = "0 */60 * * * ?")
    public void test() {

        List<Map<String, Object>> maps = new ArrayList<>();
        long start = System.currentTimeMillis();
        System.out.println(sf.format(new Date()));
        try {

            //获取全部直播的总数
            JSONObject result = HttpUtil.getResult("https://api.live.bilibili.com/room/v1/Area/getLiveRoomCountByAreaID?areaId=0");
            Object data = result.get("data");
            Map<String, Integer> data1 = (Map) data;
            Integer totalNum = data1.get("num");

            JSONObject result1;
            List<Map<String, Object>> dataList;

            Object msg;

            //计算出总共多少页
            double ceil = Math.ceil(Double.valueOf(totalNum) / 30);

            //循环遍历
            for (int i = 0; i <= ceil; i++) {

                result1 = HttpUtil.getResult("https://api.live.bilibili.com/room/v1/room/get_user_recommend?page=" + i);

                msg = result1.get("msg");

                if (msg != null) {

                    if ("ok".equals(msg.toString())) {

                        dataList = (List) result1.get("data");

                        if (dataList.size() > 0) {

                            maps.addAll(dataList);
                        }

                    }
                }

            }

            Object roomid;
            Object uid;
            JSONObject guardTab;

            List<Map<String, Object>> insertMaps = new ArrayList<>();

            long mind = System.currentTimeMillis();

            System.out.println((mind - start) / 1000);

            for (Map<String, Object> map : maps) {
                roomid = map.get("roomid");
                uid = map.get("uid");
                if (roomid != null && uid != null) {

                    //七日榜
//                    sevenRank(roomid, uid);

                    //舰长
                    getGuardTab(roomid, uid);

                    //友爱社
                    getUnionFans(roomid, uid);

                    //房管
                    getRoomAdmin(roomid, uid);


                    //粉丝榜
//                    JSONObject medalRank = HttpUtil.getResult("https://api.live.bilibili.com/rankdb/v1/RoomRank/webMedalRank?roomid=" + roomid + "&ruid=" + uid);
//                    JSONObject dataMedalRank = (JSONObject) medalRank.get("data");
//                    List<Map<String,Object>> list = (List) dataMedalRank.get("list");
//                    if (list.size() > 0) {
//
//                        for (Map<String, Object> stringObjectMap : list) {
//
//                            stringObjectMap.put("roomid", roomid);
//
//                        }
//
//                        neptuneService.selectByMedalRank(list);
//
//                        neptuneService.insertMedalRank(list);
//                    }


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("全部用时:" + (System.currentTimeMillis() - start) / 1000);
    }

    private List<Map<String, Object>> getRoomAdmin(Object roomid, Object uid) throws IOException {
        JSONObject roomAdmin = HttpUtil.getResult("https://api.live.bilibili.com/xlive/web-room/v1/roomAdmin/get_by_room?roomid=" + roomid + "&page_size=100");
        JSONObject dataRoomAdmin = (JSONObject) roomAdmin.get("data");
        List<Map<String, Object>> data2 = (List) dataRoomAdmin.get("data");
        if (data2.size() > 0) {

            for (Map<String, Object> stringObjectMap : data2) {
                stringObjectMap.put("roomid", roomid);
                stringObjectMap.put("ruid", uid);
            }

            List<Map<String, Object>> mapList = neptuneService.selectByRoomAdmin(uid);

            if (mapList.size() > 0) {


                List<Map<String, Object>> mapList1 = compareListDataNotInInsert(data2, mapList);
                if (mapList1.size() > 0) {

                    neptuneService.insertRoomAdmin(mapList1);
                }

                List<Integer> integers = compareListDataNotInDelete(data2, mapList);
                if (integers.size() > 0) {

                    neptuneService.deleteRoomAdmin(integers);
                }

            } else {
                neptuneService.insertRoomAdmin(data2);
            }
        }
        return data2;
    }

    private void getUnionFans(Object roomid, Object uid) throws IOException {
        JSONObject UnionFans = HttpUtil.getResult("https://api.live.bilibili.com/activity/v1/UnionFans/roomFansRank?roomid=" + roomid + "&ruid=" + uid);
        List<Map<String, Object>> list = (List) UnionFans.get("data");
        if (list.size() > 0) {

            for (Map<String, Object> stringObjectMap : list) {

                stringObjectMap.put("roomid", roomid);
                stringObjectMap.put("ruid", uid);

                neptuneService.insertUnionFans(stringObjectMap);

            }

        }
    }

    private void getGuardTab(Object roomid, Object uid) throws IOException {
        JSONObject guardTab;
        JSONObject dataGuardTab;
        List<Map<String, Object>> top3;
        List<Map<String, Object>> list;
        Map<String, Object> info;
        JSONObject guardTab1;
        List<Map<String, Object>> data2;

        //舰队
        guardTab = HttpUtil.getResult("https://api.live.bilibili.com/xlive/app-room/v1/guardTab/topList?roomid=" + roomid + "&page=1&ruid=" + uid + "&page_size=29");

        dataGuardTab = (JSONObject) guardTab.get("data");

        top3 = (List) dataGuardTab.get("top3");

        if (top3.size() > 0) {

            list = (List) dataGuardTab.get("list");
            info = (Map) dataGuardTab.get("info");

            if (list.size() > 0) {
                top3.addAll(list);

                if (info != null) {
                    Integer num = (Integer) info.get("num");
                    if (num > 0) {

                        Integer integer = (Integer) info.get("page");

                        for (int i = 2; i <= integer; i++) {

                            guardTab1 = HttpUtil.getResult("https://api.live.bilibili.com/xlive/app-room/v1/guardTab/topList?roomid=" + roomid + "&page=" + i + "&ruid=" + uid + "&page_size=29");
                            data2 = HttpUtil.getData(guardTab1);
                            if (data2.size() > 0) {
                                top3.addAll(data2);
                            }
                        }
                    }
                }
            }

            List<Map<String, Object>> mapList = neptuneService.selectByGuardTabRuid(uid);

            if (mapList.size() > 0) {

                List<Map<String, Object>> lists = compareListDataNotInInsert(top3, mapList);
                if (lists.size() > 0) {

                    for (Map<String, Object> stringObjectMap : lists) {
                        stringObjectMap.put("roomid", roomid);
                    }

                    neptuneService.insertGuardTab(lists);
                }

                List<Integer> integers = compareListDataNotInDelete(top3, mapList);

                if (integers.size() > 0) {

                    neptuneService.deleteGuardTab(integers);
                }

            } else {

                for (Map<String, Object> stringObjectMap : top3) {
                    stringObjectMap.put("roomid", roomid);
                }

                neptuneService.insertGuardTab(top3);
            }
        }
    }

    private void sevenRank(Object roomid, Object uid) {
        try {

            //七日榜
            JSONObject sevenRank = HttpUtil.getResult("https://api.live.bilibili.com/rankdb/v1/RoomRank/webSevenRank?roomid=" + roomid + "&ruid=" + uid);
            JSONObject object = (JSONObject) sevenRank.get("data");
            List<Map<String, Object>> list = (List) object.get("list");
            if (list.size() > 0) {

            }

        } catch (Exception e) {

        }
    }


    /**
     * @param newGuardTab
     * @param oldGuardTab
     */
    public List<Map<String, Object>> compareListDataNotInInsert(List<Map<String, Object>> newGuardTab, List<Map<String, Object>> oldGuardTab) {
        List<Map<String, Object>> lists = new ArrayList<>();
        try {

            boolean b = true;

            for (Map<String, Object> one : newGuardTab) {

                int uidone = (int) one.get("uid");
                top:
                for (Map<String, Object> two : oldGuardTab) {

                    long uidtwo = (long) two.get("UID");

                    if (uidone == uidtwo) {
                        b = false;
                        break top;
                    }
                }

                if (b) {
                    lists.add(one);
                }
                b = true;
            }


        } catch (Exception e) {
            e.getMessage();
        }

        return lists;
    }


    /**
     * @param newGuardTab
     * @param oldGuardTab
     */
    public List<Integer> compareListDataNotInDelete(List<Map<String, Object>> newGuardTab, List<Map<String, Object>> oldGuardTab) {
        List<Integer> lists = new ArrayList<>();
        try {

            boolean b = true;
            for (Map<String, Object> one : oldGuardTab) {

                long uidone = (long) one.get("UID");

                top:
                for (Map<String, Object> two : newGuardTab) {

                    int uidtwo = (int) two.get("uid");

                    if (uidone == uidtwo) {
                        b = false;
                        break top;
                    }
                }

                if (b) {
                    lists.add((Integer) one.get("ID"));
                }

                b = true;
            }


        } catch (Exception e) {
            e.getMessage();
        }

        return lists;
    }

}
