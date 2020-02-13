package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Current> data = null;
    @SerializedName("sekarang")
    private Sekarang sekarang;
    @SerializedName("total")
    private Integer total;
    @SerializedName("sisa")
    private Integer sisa;

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

    public List<Current> getData() {
        return data;
    }

    public void setData(List<Current> data) {
        this.data = data;
    }

    public Sekarang getSekarang() {
        return sekarang;
    }

    public void setSekarang(Sekarang sekarang) {
        this.sekarang = sekarang;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSisa() {
        return sisa;
    }

    public void setSisa(Integer sisa) {
        this.sisa = sisa;
    }
}
