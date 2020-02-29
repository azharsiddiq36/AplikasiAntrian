package com.azhar.aplikasiantrian.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Toast;

import com.azhar.aplikasiantrian.Adapter.ActionBarCallback;
import com.azhar.aplikasiantrian.Model.Loket;
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
    @BindView(R.id.chooseLoket2)
    Spinner chooseLoket2;
    @BindView(R.id.lyVis)
    LinearLayout lyVis;
    String[] loket;
    String[] loket2;
    String currentloket;
    String currentloket2;
    ArrayList<Loket> list_loket = new ArrayList<>();
    ArrayList<Loket> list_loket2 = new ArrayList<>();
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
                        if (currentloket==null){

                            lyVis.setVisibility(View.VISIBLE);
                            loadLoket();
                            getLoket();
                        }
                        else{

                            sessionManager.saveLogin(etPegawai.getText().toString(),etDomain.getText().toString(),currentloket,currentloket2);
                            Intent gotoloket = new Intent(MainActivity.this, LocketActivity.class);
                            startActivity(gotoloket);
//                        sessionManager.logout();
//                        sessionManager.saveLogin(etPegawai.getText().toString(), etDomain.getText().toString());
                    }

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
    }

    private void getLoket() {
        chooseLoket.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                for (int i = 0; i < list_loket.size(); i++) {
                    if (list_loket.get(i).getLoketNama().equals(chooseLoket.getSelectedItem())) {
                        currentloket = list_loket.get(i).getLoketId();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        chooseLoket2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                for (int i = 0; i < list_loket2.size(); i++) {
                    if (list_loket2.get(i).getLoketNama().equals(chooseLoket.getSelectedItem())) {
                        currentloket = list_loket2.get(i).getLoketId();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /*
        Periksa Apakah Domain Sudah Benar atau Belum
     */
    private void loadLoket() {
        Call<ResponseLoket> responseLoketCall = queueInterface.getLoket();
        responseLoketCall.enqueue(new Callback<ResponseLoket>() {
            @Override
            public void onResponse(Call<ResponseLoket> call, Response<ResponseLoket> response) {
                if (response.body().getStatus() == 200) {
                    list_loket = (ArrayList<Loket>) response.body().getData();
                    loket = new String[list_loket.size() + 1];
                    for (int i = 0; i <= list_loket.size(); i++) {
                        if (i == 0) {
                            loket[i] = "---Pilih Loket---";
                        } else {
                            loket[i] = list_loket.get(i - 1).getLoketNama();
                        }
                    }
                    final ArrayAdapter<String> loket_adapter = new ArrayAdapter<>(MainActivity.this,
                            R.layout.sploket, loket);
                    chooseLoket.setAdapter(loket_adapter);
                    chooseLoket2.setAdapter(loket_adapter);
                } else {

                }
            }

            @Override
            public void onFailure(Call<ResponseLoket> call, Throwable t) {

            }
        });
    }

}
