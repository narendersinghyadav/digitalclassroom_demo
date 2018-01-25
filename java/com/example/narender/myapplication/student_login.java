package com.example.narender.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class student_login extends AppCompatActivity  {
    DBHelper db=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlogin);
        final Button button = findViewById(R.id.button420);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                EditText a= findViewById(R.id.editText420);
                String us=a.getText().toString();
                EditText b=findViewById(R.id.editText421);
                String pas=b.getText().toString();
                String password=db.searchPass(us);
                //verify password
                if (pas.equals(password)) {
                    Intent intent=new Intent(getApplicationContext(),student_dashboard.class);
                    intent.putExtra("username",us);
                    startActivity(intent);
                }
                else{
                    Toast toast=Toast.makeText(getApplicationContext(),"password or username is wrong",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        final TextView textView=findViewById(R.id.link_signup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),student_signup.class);
                startActivity(intent);
            }
        });
    }

}
