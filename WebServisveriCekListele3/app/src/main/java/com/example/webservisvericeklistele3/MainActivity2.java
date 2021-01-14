package com.example.webservisvericeklistele3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Models.Result;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    String id,postid;
    TextView postid2t,id2t,name2t,email2t,body2t;
    List<Result> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tanimla();
        al();
        istek();
    }
    public void al()
    {
        Bundle bundle =getIntent().getExtras();
        id=bundle.getString("id");
        postid=bundle.getString("post_id");


    }

    public void tanimla()
    {
        id2t = findViewById(R.id.id2);
        postid2t = findViewById(R.id.postId2);
        name2t = findViewById(R.id.name2);
        email2t = findViewById(R.id.email2);
        body2t = findViewById(R.id.body2);

    }

    public void atama(List<Result> liste)
    {
        id2t.setText(""+liste.get(0).getId());
        postid2t.setText(""+liste.get(0).getPostId());
        name2t.setText(liste.get(0).getName());
        email2t.setText(liste.get(0).getEmail());
        body2t.setText(liste.get(0).getBody());
    }

    public void istek()
    {
        list2 = new ArrayList<>();
        Call<List<Result>> call = ManagerAll.getInstance().managergetResult(postid,id);
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.isSuccessful())
                {
                    list2 = response.body();
                    atama(list2);
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }
}