package com.example.mydormitory;

import static com.example.mydormitory.fragments.LoginFragment.edPass;
import static com.example.mydormitory.fragments.LoginFragment.helpPassText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mydormitory.fragments.Dormitory3;
import com.example.mydormitory.fragments.LoginFragment;


public class MainActivity extends AppCompatActivity {

    Context context;
    DBManager dbManager;
    String pass_admin = "ilyushinR00t";
    String password_user = "";
    Toast toast;

    ClipboardManager clipboardManager;
    ClipData clipData;

    Fragment fr_dormitory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        dbManager = new DBManager(this);
        try {
            dbManager.openFirst();
        }catch (Exception e) {
            e.printStackTrace();
        }

        readLogin();
    }

    public void readLogin() {//проверка пароля в бд

        Cursor cursor = dbManager.fetch();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(DBOpenHelper.USER_ID));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(DBOpenHelper.USER_PASSWORD));
                password_user = password;
            } while (cursor.moveToNext());
        }

        if (password_user.equals("")) {//открытие фрагмента меню
            fr_dormitory = null;
            fr_dormitory = new Dormitory3();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentDormitory, fr_dormitory);
            ft.commit();
        } else {//открытие фрагмента авторизации
            fr_dormitory = null;
            fr_dormitory = new LoginFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentDormitory, fr_dormitory);
            ft.commit();
        }
    }

    public void Btn1 (View view) {//кнопка войти
        if (password_user.equals("") == false) {
            if (edPass.getText().toString().equals("")) {
                toast = Toast.makeText(context, "Введите пароль!",Toast.LENGTH_LONG);
                toast.show();
            } else {
                if (edPass.getText().toString().equals(pass_admin)) {
                    Intent intent = new Intent(context, Registration.class);
                    startActivity(intent);
                } else if (edPass.getText().toString().equals(password_user)) {

                    fr_dormitory = null;
                    fr_dormitory = new Dormitory3();

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentDormitory, fr_dormitory);
                    ft.commit();
                } else {
                    toast = Toast.makeText(context, "Неправильный пароль!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }
    }
    public void btn_helpPass (View view) {//нажатие на надпись "забыли пароль"
        helpPassText.setVisibility(View.VISIBLE);
    }
    public void btn_helpPassText (View view) {//нажатие на текст подсказки
        clipData = ClipData.newPlainText("text", "ilyushinandy@yandex.ru");
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(view.getContext(), "Email скопирован!",Toast.LENGTH_LONG).show();
    }
    //кнопки меню
    public void Btn_add_study (View view) {//добавить студента
        Intent intent = new Intent(context, AddStudy.class);
        startActivity(intent);
    }

    public void Btn_data_manager (View view) {//управление данными
        Intent intent = new Intent(context, DataManager.class);
        startActivity(intent);
    }

    public void Btn_rooms (View view) {//комнаты
        Intent intent = new Intent(context, Rooms.class);
        startActivity(intent);
    }

    public void Btn_settings (View view) {//настройки
        Intent intent = new Intent(context, Settings.class);
        startActivity(intent);
    }

    public void Btn_search (View view) {//поиск
        Intent intent = new Intent(context, SearchStudy.class);
        startActivity(intent);
    }

    public void Btn_statistics (View view) {//статистика
        Intent intent = new Intent(context, Statistics.class);
        startActivity(intent);
    }

}