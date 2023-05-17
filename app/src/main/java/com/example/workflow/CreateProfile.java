package com.example.workflow;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class CreateProfile extends AppCompatActivity {
    EditText et;
    EditText et2;
    EditText et3;
    EditText et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        saveProfileOnClick();

    }



    public void saveProfileOnClick() {
        Button profile = findViewById(R.id.create_profile);

        et = findViewById(R.id.first_name);
        et2 = findViewById(R.id.last_name);
        et3 = findViewById(R.id.user_name);
        et4 = findViewById(R.id.email);

        profile.setOnClickListener(view -> {

            if (missingInfo()) {
                Context context = getApplicationContext();
                CharSequence text = "Please enter missing info";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                String firstName = et.getText().toString();
                String lastName = et2.getText().toString();
                String username = et3.getText().toString();
                String email = et4.getText().toString();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(CreateProfile.this);
                SharedPreferences.Editor editor = prefs.edit();
                prefs.edit().putBoolean("created",true).apply();

                editor.putString("firstName", firstName);
                editor.putString("lastName", lastName);
                editor.putString("username", username);
                editor.putString("email", email);

                Intent intent = new Intent(CreateProfile.this, MainActivity.class);
                editor.apply();
                startActivity(intent);
            }
        });
    }


    public boolean missingInfo() {
        return et.getText().toString().equals("") || et2.getText().toString().equals("")
                || et3.getText().toString().equals("") || et4.getText().toString().equals("");
    }


    // Used for getting image from gallery (Google Photos), converting URI to bitmap due to permission restrictions
    // Alternate way would be to change the intent to ACTION_OPEN_DOCUMENT

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),

            result -> {

                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    ImageView testim = findViewById(R.id.galleryImage);
                    assert intent != null;
                    Uri selectIm = intent.getData();

                    testim.setImageURI(selectIm);

                    Bitmap bitmap = null;
                    ContentResolver contentResolver = getContentResolver();
                    try {
                        if(Build.VERSION.SDK_INT < 28) {
                            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectIm);
                        } else {
                            ImageDecoder.Source source = ImageDecoder.createSource(contentResolver, selectIm);
                            bitmap = ImageDecoder.decodeBitmap(source);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    assert bitmap != null;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();

                    String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(CreateProfile.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("image_data",encodedImage);
                    editor.apply();

                }
            });
    //Onclick method
    public void onSetImage(View view){
        mStartForResult.launch(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI));

    }
}