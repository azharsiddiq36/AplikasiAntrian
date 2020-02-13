package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Recall {
    @SerializedName("panggilan_id")
    private String panggilanId;
    @SerializedName("panggilan_antrian")
    private String panggilanAntrian;
    @SerializedName("panggilan_loket")
    private String panggilanLoket;
    @SerializedName("panggilan_updated")
    private String panggilanUpdated;
    @SerializedName("loket_id")
    private String loketId;
    @SerializedName("loket_nama")
    private String loketNama;
    @SerializedName("loket_nomor")
    private String loketNomor;
    @SerializedName("loket_layanan_id")
    private String loketLayananId;
    @SerializedName("loket_date_created")
    private String loketDateCreated;
    @SerializedName("layanan_id")
    private String layananId;
    @SerializedName("layanan_nama")
    private String layananNama;
    @SerializedName("layanan_date_created")
    private String layananDateCreated;
    @SerializedName("0")
    private String _0;

    public String getPanggilanId() {
        return panggilanId;
    }

    public void setPanggilanId(String panggilanId) {
        this.panggilanId = panggilanId;
    }

    public String getPanggilanAntrian() {
        return panggilanAntrian;
    }

    public void setPanggilanAntrian(String panggilanAntrian) {
        this.panggilanAntrian = panggilanAntrian;
    }

    public String getPanggilanLoket() {
        return panggilanLoket;
    }

    public void setPanggilanLoket(String panggilanLoket) {
        this.panggilanLoket = panggilanLoket;
    }

    public String getPanggilanUpdated() {
        return panggilanUpdated;
    }

    public void setPanggilanUpdated(String panggilanUpdated) {
        this.panggilanUpdated = panggilanUpdated;
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

    public String getLayananDateCreated() {
        return layananDateCreated;
    }

    public void setLayananDateCreated(String layananDateCreated) {
        this.layananDateCreated = layananDateCreated;
    }

    public String get_0() {
        return _0;
    }

    public void set_0(String _0) {
        this._0 = _0;
    }
}
