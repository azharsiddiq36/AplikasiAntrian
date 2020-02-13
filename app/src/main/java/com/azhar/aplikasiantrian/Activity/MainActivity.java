package com.azhar.aplikasiantrian.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.azhar.aplikasiantrian.Adapter.ActionBarCallback;
import com.azhar.aplikasiantrian.Model.ResponseLoket;
import com.azhar.aplikasiantrian.R;
import com.azhar.aplikasiantrian.Rest.QueueInterface;
import com.azhar.aplikasiantrian.Utils.SessionManager;

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
    @BindView(R.id.etPegawai)
    EditText etPegawai;
    SessionManager sessionManager;
    HashMap<String,String> map;
    QueueInterface queueInterface;
    private static Retrofit retrofit = null;
    public String BASE_URL= "";
    String TAG = "Kambing";
    ActionMode mActionMode;
    ClipboardManager clipboardManager;
    ClipData clipData;
    SweetAlertDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(MainActivity.this);
        map = sessionManager.getDetailsLoggin();
        clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);


    }
//    @OnLongClick(R.id.etDomain)
//    protected boolean etDomain(View view){
//        mActionMode = MainActivity.this.startActionMode(new ActionBarCallback(MainActivity.this,etDomain));
//        return true;
//    }
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
        Call<ResponseLoket> tes = queueInterface.getLoket();
        tes.enqueue(new Callback<ResponseLoket>() {
            @Override
            public void onResponse(Call<ResponseLoket> call, Response<ResponseLoket> response) {
                pDialog.hide();
                if (response.body().getStatus() == 200 ) {
                    if (etDomain.getText().toString().equals(map.get(sessionManager.KEY_PENGGUNA_DOMAIN))){
                        sessionManager.saveLogin(etPegawai.getText().toString(), etDomain.getText().toString());
                    }
                    else{
                        sessionManager.logout();
                        sessionManager.saveLogin(etPegawai.getText().toString(), etDomain.getText().toString());
                    }
                    Intent gotoloket = new Intent(MainActivity.this, LocketActivity.class);
                    startActivity(gotoloket);
                }
                else{
                    Toast.makeText(MainActivity.this, "Harap Periksa Kembali Jaringan Anda", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseLoket> call, Throwable t) {
                pDialog.hide();
                pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE);
                        pDialog.setTitleText("Oops...");
                        pDialog.setContentText("Sepertinya domain yang anda masukkan salah");
                        pDialog.show();
                //Toast.makeText(MainActivity.this, "Harap periksa kembali Domain yang anda masukkan", Toast.LENGTH_SHORT).show();
            }
        });
        testserver();


    }
    /*
        Periksa Apakah Domain Sudah Benar atau Belum
     */
    private void testserver() {

    }

}
