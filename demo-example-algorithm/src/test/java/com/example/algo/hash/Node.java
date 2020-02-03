package com.example.algo.hash;

import lombok.Data;

import java.util.Map;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/21 15:00
 * @blame 仓储开发组
 **/
public class Node {

    private String domain;
    private String ip;
    private Map<String, Object> data;


    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public <T> void put(String key, T value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public <T> T get(String key) {
        return (T) data.get(key);
    }


    @Override
    public String toString() {
        return "Node{" +
                "domain='" + domain + '\'' +
                ", ip='" + ip + '\'' +
                ", data=" + data +
                '}';
    }
}
