package com.icashgw.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mapCashBox")
public class MapCashBox {
    @Id
    private String id;
    private String token;
    private String inn;
    private String kpp;
    private String host;

    public MapCashBox(String inn, String kpp, String token) {
        this.id = inn+kpp;
        this.inn = inn;
        this.kpp = kpp;
        this.token = token;
    }

    public void setId(){
        this.id = inn+kpp;
    }
    public String getId(){
        return id;
    }
    public String getHost() {
        return host;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
