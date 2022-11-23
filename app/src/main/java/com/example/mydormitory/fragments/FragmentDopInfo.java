package com.example.mydormitory.fragments;

import android.os.Bundle;

import static com.example.mydormitory.AddStudy.FioRod;
import static com.example.mydormitory.AddStudy.TelROd;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.mydormitory.R;

public class FragmentDopInfo extends Fragment {

    public static EditText edFioRod, edTelRod;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dop_info,
                container, false);

        edFioRod = view.findViewById(R.id.edFio_rod);
        edTelRod = view.findViewById(R.id.edtel_rod);

        edFioRod.setText(FioRod);
        edTelRod.setText(TelROd);

        return view;
    }
}