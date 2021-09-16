package com.icashgw.entity;

import com.icashgw.enums.StatusRequest;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "jsonRequest")
public class JsonRequest {
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    @Id
    private ObjectId _id;
    private String path;
    private String json;
    private String token;
    private Date dateOfReceipt;
    private StatusRequest statusRequest;
    private Date dateOfChange;
    private String request;
    private boolean connectionTimeout;



    public JsonRequest(String json, String path, String token, Date dateOfReceipt, StatusRequest statusRequest, Date dateOfChange) {
        this.json = json;
        this.path = path;
        this.token = token;
        this.dateOfReceipt = dateOfReceipt;
        this.statusRequest = statusRequest;
        this.dateOfChange = dateOfChange;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
    public String getRequest() {
        return request;
    }
}
