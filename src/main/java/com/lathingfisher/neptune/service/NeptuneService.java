package com.lathingfisher.neptune.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/21 2:15
 */
public interface NeptuneService {

    List<Map> selectAll();

    void insertSevenRank(List<Map<String, Object>> list);

    void insertGuardTab(List<Map<String, Object>> top3);

    List<Map<String, Object>> selectByGuardTabRuid(Object uid);

    void deleteGuardTab(List<Long> lists);

    void insertUnionFans(Map<String, Object> stringObjectMap);

    List<Map<String, Object>> selectByRoomAdmin(Object roomid);

    void deleteRoomAdmin(List<Long> integers);

    void insertRoomAdmin(List<Map<String, Object>> mapList1);

    List<Map<String, Object>> selectSearch(String uid) throws IOException;

    void insertAnchorUser(Object anchorRoomid, Object anchorUname, Object anchorUid);

    List<Map<String, Object>> selectByMedalRank(Object list);

    void insertMedalRank(List<Map<String, Object>> mapList1);

    void deleteMedalRank(List<Long> integers);

    List<Map<String, Object>> searchAllModelRank();

    List<Map<String, Object>> searchModelRank(String value);

    List<Integer> tempSelect();

    void updateGuardTab(Map<String, Object> lists);

    List<Map<String, Object>> selectRoomAdmin(String uid);
}
