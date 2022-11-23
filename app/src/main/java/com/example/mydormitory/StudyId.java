package com.example.mydormitory;

import static com.example.mydormitory.Room.setFocusRoom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydormitory.model.Study;

public class StudyId extends AppCompatActivity {

    Button btn_del, btn_edit;
    Context context;
    TextView Fio, Number_dog, Period, Group, NumberRoom, Telefon, FioRod, TelRod, Seriya, Nomer, KemV, DataV, DataR, MestoR, MestoG;
    RadioGroup radioGroup_Pol;
    DBManager dbManagerStudy;
    Study study;

    public static boolean focusStudy = false;
    public static boolean isFocusStudy() {
        return focusStudy;
    }
    public static void setFocusStudy(boolean focusStudy) {
        StudyId.focusStudy = focusStudy;
    }

    ClipboardManager clipboardManager;
    ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_id);

        context = getApplicationContext();
        clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        dbManagerStudy = new DBManager(this);
        try {
            dbManagerStudy.open();
        }catch (Exception e) {
            e.printStackTrace();
        }
        read();
        addListenerOnButton();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && isFocusStudy()) {
            setFocusStudy(false);
            read();
        }
    }

    @Override
    public void finish() {
        setFocusRoom(true);
        super.finish();
    }

    public void addListenerOnButton() {

        btn_del = (Button) findViewById(R.id.btn_del_study);
        btn_edit = (Button) findViewById(R.id.btn_edit_study);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, AddStudy.class);
                intent.putExtra("ID",           study.getId());
                intent.putExtra("Fio",          study.getFio());
                intent.putExtra("Number_dog",   study.getNumber_dog());
                intent.putExtra("Period",       study.getPeriod());
                intent.putExtra("Group",        study.getGroup());
                intent.putExtra("NumberRoom",   study.getNumberRoom());
                intent.putExtra("Telefon",      study.getTelefon());
                intent.putExtra("FioRod",       study.getFioRod());
                intent.putExtra("TelRod",       study.getTelRod());
                intent.putExtra("Seriya",       study.getSeriya());
                intent.putExtra("Nomer",        study.getNomer());
                intent.putExtra("KemV",         study.getKemV());
                intent.putExtra("DataV",        study.getDataV());
                intent.putExtra("Pol",          study.getPol());
                intent.putExtra("DataR",        study.getDataR());
                intent.putExtra("MestoR",       study.getMestoR());
                intent.putExtra("MestoG",       study.getMestoG());
                startActivity(intent);

            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                // заголовок
                builder.setTitle("Удалить студента?");
                // да
                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss(); // Close Dialog
                        dbManagerStudy.deleteStudy(Long.parseLong(study.getId()));
                        Toast.makeText(view.getContext(), "Готово!",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                //нет
                builder.setCancelable(true);
                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Cancel
                        dialog.cancel();
                    }
                });

                // создание окна
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        Telefon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = Telefon.getText().toString();
                clipData = ClipData.newPlainText("text",text);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(view.getContext(), "Скопировано!",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void read() {

        Fio = (TextView) findViewById(R.id.fio_s);
        Number_dog = (TextView) findViewById(R.id.number_dog_s);
        Period = (TextView) findViewById(R.id.period_prog_s);
        Group = (TextView) findViewById(R.id.group_s);
        NumberRoom = (TextView) findViewById(R.id.number_room_s);
        Telefon = (TextView) findViewById(R.id.telefon_s);
        FioRod = (TextView) findViewById(R.id.fio_rod_s);
        TelRod = (TextView) findViewById(R.id.tel_rod_s);
        Seriya = (TextView) findViewById(R.id.seriya_s);
        Nomer = (TextView) findViewById(R.id.nomer_s);
        KemV = (TextView) findViewById(R.id.kem_v_s);
        DataV = (TextView) findViewById(R.id.data_v_s);
        DataR = (TextView) findViewById(R.id.data_r_s);
        MestoR = (TextView) findViewById(R.id.mesto_r_s);
        MestoG = (TextView) findViewById(R.id.mesto_g_s);
        radioGroup_Pol = (RadioGroup) findViewById(R.id.radio_pol_s);

        Cursor cursor = dbManagerStudy.fetchStudyID(getIntent().getStringExtra("ID"));
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(DBOpenHelper.STUDY_ID));
                @SuppressLint("Range") String fio = cursor.getString(cursor.getColumnIndex(DBOpenHelper.FIO));
                @SuppressLint("Range") String number_dog = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NUMBER_DOG));
                @SuppressLint("Range") String period_prog = cursor.getString(cursor.getColumnIndex(DBOpenHelper.PERIOD_PROG));
                @SuppressLint("Range") String group = cursor.getString(cursor.getColumnIndex(DBOpenHelper.GROUPA));
                @SuppressLint("Range") String number_room = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NUMBER_ROOM));
                @SuppressLint("Range") String telefon = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TELEFON));
                @SuppressLint("Range") String fio_rod = cursor.getString(cursor.getColumnIndex(DBOpenHelper.FIO_ROD));
                @SuppressLint("Range") String tel_rod = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TEL_ROD));
                @SuppressLint("Range") String seriya = cursor.getString(cursor.getColumnIndex(DBOpenHelper.SERIYA));
                @SuppressLint("Range") String nomer = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOMER));
                @SuppressLint("Range") String kem_v = cursor.getString(cursor.getColumnIndex(DBOpenHelper.KEM_V));
                @SuppressLint("Range") String data_v = cursor.getString(cursor.getColumnIndex(DBOpenHelper.DATA_V));
                @SuppressLint("Range") String pol = cursor.getString(cursor.getColumnIndex(DBOpenHelper.POL));
                @SuppressLint("Range") String data_r = cursor.getString(cursor.getColumnIndex(DBOpenHelper.DATA_R));
                @SuppressLint("Range") String mesto_r = cursor.getString(cursor.getColumnIndex(DBOpenHelper.MESTO_R));
                @SuppressLint("Range") String mesto_g = cursor.getString(cursor.getColumnIndex(DBOpenHelper.MESTO_G));
                study = new Study(ID, fio, number_dog, period_prog, group , number_room, telefon, fio_rod, tel_rod, seriya, nomer, kem_v, data_v, pol, data_r, mesto_r, mesto_g);
            } while (cursor.moveToNext());
        }

        if (study.getPol().equals("M") || study.getPol().equals("М")) {
            radioGroup_Pol.check(R.id.radio_M_s);
        } else if (study.getPol().equals("Ж")) {
            radioGroup_Pol.check(R.id.radio_G_s);
        }

        Fio.setText(        study.getFio());
        Number_dog.setText( study.getNumber_dog());
        Period.setText(     study.getPeriod());
        Group.setText(      study.getGroup());
        NumberRoom.setText( study.getNumberRoom());
        Telefon.setText(    study.getTelefon());
        TelRod.setText(     study.getTelRod());
        FioRod.setText(     study.getFioRod());
        Seriya.setText(     study.getSeriya());
        Nomer.setText(      study.getNomer());
        KemV.setText(       study.getKemV());
        DataV.setText(      study.getDataV());
        DataR.setText(      study.getDataR());
        MestoR.setText(     study.getMestoR());
        MestoG.setText(     study.getMestoG());
    }
}