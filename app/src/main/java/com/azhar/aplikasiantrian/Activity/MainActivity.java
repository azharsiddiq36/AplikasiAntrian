package com.azhar.aplikasiantrian.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.aplikasiantrian.Adapter.ActionBarCallback;
import com.azhar.aplikasiantrian.Model.Layanan;
import com.azhar.aplikasiantrian.Model.Loket;
import com.azhar.aplikasiantrian.Model.ResponseLayanan;
import com.azhar.aplikasiantrian.Model.ResponseLoket;
import com.azhar.aplikasiantrian.R;
import com.azhar.aplikasiantrian.Rest.QueueInterface;
import com.azhar.aplikasiantrian.Utils.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTouch;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.etDomain)
    EditText etDomain;
    @BindView(R.id.chooseLoket)
    Spinner chooseLoket;
    @BindView(R.id.chooseLayanan)
    Spinner chooseLayanan;
    @BindView(R.id.lyVis)
    LinearLayout lyVis;
    String currentLayanan;
    String currentLoket;
    ArrayList<Loket> list_loket = new ArrayList<>();
    ArrayList<Layanan> list_layanan = new ArrayList<>();
    @BindView(R.id.etPegawai)
    TextView etPegawai;
    String loket[];
    String layanan[];
    SessionManager sessionManager;
    HashMap<String,String> map;
    QueueInterface queueInterface;
    private static Retrofit retrofit = null;
    public String BASE_URL= "";
    String TAG = "Kambing";
    ClipboardManager clipboardManager;

    SweetAlertDialog pDialog;
    Handler handler;
    HashMap<String,String> services;
    HashMap<String,String> locket;
    HashMap <String,String> pengguna;
    HashMap<String,String> awalan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(MainActivity.this);
        map = sessionManager.getDetailsLoggin();
        clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        handler = new Handler();

    }
    @OnClick(R.id.lyBack)
    protected void lyBack(View view){
        onBackPressed();
    }
    @OnClick(R.id.btnSetting)
    protected void btnSetting(View view){
        pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Memeriksa Domain, Harap Tunggu Sebentar ...");
        pDialog.setCancelable(true);
        pDialog.show();
        if (BASE_URL.equals("")){
            BASE_URL = "http://"+etDomain.getText().toString()+"/";
        }
        else{
            BASE_URL = "http://"+etDomain.getText().toString()+"/";
            retrofit = null;
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        queueInterface = retrofit.create(QueueInterface.class);
        if (currentLoket == null){
            loadLayanan();
        }
        else{
            Log.d(TAG, "btnSetting: "+currentLayanan);
            sessionManager.saveLogin(etPegawai.getText().toString(),etDomain.getText().toString(),services.get(currentLayanan),locket.get(currentLoket),currentLayanan,currentLoket,awalan.get(currentLayanan));
            Intent gotoloket = new Intent(MainActivity.this, LocketActivity.class);
            startActivity(gotoloket);
        }
    }

    private final Runnable m_Runnable = new Runnable() {
        public void run() {
            if (currentLayanan == null){
                currentLayanan = chooseLayanan.getSelectedItem().toString();
            }
            else if(currentLayanan != chooseLayanan.getSelectedItem().toString()){
                currentLayanan = chooseLayanan.getSelectedItem().toString();
                loadLoket();
            }
            if (chooseLoket.getSelectedItem() == null){

            }
            else{
                currentLoket = chooseLoket.getSelectedItem().toString();
                etPegawai.setText(pengguna.get(currentLoket));
            }


            MainActivity.this.handler.postDelayed(m_Runnable, 100);
        }
    };



    private void loadLayanan() {
        services = new HashMap<>();
        awalan = new HashMap<>();
        Call<ResponseLayanan> responseLayananCall = queueInterface.getListServices();
        responseLayananCall.enqueue(new Callback<ResponseLayanan>() {
            @Override
            public void onResponse(Call<ResponseLayanan> call, Response<ResponseLayanan> response) {
                pDialog.dismiss();
                if (response.body().getStatus() == 200){
                    if (currentLayanan == null && currentLoket ==null){
                        lyVis.setVisibility(View.VISIBLE);
                        list_layanan = (ArrayList<Layanan>) response.body().getData();
                        layanan = new String[list_layanan.size()+1];
                        for (int i =0;i<layanan.length;i++){
                            if(i ==0){
                                layanan[i] = "---Pilih Layanan---";
                                services.put("0","pilihlayanan");
                            }
                            else{
                                services.put(list_layanan.get(i-1).getLayananNama(),list_layanan.get(i-1).getLayananId());
                                awalan.put(list_layanan.get(i-1).getLayananNama(),list_layanan.get(i-1).getLayananAwalan());
                                layanan[i] = list_layanan.get(i-1).getLayananNama();
                            }
                        }
                        final ArrayAdapter<String> layanan_adapter = new ArrayAdapter<>(MainActivity.this,
                                R.layout.sploket, layanan);
                        chooseLayanan.setAdapter(layanan_adapter);
                        m_Runnable.run();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseLayanan> call, Throwable t) {
                pDialog.dismiss();
                pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE);
                pDialog.setTitleText("Oops...");
                pDialog.setContentText("Sepertinya domain yang anda masukkan salah");
                pDialog.show();
            }
        });
    }
    private void loadLoket() {
        locket = new HashMap<>();
        pengguna = new HashMap<>();
        Call<ResponseLoket> responseLoketCall = queueInterface.getListLoket(services.get(currentLayanan));
        responseLoketCall.enqueue(new Callback<ResponseLoket>() {
            @Override
            public void onResponse(Call<ResponseLoket> call, Response<ResponseLoket> response) {
                list_loket = (ArrayList<Loket>) response.body().getData();
                loket = new String[list_loket.size()+1];
                for (int i =0;i<loket.length;i++){
                    if(i ==0){
                        loket[i] = "---Pilih Loket---";
                        locket.put("0","pilihloket");
                    }
                    else{
                        locket.put(list_loket.get(i-1).getLoketNama(),list_loket.get(i-1).getLoketId());
                        loket[i] = list_loket.get(i-1).getLoketNama();
                        pengguna.put(list_loket.get(i-1).getLoketNama(),list_loket.get(i-1).getLoketPetugas());
                    }
                }
                final ArrayAdapter<String> loket_adapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.sploket, loket);
                chooseLoket.setAdapter(loket_adapter);
            }

            @Override
            public void onFailure(Call<ResponseLoket> call, Throwable throwable) {

            }
        });
    }


}
