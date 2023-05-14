package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateProfile extends AppCompatActivity {
    EditText et;
    EditText et2;
    EditText et3;
    EditText et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        saveProfileOnClick();

    }



    public void saveProfileOnClick() {
        Button profile = findViewById(R.id.create_profile);

        et = findViewById(R.id.first_name);
        et2 = findViewById(R.id.last_name);
        et3 = findViewById(R.id.user_name);
        et4 = findViewById(R.id.email);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (missingInfo()) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter missing info";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    String firstName = et.getText().toString();
                    String lastName = et2.getText().toString();
                    String username = et3.getText().toString();
                    String email = et4.getText().toString();

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(CreateProfile.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    Boolean createdProfile = prefs.edit().putBoolean("created",true).commit();

                    editor.putString("firstName", firstName);
                    editor.putString("lastName", lastName);
                    editor.putString("username", username);
                    editor.putString("email", email);

                    Intent intent = new Intent(com.example.workflow.CreateProfile.this, MainActivity.class);
                    editor.apply();
                    Global s = new Global();
                    s.createdProfile = true;
                    startActivity(intent);
                }
            }
        });
    }


    public boolean missingInfo() {
        return et.getText().toString().equals("") || et2.getText().toString().equals("")
                || et3.getText().toString().equals("") || et4.getText().toString().equals("");
    }

}