package com.lathingfisher.neptune.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lathingfisher.neptune.dao.NeptuneMapper;
import com.lathingfisher.neptune.service.NeptuneService;
import com.lathingfisher.neptune.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/21 2:15
 */
@Service
@SuppressWarnings("all")
public class NeptuneServiceImpl implements NeptuneService {

    @Autowired
    public NeptuneMapper neptuneMapper;

    @Override
    public List<Map> selectAll() {
        return neptuneMapper.selectAll();
    }

    @Override
    public void insertSevenRank(List<Map<String, Object>> list) {
        neptuneMapper.insertSevenRank(list);
    }

    @Override
    public void insertGuardTab(List<Map<String, Object>> top3) {
        neptuneMapper.insertGuardTab(top3);
    }

    @Override
    public List<Map<String, Object>> selectByGuardTabRuid(Object uid) {
        return neptuneMapper.selectByGuardTabRuid(uid);
    }

    @Override
    public List<Map<String, Object>> selectByRoomAdmin(Object roomid) {
        return neptuneMapper.selectByRoomAdmin(roomid);
    }

    @Override
    public void insertUnionFans(Map<String, Object> stringObjectMap) {
        neptuneMapper.insertUnionFans(stringObjectMap);
    }

    @Override
    public void deleteGuardTab(List<Integer> lists) {
        neptuneMapper.deleteGuardTab(lists);
    }

    @Override
    public void insertRoomAdmin(List<Map<String, Object>> mapList1) {
        neptuneMapper.insertRoomAdmin(mapList1);
    }

    @Override
    public void deleteRoomAdmin(List<Integer> integers) {
        neptuneMapper.deleteRoomAdmin(integers);
    }

    @Override
    public List<Map<String, Object>> selectSearch(String uid) throws IOException {


        JSONObject result = HttpUtil.getResult("https://api.bilibili.com/x/web-interface/search/type?context=&keyword=拜托了_喵大人&page=1&order=&category_id=&duration=&user_type=&order_sort=&tids_1=&tids_2=&search_type=bili_user&changing=mid&__refresh__=true&__reload__=false&highlight=1&single_column=0&jsonp=jsonp&callback=__jp0");
        System.out.println(result);

        List<Map<String, Object>> search = neptuneMapper.selectSearch(uid);

        return null;
    }
}
