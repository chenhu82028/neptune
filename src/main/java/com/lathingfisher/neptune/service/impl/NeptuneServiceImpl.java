package com.lathingfisher.neptune.service.impl;

import com.lathingfisher.neptune.mapper.EmpolyeeMapper;
import com.lathingfisher.neptune.service.NeptuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public EmpolyeeMapper empolyeeMapper;

    @Override
    public List<Map> selectAll() {
        return empolyeeMapper.selectAll();
    }
}
