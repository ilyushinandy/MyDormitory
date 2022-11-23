package com.example.mydormitory.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.mydormitory.R;


public class LoginFragment extends Fragment {
    public static TextView helpPass, helpPassText;
    public static EditText edPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,
                container, false);
        helpPass = view.findViewById(R.id.helpPass);
        helpPassText = view.findViewById(R.id.helpPassText);
        edPass = view.findViewById(R.id.editPassword);
        helpPassText.setVisibility(View.INVISIBLE);

        return view;
    }
}