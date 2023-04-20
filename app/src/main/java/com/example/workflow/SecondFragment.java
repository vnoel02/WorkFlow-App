package com.example.workflow;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.workflow.databinding.FragmentSecondBinding;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private Button createProfile;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState


    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Change the 'previous' button to go to next activity

                /*SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                EditText editText = getActivity().findViewById(R.id.first_name);
                EditText editText2 = getActivity().findViewById(R.id.last_name);

                String firstName = editText.getText().toString();
                editor.putString("FirstName", firstName);

                String secondName = editText2.getText().toString();
                editor.putString("SecondName", secondName);
                editor.apply();*/

                Intent intent = new Intent(getActivity(), CalendarActivity.class);
                Intent intent2 = new Intent(getActivity(), ProfileViewActivity.class);
                EditText et = getActivity().findViewById(R.id.first_name);
                EditText et2 = getActivity().findViewById(R.id.last_name);
                EditText et3 = getActivity().findViewById(R.id.user_name);
                EditText et4 = getActivity().findViewById(R.id.email);

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
                //startActivity(intent2);


                /*NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);*/
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}