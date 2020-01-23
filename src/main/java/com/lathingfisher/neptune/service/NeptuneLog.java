package com.lathingfisher.neptune.service;

/**
 * @author C.Hu
 * @version 1.0
 * @date 2020/1/24 1:37
 */
public interface NeptuneLog {
    void inertSearchLog(String requestURI, String type, String value, String addresses,String result);
}
