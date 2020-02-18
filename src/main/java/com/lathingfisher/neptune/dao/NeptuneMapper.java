package com.lathingfisher.neptune.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/20 23:19
 */
@Mapper
public interface NeptuneMapper {

    List<Map> selectAll();

    void insertSevenRank(@Param("list") List<Map<String, Object>> list);

    void insertGuardTab(@Param("list") List<Map<String, Object>> top3);

    List<Map<String, Object>> selectByGuardTabRuid(@Param("ruid") Object uid);

    void deleteGuardTab(@Param("list") List<Long> list);

    void insertUnionFans(@Param("fans") Map<String, Object> stringObjectMap);

    List<Map<String, Object>> selectByRoomAdmin(@Param("ruid")Object roomid);

    void deleteRoomAdmin(@Param("list")List<Long> integers);

    void insertRoomAdmin(@Param("list") List<Map<String, Object>> mapList1);

    List<Map<String, Object>> selectSearch(@Param("uid") String uid);

    void insertAnchorUser(@Param("roomid")String anchorRoomid,@Param("uname") String anchorUname,@Param("uid") String anchorUid);

    List<Map<String, Object>> selectByMedalRank(@Param("roomid") Object list);

    void insertMedalRank(@Param("list") List<Map<String, Object>> mapList1);

    void deleteMedalRank(@Param("list") List<Long> integers);

    List<Map<String, Object>> searchAllModelRank();

    List<Map<String, Object>> searchModelRank(@Param("value") String value);

    List<Integer> tempSelect();

    void updateGuardTab(@Param("list") Map<String, Object> lists);

    List<Map<String, Object>> selectRoomAdmin(@Param("uid") String uid);

}
