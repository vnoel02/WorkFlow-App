package com.example.workflow;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Color;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class ProfileViewActivity extends AppCompatActivity {

    boolean isNightModeOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        setProfileImg();
       // prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ProfileViewActivity.this);


        // Find the text input fields

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


        // Retrieve the current night mode setting
        isNightModeOn = AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_NO;

        // Set the text color of the text input fields based on the current night mode setting
        if (isNightModeOn) {
            tv.setTextColor(Color.WHITE);
            tv2.setTextColor(Color.WHITE);
            tv3.setTextColor(Color.WHITE);
            tv4.setTextColor(Color.WHITE);
        } else {
            tv.setTextColor(Color.BLACK);
            tv2.setTextColor(Color.BLACK);
            tv3.setTextColor(Color.BLACK);
            tv4.setTextColor(Color.BLACK);
        }

        // Find the dark mode toggle button
        Button button = findViewById(R.id.btnDarkMode);

        // Set the button text based on the current night mode setting
        if (isNightModeOn) {
            button.setText(R.string.light);
        } else {
            button.setText(R.string.dark);
        }

        // Set an onClickListener for the button to toggle the night mode
        button.setOnClickListener(view -> {
            if (isNightModeOn) {
                // Turn off the night mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                isNightModeOn = false;
                button.setText(R.string.dark);
                // Set the text color of the text input fields to black
                tv.setTextColor(Color.BLACK);
                tv2.setTextColor(Color.BLACK);
                tv3.setTextColor(Color.BLACK);
                tv4.setTextColor(Color.BLACK);
            } else {
                // Turn on the night mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                isNightModeOn = true;
                button.setText(R.string.light);
                // Set the text color of the text input fields to white
                tv.setTextColor(Color.WHITE);
                tv2.setTextColor(Color.WHITE);
                tv3.setTextColor(Color.WHITE);
                tv4.setTextColor(Color.WHITE);
            }
            // Recreate the activity to apply the new night mode setting
            recreate();
        });

        // Disable the text input fields
        tv.setEnabled(false);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);

        // Set the onFocusChangeListener for each text input field to save the updated text to SharedPreferences
        tv.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String firstName1 = Objects.requireNonNull(tv.getText()).toString();
                prefs.edit().putString("firstName", firstName1).apply();
            }
        });

        tv2.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String lastName1 = Objects.requireNonNull(tv2.getText()).toString();
                prefs.edit().putString("lastName", lastName1).apply();
               // tv2.setText(lastName);
            }
        });

        tv3.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String username1 = Objects.requireNonNull(tv3.getText()).toString();
                prefs.edit().putString("username", username1).apply();
               // tv3.setText(username);
            }
        });

        tv4.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String email1 = Objects.requireNonNull(tv4.getText()).toString();
                prefs.edit().putString("email", email1).apply();
               // tv3.setText(email);
            }
        });

        tv.setEnabled(false);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);
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
