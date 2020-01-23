package com.lathingfisher.neptune.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/24 1:39
 */
@Mapper
public interface NeptuneLogMapper {
    void inertSearchLog(@Param("ip") String requestURI,@Param("type") String type,@Param("value") String value,@Param("address") String addresses, @Param("date")String time,@Param("result")String result);
}
