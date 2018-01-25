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

public class teacher_login extends AppCompatActivity {
    DBHelper2 db = new DBHelper2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);
        final Button button = findViewById(R.id.button420);
        // final TextView textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                EditText a = findViewById(R.id.editText420);
                String us = a.getText().toString();
                EditText b = findViewById(R.id.editText421);
                String pas = b.getText().toString();
                String password = db.searchPass(us);
                //verify password
                if (pas.equals(password)) {
                    Intent intent = new Intent(getApplicationContext(), teacher_dashboard.class);
                    intent.putExtra("username",us);
                    startActivity(intent);

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "password or username is wrong", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        final TextView textView = findViewById(R.id.link_signup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), teacher_signup.class);
                startActivity(intent);
            }
        });
    }
}
