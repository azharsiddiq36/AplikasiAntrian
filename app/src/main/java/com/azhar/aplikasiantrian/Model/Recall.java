package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Recall {

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
    @SerializedName("loket_id")
    private String loketId;
    @SerializedName("loket_nama")
    private String loketNama;
    @SerializedName("loket_alias")
    private String loketAlias;
    @SerializedName("loket_petugas")
    private String loketPetugas;
    @SerializedName("loket_nomor")
    private String loketNomor;
    @SerializedName("loket_layanan_id")
    private String loketLayananId;
    @SerializedName("loket_waktu_panggilan")
    private String loketWaktuPanggilan;
    @SerializedName("loket_date_created")
    private String loketDateCreated;
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

    public String getLoketAlias() {
        return loketAlias;
    }

    public void setLoketAlias(String loketAlias) {
        this.loketAlias = loketAlias;
    }

    public String getLoketPetugas() {
        return loketPetugas;
    }

    public void setLoketPetugas(String loketPetugas) {
        this.loketPetugas = loketPetugas;
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

    public String getLoketId() {
        return loketId;
    }

    public void setLoketId(String loketId) {
        this.loketId = loketId;
    }

    public String getLoketNama() {
        return loketNama;
    }

    public void setLoketNama(String loketNama) {
        this.loketNama = loketNama;
    }

    public String getLoketNomor() {
        return loketNomor;
    }

    public void setLoketNomor(String loketNomor) {
        this.loketNomor = loketNomor;
    }

    public String getLoketLayananId() {
        return loketLayananId;
    }

    public void setLoketLayananId(String loketLayananId) {
        this.loketLayananId = loketLayananId;
    }

    public String getLoketWaktuPanggilan() {
        return loketWaktuPanggilan;
    }

    public void setLoketWaktuPanggilan(String loketWaktuPanggilan) {
        this.loketWaktuPanggilan = loketWaktuPanggilan;
    }

    public String getLoketDateCreated() {
        return loketDateCreated;
    }

    public void setLoketDateCreated(String loketDateCreated) {
        this.loketDateCreated = loketDateCreated;
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
}
