package com.example.workflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Objects;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //initialize variable
        /*SwitchMaterial switchBtn = findViewById(R.id.switchBtn);
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

        });*/

        setContentView(R.layout.activity_welcome_screen);
        sendUserOnClick();


    }

    public void sendUserOnClick() {
        Button createProfile = findViewById(R.id.create_profile_button);

        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreen.this, CreateProfile.class);
                startActivity(intent);
            }
        });
    }
}
