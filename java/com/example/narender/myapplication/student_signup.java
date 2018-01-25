package com.example.narender.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Objects;
    public class student_signup extends AppCompatActivity {
        //change image to bytes to store in database
        private static final int RESULT_LOAD_IMAGE=1;
        public static byte[] imageViewToByte(ImageView image) {
            Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            return stream.toByteArray();
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.student_signup);


           Button button = findViewById(R.id.buttonsign);
            final DBHelper db = new DBHelper(this);
            button.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {
                    final EditText editText2 = findViewById(R.id.editText5);
                    final String password = editText2.getText().toString().trim();
                    final EditText editText = findViewById(R.id.editText3);
                    final String name = editText.getText().toString().trim();
                    final EditText editText1 = findViewById(R.id.editText1);
                    final String username = editText1.getText().toString().trim();
                    final EditText editText3 = findViewById(R.id.editText27);
                    final String cpassword = editText3.getText().toString().trim();
                    final EditText editText4 = findViewById(R.id.editText10);
                    final String collageid = editText4.getText().toString().trim();
                    final EditText editText5 = findViewById(R.id.editText11);
                    final String department = editText5.getText().toString().trim();
                    final EditText editText6 = findViewById(R.id.editText12);
                    final String year = editText6.getText().toString().trim();
                    final EditText editText7 = findViewById(R.id.editText4);
                    final String batch = editText7.getText().toString().trim();
                    ImageView imageView=findViewById(R.id.imagestudent3);
                    int i=db.rowcount();
                    i=i+1;

                    if (!Objects.equals(name, "") && !Objects.equals(username, "") && !Objects.equals(password, "") && !Objects.equals(cpassword, "")&& !Objects.equals(batch,"")&& !Objects.equals(collageid, "")&& !Objects.equals(year, "")&& !Objects.equals(department, "")) {
                        if (password.equals(cpassword)) {
                            int count = 0;
                            List<Contact> contacts = db.getAllContacts();
                            for (Contact cn : contacts) {

                                if (Objects.equals(cn.getUsername(), username)) {
                                    count = 1;
                                }
                            }

                            if (count == 0) {


                               db.addContact(new Contact(name, username, password,collageid,department,year,batch,imageViewToByte(imageView),i));
                                Log.d("Insert:", "Inserting .33..");
                                Toast us1 = Toast.makeText(getApplicationContext(), "your account created successfully", Toast.LENGTH_SHORT);
                                us1.show();
                                Log.d("Done", "done inserting");
                            } else {
                                Toast use1 = Toast.makeText(getApplicationContext(), "Username already exist", Toast.LENGTH_LONG);
                                use1.show();
                            }
                        } else {
                            Toast pass = Toast.makeText(getApplicationContext(), "Both Passwords do not match", Toast.LENGTH_LONG);
                            pass.show();
                        }
                    } else {
                        Toast emp = Toast.makeText(getApplicationContext(), "Please fill all fields ", Toast.LENGTH_LONG);
                        emp.show();
                    }
                }
            });

            final TextView textView = findViewById(R.id.link_login);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), student_login.class);
                    startActivity(intent);
                }
            });
            final Button button1=findViewById(R.id.buttonimage);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


                    // Start new activity with the LOAD_IMAGE_RESULTS to handle back the results when image is picked from the Image Gallery.
                    startActivityForResult(i,RESULT_LOAD_IMAGE);
                }
        });


        }
        //help to get image from gallary
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            ImageView imageView=findViewById(R.id.imagestudent3);
            switch (requestCode){
                case RESULT_LOAD_IMAGE:

                    if (resultCode==RESULT_OK){
                        Uri uri=data.getData();

                        String[]projection={MediaStore.Images.Media.DATA};
                        Cursor cursor=getContentResolver().query(uri,projection,null,null,null);
                        cursor.moveToFirst();

                        int columnIndex=cursor.getColumnIndex(projection[0]);
                        String filePath=cursor.getString(columnIndex);
                        cursor.close();
                        Bitmap yourSelectedImage=BitmapFactory.decodeFile(filePath);
                        Log.d("Insert:", "Inserting 2...");
                        imageView.setImageBitmap(yourSelectedImage);

                    }
            }
        }

    }
