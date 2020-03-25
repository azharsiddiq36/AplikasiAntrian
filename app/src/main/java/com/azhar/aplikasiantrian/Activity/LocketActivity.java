package com.azhar.aplikasiantrian.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.aplikasiantrian.Model.AlihanResponse;
import com.azhar.aplikasiantrian.Model.AntrianResponse;
import com.azhar.aplikasiantrian.Model.Layanan;
import com.azhar.aplikasiantrian.Model.ResponseCall;
import com.azhar.aplikasiantrian.Model.ResponseLayanan;
import com.azhar.aplikasiantrian.Model.ResponseRecall;
import com.azhar.aplikasiantrian.R;
import com.azhar.aplikasiantrian.Rest.QueueInterface;
import com.azhar.aplikasiantrian.Utils.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocketActivity extends AppCompatActivity {
    SessionManager sessionManager;
    HashMap<String, String> map;
    Handler handler;
    @BindView(R.id.tvSetting)
    TextView tvSetting;
    @BindView(R.id.tvLoket)
    TextView tvLoket;
    @BindView(R.id.tvCurrent)
    TextView tvCurrent;
    @BindView(R.id.tvTotal)
    TextView tvTotal;

    QueueInterface queueInterface;
    String TAG = "kambing";
    private static Retrofit retrofit = null;
    public static String BASE_URL = "";
    String currentloket;
    String currentLayanan;
    @BindView(R.id.btnAlihkan)
    Button btnAlihkan;
    SweetAlertDialog pDialog;
    String layanan[];
    HashMap<String, String> services;
    ArrayList<Layanan> list_layanan = new ArrayList<>();
    String currentnumber;
    String currenttext;
    String currentsuaraawalan;
    String suara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loket);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(LocketActivity.this);
        map = sessionManager.getDetailsLoggin();
        currentloket = map.get(sessionManager.KEY_PENGGUNA_LOCKET);
        currentLayanan = map.get(sessionManager.KEY_PENGGUNA_LAYANAN);
        tvSetting.setText("Selamat Bertugas " + map.get(sessionManager.KEY_PENGGUNA_USERNAME));
        tvLoket.setText("" + map.get(sessionManager.KEY_PENGGUNA_LAYANAN_NAMA) + "\n" + "(" + map.get(sessionManager.KEY_PENGGUNA_LOKET_NAMA) + ")");
        handler = new Handler();
        if (sessionManager.isLogin()) {
            BASE_URL = "http://" + map.get(sessionManager.KEY_PENGGUNA_DOMAIN) + "/";
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            queueInterface = retrofit.create(QueueInterface.class);
            Call<ResponseLayanan> responseLayananCall = queueInterface.getListServices();
            responseLayananCall.enqueue(new Callback<ResponseLayanan>() {
                @Override
                public void onResponse(Call<ResponseLayanan> call, Response<ResponseLayanan> response) {
                    services = new HashMap<>();
                    if (response.body().getStatus() == 200) {
                        list_layanan = (ArrayList<Layanan>) response.body().getData();
                        layanan = new String[list_layanan.size()];
                        for (int i = 0; i < layanan.length; i++) {
                            services.put(list_layanan.get(i).getLayananNama(), list_layanan.get(i).getLayananId());
                            layanan[i] = list_layanan.get(i).getLayananNama();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseLayanan> call, Throwable throwable) {
                    Log.d(TAG, "onFailure: " + throwable.toString());
                }
            });
            m_Runnable.run();
        } else {
            startActivity(new Intent(LocketActivity.this, MainActivity.class).
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(m_Runnable);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        handler.postDelayed(m_Runnable, 1000);
    }

    @OnClick(R.id.btnCall)
    protected void btnCall(View view) {
        restCall(currentloket);
    }

    @OnClick(R.id.btnAlihkan)
    protected void btnAlihkan(View view) {
        Log.d(TAG, "btnAlihkan: " + layanan[0]);
        LayoutInflater layoutInflater;
        final PopupWindow popupWindow;
        layoutInflater = (LayoutInflater) getApplication().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.detail_alihan, null);
        popupWindow = new PopupWindow(container, 800, 1300, true);
        ListView lvLayanan = container.findViewById(R.id.lv1st);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, layanan);
        lvLayanan.setAdapter(adapter);
        lvLayanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alihkan(layanan[position]);
                popupWindow.dismiss();
            }
        });
        popupWindow.showAsDropDown(btnAlihkan);
    }

    private void alihkan(String s) {
        currentsuaraawalan = "assets/audios/static/" + map.get(sessionManager.KEY_PENGGUNA_LAYANAN_AWALAN).toLowerCase() + ".MP3";
        String replace = s.toLowerCase().replace(" ", "-");
        suara = "assets/audios/static/di-" + replace + ".MP3";
        Call<AlihanResponse> alihanResponseCall = queueInterface.getAlihan(services.get(s), currentnumber, currenttext, currentsuaraawalan, suara);
        alihanResponseCall.enqueue(new Callback<AlihanResponse>() {
            @Override
            public void onResponse(Call<AlihanResponse> call, Response<AlihanResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(LocketActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AlihanResponse> call, Throwable throwable) {
                Toast.makeText(LocketActivity.this, "Ada kesalahan", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick(R.id.btnRecall)
    protected void btnRecall(View view) {
        restRecall(currentloket);
    }

    @OnClick(R.id.tvSetting)
    protected void tvSetting(View view) {
        Intent gotosetting = new Intent(LocketActivity.this, MainActivity.class);
        startActivity(gotosetting);
    }

    /*
        Semua perintah Call ada di bagian ini
     */

    private void restCall(String s) {
        Call<ResponseCall> data = queueInterface.restCall(s);
        data.enqueue(new Callback<ResponseCall>() {
            @Override
            public void onResponse(Call<ResponseCall> call, Response<ResponseCall> response) {
                if (response.body().getStatus().equals("200")) {
                    Toast.makeText(LocketActivity.this, "Berhasil Memanggil Atrian", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LocketActivity.this, "Antrian Habis", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseCall> call, Throwable t) {
                Log.d("Kambing", "onFailure: " + t.toString());
            }
        });
    }

    /*
        Semua Perintah Recall ada dibagian ini
     */

    private void restRecall(String id) {
        Call<ResponseRecall> data = queueInterface.restRecall(id);
        data.enqueue(new Callback<ResponseRecall>() {
            @Override
            public void onResponse(Call<ResponseRecall> call, Response<ResponseRecall> response) {
                if (response.body().getStatus().equals("200")) {
                    Toast.makeText(LocketActivity.this, "Memanggil Nomor Urut" + response.body().getData().getAntrianNomor(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LocketActivity.this, "Antrian Habis", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRecall> call, Throwable t) {
                Log.d("Kambing", "onFailure: " + t.toString());
            }
        });
    }

    /*
        Pengaturan untuk merefresh antrian
     */

    private final Runnable m_Runnable = new Runnable() {
        public void run() {
            loadAntrian();
            LocketActivity.this.handler.postDelayed(m_Runnable, 500);
        }

    };

    private void loadAntrian() {
        Call<AntrianResponse> antrianResponseCall = queueInterface.getQueueList(currentLayanan);
        antrianResponseCall.enqueue(new Callback<AntrianResponse>() {
            @Override
            public void onResponse(Call<AntrianResponse> call, Response<AntrianResponse> response) {
                if (response.body().getStatus() == 200) {
                    tvTotal.setText("Tersisa " + response.body().getDataWaiting() + " Antrian Lagi");
                    if (response.body().getDataActive().getAntrianStatus().equals("habis")) {
                        tvCurrent.setText(map.get(sessionManager.KEY_PENGGUNA_LAYANAN_AWALAN) + "-000");
                    } else {
                        currentnumber = response.body().getDataActive().getAntrianNomor();
                        if (response.body().getDataActive().getAntrianNomorAlihan() == null) {
                            String angka = null;
                            if (Integer.parseInt(response.body().getDataActive().getAntrianNomor()) < 10) {
                                angka = "00" + response.body().getDataActive().getAntrianNomor();
                            } else if (Integer.parseInt(response.body().getDataActive().getAntrianNomor()) < 100 && Integer.parseInt(response.body().getDataActive().getAntrianNomor()) >= 10)
                                angka = "0" + response.body().getDataActive().getAntrianNomor();
                            else {
                                angka = response.body().getDataActive().getAntrianNomor();
                            }
                            currenttext = map.get(sessionManager.KEY_PENGGUNA_LAYANAN_AWALAN) + "-" + angka;

                        } else {
                            currenttext = response.body().getDataActive().getAntrianNomorAlihan().toString();
                        }
                        tvCurrent.setText(currenttext);
                    }

                }
            }

            @Override
            public void onFailure(Call<AntrianResponse> call, Throwable throwable) {

            }
        });
    }

}

