package com.icashgw.entity;

import com.icashgw.enums.TypeCashBox;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mapCashBox")
public class MapCashBox {
   // @Id
    private String clientId;
    private String token;
    private TypeCashBox type;
    private String inn;
    private String kpp;
    private List<HostCash> host;

    public void setType(TypeCashBox type) {
        this.type = type;
    }

    public MapCashBox(String inn, String kpp, String token) {
        this.clientId = inn+kpp;
        this.inn = inn;
        this.kpp = kpp;
        this.token = token;
    }

    public void setId(){
        this.clientId = inn+kpp;
    }
    public String getId(){
        return clientId;
    }
    public List<HostCash> getHost() {
        return host;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setHost(List<HostCash> host) {
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
