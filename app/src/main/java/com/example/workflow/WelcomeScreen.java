package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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