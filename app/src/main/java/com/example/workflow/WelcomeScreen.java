package com.example.workflow;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;




public class WelcomeScreen extends AppCompatActivity {

    boolean isNightModeOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        sendUserOnClick();
    }

    public void sendUserOnClick()
    {
        Button createProfile = findViewById(R.id.create_profile_button);
        createProfile.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeScreen.this, CreateProfile.class);
            startActivity(intent);
        });
    }

}