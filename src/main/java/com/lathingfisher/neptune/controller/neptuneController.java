package com.lathingfisher.neptune.controller;

import com.alibaba.fastjson.JSONObject;
import com.lathingfisher.neptune.service.NeptuneLog;
import com.lathingfisher.neptune.service.NeptuneService;
import com.lathingfisher.neptune.util.AddressUtils;
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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Autowired
    public NeptuneLog neptuneLog;

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Pattern pattern = Pattern.compile("[^0-9]");

    @RequestMapping("/neptune")
    @ResponseBody
    public Map<String, Object> neptune(String type, String value, HttpServletRequest request) {

        Map<String, Object> resultData = new HashMap<>(2);
        List<Map<String, Object>> mapList = null;

        try {

            if ("1".equals(type)) {
                String uid = null;

                if (value.contains("UID")) {

                    uid = getUidToUID(value, uid);

                } else {

                    uid = geUid(value);
                }

                if ("拜托了_喵大人".equals(value) || "301507852".equals(uid)) {
                    resultData.put("result", "errormsg");
                    resultData.put("data", "哎呀~~~别看了,我真的一条都没有");
                    saveLog(type, value, request, "error");
                    return resultData;
                }

                if (uid == null) {
                    resultData.put("result", "error");
                    saveLog(type, value, request, "error");
                    return resultData;
                }
                mapList = neptuneService.selectSearch(uid);

                resultData.put("data", mapList);
                resultData.put("result", "success");
                resultData.put("type", 1);
                saveLog(type, value, request, "success");
            } else if ("2".equals(type)) {

                if ("".equals(value.trim())) {
                    mapList = neptuneService.searchAllModelRank();
                } else {
                    mapList = neptuneService.searchModelRank(value.trim());
                }
                resultData.put("result", "success");
                resultData.put("data", mapList);
                resultData.put("type", 2);
                saveLog(type, value, request, "success");
            } else if ("3".equals(type)) {
                resultData.put("result", "error");
                saveLog(type, value, request, "error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultData.put("result", "error");
        }

        return resultData;
    }

    //    @RequestMapping("/testNeptune")
//    @Scheduled(cron = "0 */60 * * * ?")
//    @Scheduled(initialDelay = 1000, fixedRate = 4200000)
    public void timedTask() {

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

            for (Map<String, Object> map : maps) {
                roomid = map.get("roomid");
                uid = map.get("uid");
                if (roomid != null && uid != null) {

                    //舰长
                    getGuardTab(roomid, uid);

                    //获取主播信息
                    getAnchor(roomid, uid);

                    //友爱社
                    getUnionFans(roomid, uid);

                    //房管
                    getRoomAdmin(roomid, uid);

                    //粉丝榜
                    getMedalRank(roomid, uid);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("全部用时:" + (System.currentTimeMillis() - start) / 1000);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 3600000)
    public void aaa() {
//        https://search.bilibili.com/all?keyword=UID%3A225740
        //https://live.bilibili.com/15200000
        //https://api.live.bilibili.com/xlive/web-room/v1/index/getInfoByRoom?room_id=111111
        try {

            //1033 --- 5001

            List<Integer> integers = neptuneService.tempSelect();

            for (int i = 1302499; i <= 15200000; i++) {

                JSONObject result = HttpUtil.getResult("https://api.live.bilibili.com/xlive/web-room/v1/index/getInfoByRoom?room_id=" + i);// 获取连接

                System.out.println("房间号:" + i);

                Object data = result.get("data");

                if (data != null) {
                    JSONObject data1 = (JSONObject) data;
                    Map<String, Object> room_info = (Map) data1.get("room_info");
//                    System.out.println(room_info);
                    Object room_id = room_info.get("room_id");
                    Object uid = room_info.get("uid");
                    if (room_id != null && uid != null) {

                        getMedalRank(room_id, uid);
                        getAnchor(room_id, uid);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUidToUID(String value, String uid) {
        try {
            Matcher matcher = pattern.matcher(value);
            String trim = matcher.replaceAll("").trim();
            if (trim != null && !"".equals(trim)) {
                uid = trim;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uid;
    }

    /**
     * 保存查询结果
     *
     * @param type
     * @param value
     * @param request
     * @param result
     */
    private void saveLog(String type, String value, HttpServletRequest request, String result) {
        try {
            String requestURI = request.getRemoteAddr();
            String addresses = null;

            if (requestURI != null && !"".equals(requestURI)) {
                addresses = AddressUtils.getAddresses("ip=" + requestURI, "utf-8");
            }

            neptuneLog.inertSearchLog(requestURI, type, value, addresses, result);

        } catch (Exception e) {

        }
    }

    private void getMedalRank(Object roomid, Object uid) throws IOException {
        JSONObject medalRank = HttpUtil.getResult("https://api.live.bilibili.com/rankdb/v1/RoomRank/webMedalRank?roomid=" + roomid + "&ruid=" + uid);
        JSONObject dataMedalRank = (JSONObject) medalRank.get("data");
        List<Map<String, Object>> list = (List) dataMedalRank.get("list");

        if (list.size() > 0) {

            for (Map<String, Object> stringObjectMap : list) {

                stringObjectMap.put("roomid", roomid);
                stringObjectMap.put("ruid", uid);

            }

            List<Map<String, Object>> mapList = neptuneService.selectByMedalRank(roomid);
            if (mapList.size() > 0) {

                List<Map<String, Object>> mapList1 = compareListDataNotInInsert(list, mapList);
                if (mapList1.size() > 0) {

                    neptuneService.insertMedalRank(mapList1);
                    System.out.println("进入一批：");
                }

                List<Long> integers = compareListDataNotInDelete(list, mapList);
                if (integers.size() > 0) {

                    neptuneService.deleteMedalRank(integers);
                }


            } else {

                neptuneService.insertMedalRank(list);
                System.out.println("进入一批：");
            }

        }
    }

    private void getAnchor(Object roomid, Object uid) throws IOException {

        try {
            JSONObject anchorMassage = HttpUtil.getResult("https://api.live.bilibili.com/room_ex/v1/RoomNews/get?roomid=" + roomid + "&uid=" + uid);
            Map<String, Object> anchordata = (Map) anchorMassage.get("data");
            if (anchordata != null) {
                if (anchordata.size() > 0) {

                    Object anchorRoomid = anchordata.get("roomid");

                    Object anchorUname = anchordata.get("uname");
                    Object anchorUid = anchordata.get("uid");
                    if (anchorUid != null) {
                        String string = String.valueOf(anchorUid);
                        if ("".equals(string)) {
                            anchorUid = uid;
                        }
                    }
                    neptuneService.insertAnchorUser(anchorRoomid, anchorUname, anchorUid);
                }
            }
        } catch (Exception e) {
        }
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

                List<Long> integers = compareListDataNotInDelete(data2, mapList);
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

                //更新舰长等级
                compareListDataNotInInsertCheck(top3,mapList);


                List<Long> integers = compareListDataNotInDelete(top3, mapList);

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

    private String geUid(String uname) throws IOException {
        Connection con = Jsoup.connect("http://search.bilibili.com/upuser?keyword=" + uname);// 获取连接

        Response rs = con.execute();// 获取响应

        Document d1 = Jsoup.parse(rs.body());// 转换为Dom树

        String integer = null;
        List<Element> et = d1.select("a.face-img");

        if (et.size() > 0) {

            Element element = et.get(0);
            String href = element.attr("href");

            if (href != null) {
                Matcher matcher = pattern.matcher(href);
                integer = matcher.replaceAll("").trim();
            }

        }

        return integer;
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
    public List<Map<String, Object>> compareListDataNotInInsertCheck(List<Map<String, Object>> newGuardTab, List<Map<String, Object>> oldGuardTab) {
        List<Map<String, Object>> lists = new ArrayList<>();
        String face;
        String username;
        String FACE;
        String USERNAME;

        try {

            for (Map<String, Object> one : newGuardTab) {

                int uidone = (int) one.get("uid");
                int guard_level = (int) one.get("guard_level");
                face = (String) one.get("face");
                username = (String) one.get("username");

                top:for (Map<String, Object> two : oldGuardTab) {

                    long uidtwo = (long) two.get("UID");
                    int GUARD_LEVEL = (int) two.get("GUARD_LEVEL");
                    FACE = (String) two.get("FACE");
                    USERNAME = (String) two.get("USERNAME");

                    if (uidone == uidtwo) {

                        if (guard_level != GUARD_LEVEL || !face.equals(FACE) || !username.equals(USERNAME)) {
                            one.put("id", two.get("ID"));
                            lists.add(one);
                            break top;
                        }
                    }
                }
            }

            if (lists.size()>0) {

                for (Map<String, Object> list : lists) {

                    neptuneService.updateGuardTab(list);
                }

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
    public List<Long> compareListDataNotInDelete(List<Map<String, Object>> newGuardTab, List<Map<String, Object>> oldGuardTab) {
        List<Long> lists = new ArrayList<>();
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
                    lists.add((long) one.get("ID"));
                }

                b = true;
            }


        } catch (Exception e) {
            e.getMessage();
        }

        return lists;
    }

}
