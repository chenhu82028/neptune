package com.lathingfisher.neptune.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpolyeeMapper {

    int deleteByPrimaryKey(Integer emp_id);

    List<Map> selectAll();

}