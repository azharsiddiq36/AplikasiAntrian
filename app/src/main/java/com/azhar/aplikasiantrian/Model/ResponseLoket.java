package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLoket {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Loket> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Loket> getData() {
        return data;
    }

    public void setData(List<Loket> data) {
        this.data = data;
    }
}
