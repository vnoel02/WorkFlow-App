package com.example.workflow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

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

    }

    public void returnOnClick(View view) {
        Intent intent = new Intent(ProfileViewActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void deleteProfile(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        prefs.edit().clear().apply();
        Intent intent = new Intent(ProfileViewActivity.this, WelcomeScreen.class);
        startActivity(intent);
    }
}
