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

        Button button = findViewById(R.id.btnDarkMode);

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.dimAmount = 0.75f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(layoutParams);
        sendUserOnClick();


/*
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


 */

    }

    public void sendUserOnClick()
    {
        Button createProfile = findViewById(R.id.create_profile_button);

        createProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(com.example.workflow.WelcomeScreen.this, com.example.workflow.CreateProfile.class);
                startActivity(intent);
            }
        });
    }

}