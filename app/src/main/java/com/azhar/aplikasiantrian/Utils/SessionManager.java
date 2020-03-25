package com.azhar.aplikasiantrian.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String KEY_PENGGUNA_ID = "id";
    public static final String KEY_PENGGUNA_USERNAME = "username";
    public static final String KEY_PENGGUNA_DOMAIN = "domain";
    public static final String KEY_PENGGUNA_LAYANAN = "layanan";
    public static final String KEY_PENGGUNA_LOCKET = "locket";
    public static final String KEY_PENGGUNA_LAYANAN_NAMA = "layanan_nama";
    public static final String KEY_PENGGUNA_LOKET_NAMA = "loket_nama";
    public static final String KEY_PENGGUNA_LAYANAN_AWALAN = "layanan_awalan";
    public static final String LOGGIN_STATUS = "sudahlogin";
    public static final String SHARE_NAME = "logginsession";

    private Context context;
    private final int MODE_PRIVATE = 0;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLogin(String PENGGUNA_USERNAME,
                          String domain,
                          String layanan,
                          String locket,
                          String nama_layanan,
                          String nama_loket,
                          String awalan_layanan) {
        editor.putBoolean(LOGGIN_STATUS, true);
        editor.putString(KEY_PENGGUNA_USERNAME, PENGGUNA_USERNAME);
        editor.putString(KEY_PENGGUNA_LAYANAN, layanan);
        editor.putString(KEY_PENGGUNA_LOCKET, locket);
        editor.putString(KEY_PENGGUNA_DOMAIN, domain);
        editor.putString(KEY_PENGGUNA_LAYANAN_NAMA, nama_layanan);
        editor.putString(KEY_PENGGUNA_LOKET_NAMA, nama_loket);
        editor.putString(KEY_PENGGUNA_LAYANAN_AWALAN, awalan_layanan);
         editor.commit();
    }

    public HashMap getDetailsLoggin() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_PENGGUNA_ID, sharedPreferences.getString(KEY_PENGGUNA_ID, null));
        map.put(KEY_PENGGUNA_USERNAME, sharedPreferences.getString(KEY_PENGGUNA_USERNAME, null));
        map.put(KEY_PENGGUNA_LAYANAN, sharedPreferences.getString(KEY_PENGGUNA_LAYANAN, null));
        map.put(KEY_PENGGUNA_LOCKET, sharedPreferences.getString(KEY_PENGGUNA_LOCKET, null));
        map.put(KEY_PENGGUNA_DOMAIN, sharedPreferences.getString(KEY_PENGGUNA_DOMAIN, null));
        map.put(KEY_PENGGUNA_LAYANAN_NAMA, sharedPreferences.getString(KEY_PENGGUNA_LAYANAN_NAMA, null));
        map.put(KEY_PENGGUNA_LOKET_NAMA, sharedPreferences.getString(KEY_PENGGUNA_LOKET_NAMA, null));
        map.put(KEY_PENGGUNA_LAYANAN_AWALAN, sharedPreferences.getString(KEY_PENGGUNA_LAYANAN_AWALAN, null));
        return map;
    }



    public void logout() {
        editor.clear();
        editor.commit();
    }

    public Boolean isLogin() {
        return sharedPreferences.getBoolean(LOGGIN_STATUS, false);
    }

}

