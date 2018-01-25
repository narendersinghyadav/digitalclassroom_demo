package com.example.narender.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz_creater extends AppCompatActivity {
    DBHelper3 db3=new DBHelper3(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_creator);


        Button button=findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView textView=findViewById(R.id.editText);
                final String ques = textView.getText().toString().trim();
                final TextView textView1=findViewById(R.id.editText6);
                final String c1=textView1.getText().toString().trim();
                final TextView textView2=findViewById(R.id.editText7);
                final String c2=textView2.getText().toString().trim();
                final TextView textView3=findViewById(R.id.editText8);
                final String c3=textView3.getText().toString().trim();
                final TextView textView4=findViewById(R.id.editText9);
                final String ans=textView4.getText().toString().trim();
                Log.d("inserting","insert");
                int i=db3.rowcount();
                i=i+1;
                //add Questions to database
                db3.addQuestions(ques,c1,c2,c3,ans,i);
                Toast us1 = Toast.makeText(getApplicationContext(), "Quiz created successfully", Toast.LENGTH_SHORT);
                us1.show();
                Intent intent = new Intent(getApplicationContext(), teacher_dashboard.class);
                startActivity(intent);
            }
        });


    }
}
