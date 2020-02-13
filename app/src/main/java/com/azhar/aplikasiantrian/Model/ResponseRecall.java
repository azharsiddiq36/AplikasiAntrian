package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseRecall {
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private Recall data;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Recall getData() {
        return data;
    }

    public void setData(Recall data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
