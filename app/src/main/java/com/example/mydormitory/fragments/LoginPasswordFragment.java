package com.example.mydormitory.fragments;
import static com.example.mydormitory.Settings.pass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mydormitory.R;


public class LoginPasswordFragment extends Fragment {

    public static EditText starPass, newPass;
    Button btn_savePass, btn_delPass;
    TextView password, povPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_password,
                container, false);

        starPass = (EditText) view.findViewById(R.id.starPass);
        newPass = (EditText) view.findViewById(R.id.newPass);
        password = (TextView) view.findViewById(R.id.password);
        povPass = (TextView) view.findViewById(R.id.povPass);

        btn_savePass = (Button) view.findViewById(R.id.btn_save_pass);
        btn_delPass = (Button) view.findViewById(R.id.btn_del_pass);
        btn_delPass.setVisibility(View.INVISIBLE);

        if (pass.equals("") != true) {
            password.setText("Введите старый пароль:");
            povPass.setText("Введите новый пароль:");
            btn_delPass.setVisibility(View.VISIBLE);
        }

        return view;
    }
}