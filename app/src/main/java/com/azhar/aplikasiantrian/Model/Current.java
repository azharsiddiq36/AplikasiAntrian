package com.azhar.aplikasiantrian.Model;

import com.google.gson.annotations.SerializedName;

public class Current {
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
}