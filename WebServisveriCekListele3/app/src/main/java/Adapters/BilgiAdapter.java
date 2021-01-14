package Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.webservisvericeklistele3.MainActivity2;
import com.example.webservisvericeklistele3.R;

import java.util.List;

import Models.Bilgi;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi> bilgiList;
    Context context;
    Activity activity;

    public BilgiAdapter(List<Bilgi> bilgiList, Context context,Activity activity) {
        this.bilgiList = bilgiList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {
        return bilgiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView postId,id,name,email,body;
        LinearLayout layoutlist;
        layoutlist = convertView.findViewById(R.id.layoutlist2);
        postId = convertView.findViewById(R.id.postId);
        id = convertView.findViewById(R.id.id);
        name = convertView.findViewById(R.id.name);
        email = convertView.findViewById(R.id.email);
        body = convertView.findViewById(R.id.body);
        postId.setText(""+bilgiList.get(position).getPostId());
        id.setText(""+bilgiList.get(position).getId());
        name.setText(bilgiList.get(position).getName());
        email.setText(bilgiList.get(position).getEmail());
        body.setText(bilgiList.get(position).getBody());
        final String post = ""+bilgiList.get(position).getPostId();
        final String idm = ""+bilgiList.get(position).getId();

        layoutlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MainActivity2.class);
                intent.putExtra("post_id",post);
                intent.putExtra("id",idm);
                activity.startActivity(intent);
            }
        });



        return convertView;
    }
}
