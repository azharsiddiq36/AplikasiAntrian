package com.azhar.aplikasiantrian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.aplikasiantrian.Model.CurrentResponse;
import com.azhar.aplikasiantrian.Model.Loket;
import com.azhar.aplikasiantrian.Model.ResponseCall;
import com.azhar.aplikasiantrian.Model.ResponseLoket;
import com.azhar.aplikasiantrian.Model.ResponseRecall;
import com.azhar.aplikasiantrian.R;
import com.azhar.aplikasiantrian.Rest.CombineApi;
import com.azhar.aplikasiantrian.Rest.QueueInterface;
import com.azhar.aplikasiantrian.Utils.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocketActivity extends AppCompatActivity {
    SessionManager sessionManager;
    HashMap<String, String> map;
    Handler handler;
    @BindView(R.id.tvCurrent)
    TextView tvCurrent;
    @BindView(R.id.textView3)
            TextView information;
    @BindView(R.id.tvLoket)
            TextView tvLoket;
    QueueInterface queueInterface;
    String TAG = "kambing";
    private static Retrofit retrofit = null;
    public static String BASE_URL = "";
    String currentloket;
    String currentloket2;
    @BindView(R.id.tvSetting)
    TextView tvSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loket);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(LocketActivity.this);
        map = sessionManager.getDetailsLoggin();
        currentloket = map.get(sessionManager.KEY_PENGGUNA_LOKET);
        currentloket2 = map.get(sessionManager.KEY_PENGGUNA_LOKET2);
        Log.d(TAG, "onCreate: "+currentloket2);
        tvSetting.setText("Selamat Bertugas "+map.get(sessionManager.KEY_PENGGUNA_USERNAME));
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
            m_Runnable.run();
        } else {
            startActivity(new Intent(LocketActivity.this, MainActivity.class).
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            finish();
        }
    }

    /*
        Mendapatkan data antrian terkini
     */
    private void getCurrentQueue(String loketId) {
        Call<CurrentResponse> currentResponse = queueInterface.getQueueList(loketId);
        currentResponse.enqueue(new Callback<CurrentResponse>() {
            @Override
            public void onResponse(Call<CurrentResponse> call, Response<CurrentResponse> response) {
                if (response.body().getStatus() == 200) {
                    tvLoket.setText(response.body().getSekarang().getLayananNama()+"\n("+response.body().getData().get(0).getLoketNama()+")");

                            tvCurrent.setText(String.valueOf(response.body().getSekarang().getLayananAwalan().toUpperCase())+"-0"+String.valueOf(response.body().getSekarang().getAntrianNomor()));
                            information.setText("Tersisa "+response.body().getSisa()+" Antrian Lagi");



                }
            }

            @Override
            public void onFailure(Call<CurrentResponse> call, Throwable t) {

            }
        });
    }

    /*
        Memanggil respon untuk melihat daftar loket dan meletakkannya kedalam list
     */


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
                    Toast.makeText(LocketActivity.this, "Memanggil Nomor Urut" + response.body().getData().getAntrianNomor(), Toast.LENGTH_SHORT).show();
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
            getCurrentQueue(currentloket);
            LocketActivity.this.handler.postDelayed(m_Runnable, 500);
        }

    };
    /*
        Refresh Data
     */
    /*
    private void getData(String id) {
        Call<QueueResponse> data = queueInterface.getQueueList(id);
        data.enqueue(new Callback<QueueResponse>() {
            @Override
            public void onResponse(Call<QueueResponse> call, Response<QueueResponse> response) {
                if (response.body().getStatus() == 200){
//                    tvCurrent.setText(String.valueOf(response.body().getSekarang().getAntrianNomor()));
//                    tvRest.setText(String.valueOf(response.body().getSisa()));
//                    tvTotal.setText(String.valueOf(response.body().getTotal()));
//                    tvSetting.setText("Selamat Datang "+map.get(sessionManager.KEY_PENGGUNA_USERNAME));
                }
            }

            @Override
            public void onFailure(Call<QueueResponse> call, Throwable t) {

            }
        });
    }
    */
}
