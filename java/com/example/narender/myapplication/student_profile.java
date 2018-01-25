package com.example.narender.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class student_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profile);
        DBHelper db=new DBHelper(this);
        String email=  getIntent().getStringExtra("username");
        //profile page
        String name1=db.searchname(email);
        TextView name= findViewById(R.id.namer);
        name.setText(name1);
        String collageid=db.searchcollageid(email);
        TextView collage=findViewById(R.id.collageidr);
        collage.setText(collageid);
        TextView email1=findViewById(R.id.emailer);
        email1.setText(email);
        String department=db.searchDepartment(email);
        TextView dp=findViewById(R.id.departmentr);
        dp.setText(department);
        String batch=db.searchbatch(email);
        TextView bt=findViewById(R.id.batchr);
        bt.setText(batch);
        String year=db.searchYear(email);
        TextView yr=findViewById(R.id.yearr);
        yr.setText(year);
    }
}
