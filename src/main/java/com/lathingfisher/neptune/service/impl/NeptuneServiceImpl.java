package com.lathingfisher.neptune.service.impl;

import com.lathingfisher.neptune.dao.NeptuneMapper;
import com.lathingfisher.neptune.service.NeptuneService;
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

        return neptuneMapper.selectSearch(uid);
    }

    @Override
    public void insertAnchorUser(Object anchorRoomid, Object anchorUname, Object anchorUid) {

        String roomid = null;
        String uname = null;
        String uid = null;

        if (anchorRoomid != null) {
            roomid = String.valueOf(anchorRoomid);
        }
        if (anchorUname != null) {
            uname = String.valueOf(anchorUname);
        }
        if (anchorUid != null && !"".equals(anchorUid )) {
            uid = String.valueOf(anchorUid);
        }

        neptuneMapper.insertAnchorUser(roomid,uname,uid);
    }

    @Override
    public List<Map<String, Object>> selectByMedalRank(Object list) {
        return neptuneMapper.selectByMedalRank(list);
    }

    @Override
    public void insertMedalRank(List<Map<String, Object>> mapList1) {
        neptuneMapper.insertMedalRank(mapList1);
    }

    @Override
    public void deleteMedalRank(List<Integer> integers) {
        neptuneMapper.deleteMedalRank(integers);
    }

    @Override
    public List<Map<String, Object>> searchAllModelRank() {
        return neptuneMapper.searchAllModelRank();
    }

    @Override
    public List<Map<String, Object>> searchModelRank(String value) {
        return neptuneMapper.searchModelRank(value);
    }
}
