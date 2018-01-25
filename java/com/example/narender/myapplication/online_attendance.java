package com.example.narender.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.net.Uri;

public class online_attendance extends AppCompatActivity {
    DBHelper db=new DBHelper(this);

     int count=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.online_attendance);
       final int row=db.rowcount();
        String name = db.searchnamebyid(1);
       final String email=db.searchemailbyid(1);
        final TextView textView = findViewById(R.id.textView18);
        textView.setText(name);


        Button button=findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText=findViewById(R.id.attendance);
                final String att=editText.getText().toString();
                //attendance is less then mail the student

                if(att.equals("23")||att.equals("24")||att.equals("25")||att.equals("26")||att.equals("27")||att.equals("28")||att.equals("29")||att.equals("30")){}
                else {
                    Intent chooser=null;
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Attendance Shortage");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Your attendance is shortage");
                    emailIntent.setType("message/rfc822");
                    chooser=Intent.createChooser(emailIntent,"Send Email");
                    startActivity(chooser);
                }
                if (count <row) {
                    String name = db.searchnamebyid(count);
                    //textView.setText(name);
                    String email = db.searchemailbyid(count);
                    count++;

                }
                else if (count == row) {
                    TextView textView1 = findViewById(R.id.textView18);
                    textView1.setText("All students got attendance");
                    Button button = findViewById(R.id.button9);
                    button.setText("FINISH");
                    count++;
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), teacher_dashboard.class);
                    startActivity(intent);
                }
            }

        });


    }
}
