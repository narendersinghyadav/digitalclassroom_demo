package com.example.narender.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class quizquest extends AppCompatActivity {
    int count=1;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizquest);
        final DBHelper3 db=new DBHelper3(this);

        TextView textView1=findViewById(R.id.textView15);
          String ques=db.getquestion(0);
          textView1.setText(ques);
        TextView textView2=findViewById(R.id.checkBox);
        String opt1=db.getop1(0);
        textView2.setText(opt1);
        TextView textView3=findViewById(R.id.checkBox2);
        String opt2=db.getop2(0);
        textView3.setText(opt2);
        TextView textView4=findViewById(R.id.checkBox3);
        String opt3=db.getop3(0);
        textView4.setText(opt3);

        final CheckBox chk1=findViewById(R.id.checkBox);
        final CheckBox chk2=findViewById(R.id.checkBox2);
        final CheckBox chk3=findViewById(R.id.checkBox3);

            Button button=findViewById(R.id.button8);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int row=db.rowcount();
                        //checking if ans is right
                        if(count==row+1){
                            Toast us1 = Toast.makeText(getApplicationContext(), "Your score is "+score, Toast.LENGTH_SHORT);
                            us1.show();
                            Intent intent = new Intent(getApplicationContext(), student_dashboard.class);
                            startActivity(intent);
                        }
                        else{
                            final String ans=db.getans(count);
                            if(chk1.isChecked()){
                                if(ans.equals("A")){
                                    Toast us1 = Toast.makeText(getApplicationContext(), "Right ans", Toast.LENGTH_SHORT);
                                    us1.show();
                                    score++;
                                }
                                else{
                                    Toast us1 = Toast.makeText(getApplicationContext(), "Wrong ans", Toast.LENGTH_SHORT);
                                    us1.show();
                                }
                            }
                            else if (chk2.isChecked()){
                                if(ans.equals("B")){
                                    Toast us1 = Toast.makeText(getApplicationContext(), "Right ans", Toast.LENGTH_SHORT);
                                    us1.show();
                                    score++;
                                }
                                else{
                                    Toast us1 = Toast.makeText(getApplicationContext(), "Wrong ans", Toast.LENGTH_SHORT);
                                    us1.show();
                                }
                            }
                            else if (chk3.isChecked()){
                                if (ans.equals("C")){
                                    Toast us1 = Toast.makeText(getApplicationContext(), "Right ans", Toast.LENGTH_SHORT);
                                    us1.show();
                                    score++;
                                }
                                else{
                                    Toast us1 = Toast.makeText(getApplicationContext(), "Wrong ans", Toast.LENGTH_SHORT);
                                    us1.show();
                                }
                            }
                            else{
                                Toast us1 = Toast.makeText(getApplicationContext(), "Wrong ans", Toast.LENGTH_SHORT);
                                us1.show();
                            }
                            count++;
                            TextView textView1=findViewById(R.id.textView15);
                            String ques=db.getquestion(count);
                            textView1.setText(ques);
                            TextView textView2=findViewById(R.id.checkBox);
                            String opt1=db.getop1(count);
                            textView2.setText(opt1);
                            TextView textView3=findViewById(R.id.checkBox2);
                            String opt2=db.getop2(count);
                            textView3.setText(opt2);
                            TextView textView4=findViewById(R.id.checkBox3);
                            String opt3=db.getop3(count);
                            textView4.setText(opt3);
                        }

                }
            });

    }
}
