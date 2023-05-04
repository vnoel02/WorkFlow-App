package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);





    }

    public void imageButtonOnClick(View v) {
        Intent intent = new Intent(CalendarActivity.this, ProfileViewActivity.class);
        startActivity(intent);
    }

}