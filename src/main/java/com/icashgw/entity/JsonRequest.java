package com.icashgw.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jsonRequest")
public class JsonRequest {
    private String json;
    private String token;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
