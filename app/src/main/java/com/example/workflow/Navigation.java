package com.example.workflow;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Navigation extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean isProfileCreated = prefs.getBoolean("created", false);
        Intent intent;
        if (isProfileCreated) {
            intent = new Intent(Navigation.this, MainActivity.class);
        } else {
            intent = new Intent(Navigation.this, WelcomeScreen.class);
        }
        startActivity(intent);
        finish();
    }

}
