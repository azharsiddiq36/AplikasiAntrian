package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Layanan {
    @SerializedName("layanan_id")
    private String layananId;
    @SerializedName("layanan_nama")
    private String layananNama;
    @SerializedName("layanan_awalan")
    private String layananAwalan;
    @SerializedName("layanan_suara_nama")
    private String layananSuaraNama;
    @SerializedName("layanan_suara_awalan")
    private String layananSuaraAwalan;
    @SerializedName("layanan_date_created")
    private String layananDateCreated;

    public String getLayananId() {
        return layananId;
    }

    public void setLayananId(String layananId) {
        this.layananId = layananId;
    }

    public String getLayananNama() {
        return layananNama;
    }

    public void setLayananNama(String layananNama) {
        this.layananNama = layananNama;
    }

    public String getLayananAwalan() {
        return layananAwalan;
    }

    public void setLayananAwalan(String layananAwalan) {
        this.layananAwalan = layananAwalan;
    }

    public String getLayananSuaraNama() {
        return layananSuaraNama;
    }

    public void setLayananSuaraNama(String layananSuaraNama) {
        this.layananSuaraNama = layananSuaraNama;
    }

    public String getLayananSuaraAwalan() {
        return layananSuaraAwalan;
    }

    public void setLayananSuaraAwalan(String layananSuaraAwalan) {
        this.layananSuaraAwalan = layananSuaraAwalan;
    }

    public String getLayananDateCreated() {
        return layananDateCreated;
    }

    public void setLayananDateCreated(String layananDateCreated) {
        this.layananDateCreated = layananDateCreated;
    }
}
