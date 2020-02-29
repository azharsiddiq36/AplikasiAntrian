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
    public static final String KEY_PENGGUNA_LOKET = "loket";
    public static final String KEY_PENGGUNA_LOKET2 = "loket2";
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
                          String loket,
                          String loket2) {
        editor.putBoolean(LOGGIN_STATUS, true);
        editor.putString(KEY_PENGGUNA_USERNAME, PENGGUNA_USERNAME);
        editor.putString(KEY_PENGGUNA_LOKET, loket);
        editor.putString(KEY_PENGGUNA_LOKET2, loket2);
        editor.putString(KEY_PENGGUNA_DOMAIN, domain);
         editor.commit();
    }

    public HashMap getDetailsLoggin() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_PENGGUNA_ID, sharedPreferences.getString(KEY_PENGGUNA_ID, null));
        map.put(KEY_PENGGUNA_USERNAME, sharedPreferences.getString(KEY_PENGGUNA_USERNAME, null));
        map.put(KEY_PENGGUNA_LOKET, sharedPreferences.getString(KEY_PENGGUNA_LOKET, null));
        map.put(KEY_PENGGUNA_LOKET2, sharedPreferences.getString(KEY_PENGGUNA_LOKET2, null));
        map.put(KEY_PENGGUNA_DOMAIN, sharedPreferences.getString(KEY_PENGGUNA_DOMAIN, null));
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

