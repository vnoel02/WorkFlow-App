package com.example.workflow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String firstName = prefs.getString("firstName", "");
        TextView tv = findViewById(R.id.text_firstname);
        tv.setText(firstName);

        String lastName = prefs.getString("lastName", "");
        TextView tv2 = findViewById(R.id.text_lastName);
        tv2.setText(lastName);

        String username = prefs.getString("username", "");
        TextView tv3 = findViewById(R.id.profile_username);
        tv3.setText(username);

        String email = prefs.getString("email", "");
        TextView tv4 = findViewById(R.id.profile_email);
        tv4.setText(email);

    }

    public void returnOnClick(View view) {
        Intent intent = new Intent(ProfileViewActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
