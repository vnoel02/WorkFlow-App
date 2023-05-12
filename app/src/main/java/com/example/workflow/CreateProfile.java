package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        saveProfileOnClick();

    }

    public void saveProfileOnClick() {
        Button profile = findViewById(R.id.create_profile);

        EditText et = findViewById(R.id.first_name);
        EditText et2 = findViewById(R.id.last_name);
        EditText et3 = findViewById(R.id.user_name);
        EditText et4 = findViewById(R.id.email);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstName = et.getText().toString();
                String lastName = et2.getText().toString();
                String username = et3.getText().toString();
                String email = et4.getText().toString();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(CreateProfile.this);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("firstName", firstName);
                editor.putString("lastName", lastName);
                editor.putString("username", username);
                editor.putString("email", email);

                //Intent intent = new Intent(com.example.workflow.CreateProfile.this, MainActivity.class);
                Intent intent2 = new Intent(com.example.workflow.CreateProfile.this, ProfileViewActivity.class);


//                String firstName = et.getText().toString();
//                intent2.putExtra("FirstName", firstName);
//
//                String lastName = et2.getText().toString();
//                intent2.putExtra("LastName",lastName);
//
//                String username = et3.getText().toString();
//                intent2.putExtra("Username", username);
//
//                String email = et4.getText().toString();
//                intent2.putExtra("Email", email);

                editor.apply();
                Global s = new Global();
                s.createdProfile = true;
                //startActivity(intent);
                startActivity(intent2);

            }
        });
    }


}