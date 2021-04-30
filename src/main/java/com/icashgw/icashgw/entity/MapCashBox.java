package com.icashgw.icashgw.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mapCashBox")
public class MapCashBox {
//    @Id
    private String token;

    private String organization;
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
