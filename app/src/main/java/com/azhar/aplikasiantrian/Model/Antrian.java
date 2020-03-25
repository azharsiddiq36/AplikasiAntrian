package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Antrian {
    @SerializedName("antrian_id")
    private String antrianId;
    @SerializedName("antrian_nomor")
    private String antrianNomor;
    @SerializedName("antrian_layanan_id")
    private String antrianLayananId;
    @SerializedName("antrian_loket_id")
    private String antrianLoketId;
    @SerializedName("antrian_nomor_aktif")
    private String antrianNomorAktif;
    @SerializedName("antrian_jenis_panggilan")
    private String antrianJenisPanggilan;
    @SerializedName("antrian_nomor_alihan")
    private Object antrianNomorAlihan;
    @SerializedName("antrian_suara_alihan_prefix")
    private Object antrianSuaraAlihanPrefix;
    @SerializedName("antrian_suara_alihan")
    private Object antrianSuaraAlihan;
    @SerializedName("antrian_date_created")
    private String antrianDateCreated;
    @SerializedName("antrian_status")
    private String antrianStatus;

    public String getAntrianId() {
        return antrianId;
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

    public String getAntrianNomorAktif() {
        return antrianNomorAktif;
    }

    public void setAntrianNomorAktif(String antrianNomorAktif) {
        this.antrianNomorAktif = antrianNomorAktif;
    }

    public String getAntrianJenisPanggilan() {
        return antrianJenisPanggilan;
    }

    public void setAntrianJenisPanggilan(String antrianJenisPanggilan) {
        this.antrianJenisPanggilan = antrianJenisPanggilan;
    }

    public Object getAntrianNomorAlihan() {
        return antrianNomorAlihan;
    }

    public void setAntrianNomorAlihan(Object antrianNomorAlihan) {
        this.antrianNomorAlihan = antrianNomorAlihan;
    }

    public Object getAntrianSuaraAlihanPrefix() {
        return antrianSuaraAlihanPrefix;
    }

    public void setAntrianSuaraAlihanPrefix(Object antrianSuaraAlihanPrefix) {
        this.antrianSuaraAlihanPrefix = antrianSuaraAlihanPrefix;
    }

    public Object getAntrianSuaraAlihan() {
        return antrianSuaraAlihan;
    }

    public void setAntrianSuaraAlihan(Object antrianSuaraAlihan) {
        this.antrianSuaraAlihan = antrianSuaraAlihan;
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
