package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                EditText editText = getActivity().findViewById(R.id.first_name);
                EditText editText2 = getActivity().findViewById(R.id.last_name);

                String firstName = editText.getText().toString();
                editor.putString("FirstName", firstName);

                String secondName = editText2.getText().toString();
                editor.putString("SecondName", secondName);
                editor.apply();*/

                Intent intent = new Intent(CreateProfile.this, CalendarActivity.class);
                Intent intent2 = new Intent(CreateProfile.this, ProfileViewActivity.class);
                EditText et = findViewById(R.id.first_name);
                EditText et2 = findViewById(R.id.last_name);
                EditText et3 = findViewById(R.id.user_name);
                EditText et4 = findViewById(R.id.email);

                String firstName = et.getText().toString();
                intent2.putExtra("FirstName", firstName);

                String lastName = et2.getText().toString();
                intent2.putExtra("LastName",lastName);

                String username = et3.getText().toString();
                intent2.putExtra("Username", username);

                String email = et4.getText().toString();
                intent2.putExtra("Email", email);


                //First iteration: Intend on sending the profile info onto another activity within the calendar activity page
                startActivity(intent);
                startActivity(intent2);
            }
        });
    }
}