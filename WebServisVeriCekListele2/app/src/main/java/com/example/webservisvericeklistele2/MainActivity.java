package com.example.webservisvericeklistele2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapters.BilgiAdapter;
import Models.Bilgi;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }

    public void tanimla() {
        listView = findViewById(R.id.list_view);
    }

    public void istek() {
        list = new ArrayList<>();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bilgiler Ekranı");
        progressDialog.setMessage("İçerik Yükleniyor , Lütfen Bekleyin:)");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<Bilgi>> servis = ManagerAll.getInstance().getirBilgi();
        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    BilgiAdapter bilgiAdapter = new BilgiAdapter(list, getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                }
                progressDialog.cancel();
            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}