package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Sekarang {
    @SerializedName("antrian_id")
    private String antrianId;
    @SerializedName("antrian_nomor")
    private String antrianNomor;
    @SerializedName("antrian_layanan_id")
    private String antrianLayananId;
    @SerializedName("antrian_loket_id")
    private String antrianLoketId;
    @SerializedName("antrian_date_created")
    private String antrianDateCreated;
    @SerializedName("antrian_status")
    private String antrianStatus;
    @SerializedName("layanan_id")
    private String layananId;
    @SerializedName("layanan_nama")
    private String layananNama;
    @SerializedName("layanan_awalan")
    private String layananAwalan;
    @SerializedName("layanan_date_created")
    private String layananDateCreated;

    public String getAntrianId() {
        return antrianId;
    }

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

    public String getLayananDateCreated() {
        return layananDateCreated;
    }

    public void setLayananDateCreated(String layananDateCreated) {
        this.layananDateCreated = layananDateCreated;
    }

    public void setAntrianId(String antrianId) {
        this.antrianId = antrianId;
    }

    public String getAntrianNomor() {
        return antrianNomor;
    }

    public void setAntrianNomor(String antrianNomor) {
        this.antrianNomor = antrianNomor;
    }

    public String getAntrianLayananId() {
        return antrianLayananId;
    }

    public void setAntrianLayananId(String antrianLayananId) {
        this.antrianLayananId = antrianLayananId;
    }

    public String getAntrianLoketId() {
        return antrianLoketId;
    }

    public void setAntrianLoketId(String antrianLoketId) {
        this.antrianLoketId = antrianLoketId;
    }

    public String getAntrianDateCreated() {
        return antrianDateCreated;
    }

    public void setAntrianDateCreated(String antrianDateCreated) {
        this.antrianDateCreated = antrianDateCreated;
    }

    public String getAntrianStatus() {
        return antrianStatus;
    }

    public void setAntrianStatus(String antrianStatus) {
        this.antrianStatus = antrianStatus;
    }
}
