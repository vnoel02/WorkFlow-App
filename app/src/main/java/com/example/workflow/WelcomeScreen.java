package com.example.workflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workflow.R;

import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Objects;

import codewithcal.au.calendarappexample.CreateProfile;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        //initVar();
        sendUserOnClick();


    }

    public void sendUserOnClick() {
        Button createProfile = findViewById(R.id.create_profile_button);

        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.workflow.WelcomeScreen.this, com.example.workflow.CreateProfile.class);
                startActivity(intent);
            }
        });
    }
    public void initVar() {
        SwitchMaterial switchBtn = findViewById(R.id.switchBtn);
        Objects.requireNonNull(getSupportActionBar()).setTitle("LIGHT-NIGHT MODE SWITCH");

        //switch theme mode per user wishes
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    buttonView.setText("Night Mode");
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    buttonView.setText("Light Mode");
                }

            }

        });
    }
}