package com.icashgw.entity;

import com.icashgw.enums.StatusRequest;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "jsonRequest")
public class JsonRequest {
    private String json;
    private String token;
    private Date dateOfReceipt;
    private StatusRequest statusRequest;

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public StatusRequest getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(StatusRequest statusRequest) {
        this.statusRequest = statusRequest;
    }

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
