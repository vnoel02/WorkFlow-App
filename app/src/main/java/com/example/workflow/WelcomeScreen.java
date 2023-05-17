package com.example.workflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workflow.R;

import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Objects;



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