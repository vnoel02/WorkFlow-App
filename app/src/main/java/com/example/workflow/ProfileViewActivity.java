package com.example.workflow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileViewActivity extends AppCompatActivity {

    boolean isNightModeOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        setProfileImg();

        Button button = findViewById(R.id.btnDarkMode);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ProfileViewActivity.this);


        String firstName = prefs.getString("firstName", "");
        TextInputEditText tv = findViewById(R.id.text_firstname);
        tv.setText(firstName);

        String lastName = prefs.getString("lastName", "");
        TextInputEditText tv2 = findViewById(R.id.text_lastName);
        tv2.setText(lastName);

        String username = prefs.getString("username", "");
        TextInputEditText tv3 = findViewById(R.id.profile_username);
        tv3.setText(username);

        String email = prefs.getString("email", "");
        TextInputEditText tv4 = findViewById(R.id.profile_email);
        tv4.setText(email);
        tv.setEnabled(false);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);


        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
        {
            isNightModeOn = false;
            button.setText("Dark");
        }   else
        {
            isNightModeOn = true;
            button.setText("Light");

        }


        //switch theme mode per user wishes
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (isNightModeOn)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    isNightModeOn = false;
                    button.setText("Dark");
                }
                else if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                {
                    isNightModeOn = true;
                    button.setText("Light");

                } else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

            }

        });


    }



    //Return to calendar view
    public void returnOnClick(View view) {
        Intent intent = new Intent(ProfileViewActivity.this, MainActivity.class);
        startActivity(intent);
    }

    // Delete data and return to create profile activity
    public void deleteProfile(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        prefs.edit().clear().apply();
        Intent intent = new Intent(ProfileViewActivity.this, WelcomeScreen.class);
        startActivity(intent);
    }

     // Uses saved image from profile creation
    public void setProfileImg() {
        ImageView profile = findViewById(R.id.profileViewPic);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String previouslyEncodedImage = prefs.getString("image_data", "");

        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            profile.setImageBitmap(bitmap);
        }
    }
}
