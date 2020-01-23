package com.lathingfisher.neptune.service.impl;

import com.lathingfisher.neptune.dao.NeptuneLogMapper;
import com.lathingfisher.neptune.service.NeptuneLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/24 1:37
 */
@Service
public class NeptuneLogImpl implements NeptuneLog {

    @Autowired
    public NeptuneLogMapper neptuneLogMapper;

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void inertSearchLog(String requestURI, String type, String value, String addresses,String result) {

        String time = sf.format(new Date());

        neptuneLogMapper.inertSearchLog(requestURI, type, value, addresses,time,result);

    }
}
