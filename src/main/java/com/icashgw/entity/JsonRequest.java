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
    private Date dateOfChange;

    public JsonRequest(String json, String token, Date dateOfReceipt, StatusRequest statusRequest, Date dateOfChange) {
        this.json = json;
        this.token = token;
        this.dateOfReceipt = dateOfReceipt;
        this.statusRequest = statusRequest;
        this.dateOfChange = dateOfChange;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
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
