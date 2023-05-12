package com.example.workflow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Navigation extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent;
        Global g = (Global) getApplicationContext();
        if (g.createdProfile) {
            intent = new Intent(Navigation.this, MainActivity.class);
        } else {
            intent = new Intent(Navigation.this, WelcomeScreen.class);
        }

        startActivity(intent);
        finish();
    }

}
