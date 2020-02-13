package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseCall {
    @SerializedName("status")
    private String status;
    @SerializedName("antrian")
    private String antrian;
    @SerializedName("data")
    private Call data;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAntrian() {
        return antrian;
    }

    public void setAntrian(String antrian) {
        this.antrian = antrian;
    }

    public Call getData() {
        return data;
    }

    public void setData(Call data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
