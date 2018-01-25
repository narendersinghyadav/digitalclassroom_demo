package com.example.narender.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class teacher_profile extends AppCompatActivity {
    DBHelper2 db=new DBHelper2(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_profile);
        String username= getIntent().getStringExtra("username");
        TextView textView=findViewById(R.id.email);
        textView.setText(username);
        //search collage id by username/email
        String id=db.searchid(username);
        TextView textView1=findViewById(R.id.collageid);
        textView1.setText(id);
        //search name by email id
        String name=db.searchname(username);
        TextView textView2=findViewById(R.id.name1);
        textView2.setText(name);

    }
}
