package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseRecall {
    @SerializedName("status")
    private String status;
    @SerializedName("antrian")
    private String antrian;
    @SerializedName("data")
    private Recall data;
    @SerializedName("update")
    private Integer update;
    @SerializedName("message")
    private String message;

    public String getAntrian() {
        return antrian;
    }

    public void setAntrian(String antrian) {
        this.antrian = antrian;
    }

    public Integer getUpdate() {
        return update;
    }

    public void setUpdate(Integer update) {
        this.update = update;
    }

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
