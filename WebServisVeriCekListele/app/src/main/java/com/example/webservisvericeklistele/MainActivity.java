package com.example.webservisvericeklistele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    List<Bilgi> bilgi_List;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }

    public void tanimla()
    {
        listView = findViewById(R.id.list_View);
    }

    public void istek() {
        bilgi_List = new ArrayList<>();
        Call<List<Bilgi>> listCall = ManagerAll.getInstance().getirBilgi();
        listCall.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    bilgi_List = response.body();
                    BilgiAdapter bilgiAdapter = new BilgiAdapter(bilgi_List,getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}