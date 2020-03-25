package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AntrianResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("data_active")
    private Antrian dataActive;
    @SerializedName("data_waiting")
    private Integer dataWaiting;

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



    public Antrian getDataActive() {
        return dataActive;
    }

    public void setDataActive(Antrian dataActive) {
        this.dataActive = dataActive;
    }

    public Integer getDataWaiting() {
        return dataWaiting;
    }

    public void setDataWaiting(Integer dataWaiting) {
        this.dataWaiting = dataWaiting;
    }
}
