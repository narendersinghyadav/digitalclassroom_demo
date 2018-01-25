package com.example.narender.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_dashboard);
        Button button=findViewById(R.id.button6);
        // all are intents to pass activity as well as data
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username=getIntent().getStringExtra("username");
                Intent intent=new Intent(getApplicationContext(),student_profile.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
        Button button1=findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),quizquest.class);
                startActivity(intent);
            }
        });
        Button button2=findViewById(R.id.button10);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
