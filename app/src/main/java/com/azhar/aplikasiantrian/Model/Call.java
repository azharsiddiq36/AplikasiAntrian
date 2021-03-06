package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Call {
    @SerializedName("antrian_id")
    private String antrianId;
    @SerializedName("antrian_nomor")
    private String antrianNomor;
    @SerializedName("antrian_layanan_id")
    private String antrianLayananId;
    @SerializedName("antrian_loket_id")
    private Object antrianLoketId;
    @SerializedName("antrian_nomor_aktif")
    private Object antrianNomorAktif;
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

    public void setAntrianLoketId(Object antrianLoketId) {
        this.antrianLoketId = antrianLoketId;
    }

    public Object getAntrianNomorAktif() {
        return antrianNomorAktif;
    }

    public void setAntrianNomorAktif(Object antrianNomorAktif) {
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

}
