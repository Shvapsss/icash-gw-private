package com.icashgw.icashgw.entity;

import org.springframework.data.annotation.Id;

import java.util.List;


public class MapCashBox {
    @Id
    private String token;
    private List<String> host;

    public List<String> getHost() {
        return host;
    }

    public void setHost(List<String> host) {
        this.host = host;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
