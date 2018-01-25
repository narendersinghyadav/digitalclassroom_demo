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
public class teacher_signup extends AppCompatActivity {
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
        setContentView(R.layout.teacher_signup);


        Button button = findViewById(R.id.buttonsign);
        final DBHelper2 db1 = new DBHelper2(this);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                final EditText editText2 = findViewById(R.id.editText26);
                final String password = editText2.getText().toString().trim();
                final EditText editText = findViewById(R.id.editText23);
                final String name = editText.getText().toString().trim();
                final EditText editText1 = findViewById(R.id.editText25);
                final String username = editText1.getText().toString().trim();
                final EditText editText3 = findViewById(R.id.editText27);
                final String cpassword = editText3.getText().toString().trim();
                final EditText editText4 = findViewById(R.id.editText24);
                final String collageid = editText4.getText().toString().trim();
                ImageView imageView1=findViewById(R.id.imageview2);


                if (!Objects.equals(name, "") && !Objects.equals(username, "") && !Objects.equals(password, "") && !Objects.equals(cpassword, "")) {
                    if (password.equals(cpassword)) {
                        int count = 0;
                        List<Contact2> contacts = db1.getAllContacts();
                        for (Contact2 cn : contacts) {
                            if (Objects.equals(cn.getUsername(), username)) {
                                count = 1;
                            }
                        }
                        if (count == 0) {

                            Log.d("Insert:", "Inserting ...");
                            db1.addContact(new Contact2(name,username,password,collageid,imageViewToByte(imageView1)));
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

        final TextView textView = findViewById(R.id.link_login2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), teacher_login.class);
                startActivity(intent);
            }
        });
        final Button button1=findViewById(R.id.imagebutton2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


                // Start new activity with the LOAD_IMAGE_RESULTS to handle back the results when image is picked from the Image Gallery.
                startActivityForResult(i,RESULT_LOAD_IMAGE);
            }
        });

//            @Override
//            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//                super.onActivityResult(requestCode, resultCode, data);
//
//                // Here we need to check if the activity that was triggers was the Image Gallery.
//                // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
//                // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
//                if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
//                    // Let's read picked image data - its URI
//                    Uri pickedImage = data.getData();
//                    // Let's read picked image path using content resolver
//                    String[] filePath = { MediaStore.Images.Media.DATA };
//                    Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
//                    cursor.moveToFirst();
//                    String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
//
//                    // Now we need to set the GUI ImageView data with data read from the picked file.
////                    image.setImageBitmap(BitmapFactory.decodeFile(imagePath));
//
//                    // At the end remember to close the cursor or you will end with the RuntimeException!
//                    cursor.close();
//                }
//            }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imageView=findViewById(R.id.imageview2);
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
