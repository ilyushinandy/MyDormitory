package com.example.mydormitory.fragments;

import static com.example.mydormitory.AddStudy.Seriya;
import static com.example.mydormitory.AddStudy.Nomer;
import static com.example.mydormitory.AddStudy.KemV;
import static com.example.mydormitory.AddStudy.DataV;
import static com.example.mydormitory.AddStudy.Pol;
import static com.example.mydormitory.AddStudy.DataR;
import static com.example.mydormitory.AddStudy.MestoR;
import static com.example.mydormitory.AddStudy.MestoG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mydormitory.R;

public class PasportFragment extends Fragment {

    public static EditText edSeriya, edNomer, edKemV, edDataV, edDataR, edMestoR, edMestoG;
    RadioGroup radioGroup_Pol;
    RadioButton rM, rG;
    public static String pol = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pasport,
                container, false);

        edSeriya = view.findViewById(R.id.edSeriya);
        edNomer = view.findViewById(R.id.edNomer);
        edKemV = view.findViewById(R.id.edKem_v);
        edDataV = view.findViewById(R.id.edData_v);
        edDataR = view.findViewById(R.id.edData_r);
        edMestoR = view.findViewById(R.id.edMesto_r);
        edMestoG = view.findViewById(R.id.edMesto_g);
        radioGroup_Pol = view.findViewById(R.id.radio_pol);
        rG = view.findViewById(R.id.radio_G);
        rM = view.findViewById(R.id.radio_M);

        edSeriya.setText(Seriya);
        edNomer.setText(Nomer);
        edKemV.setText(KemV);
        edDataV.setText(DataV);
        edDataR.setText(DataR);
        edMestoR.setText(MestoR);
        edMestoG.setText(MestoG);

        if (Pol != null) {
            if (Pol.equals("M") || Pol.equals("М") || Pol.equals("м")) {
                radioGroup_Pol.check(R.id.radio_M);
            } else if (Pol.equals("Ж") || Pol.equals("ж")) {
                radioGroup_Pol.check(R.id.radio_G);
            }
        }

        radioGroup_Pol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_G:
                        pol = "Ж";
                        break;
                    case R.id.radio_M:
                        pol = "M";
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }
}