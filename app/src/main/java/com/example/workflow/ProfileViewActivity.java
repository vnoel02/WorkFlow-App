package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        /*SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        TextView tv = findViewById(R.id.receive_first);
        TextView tv2 = findViewById(R.id.receive_second);


        String firstName = sharedPref.getString("FirstName", "");
        String secondName = sharedPref.getString("SecondName","");
        tv.setText(firstName);
        tv2.setText(secondName);*/
        String firstName = getIntent().getStringExtra("FirstName");
        TextView tv = findViewById(R.id.text_firstname);
        tv.setText(firstName);

        String lastName = getIntent().getStringExtra("LastName");
        TextView tv2 = findViewById(R.id.text_lastName);
        tv2.setText(lastName);

        String username = getIntent().getStringExtra("Username");
        TextView tv3 = findViewById(R.id.profile_username);
        tv3.setText(username);

        String email = getIntent().getStringExtra("Email");
        TextView tv4 = findViewById(R.id.profile_email);
        tv4.setText(email);

        //editor.apply();
    }

    public void returnOnClick(View view) {
        Intent intent = new Intent(ProfileViewActivity.this, CalendarActivity.class);
        startActivity(intent);

    }


}