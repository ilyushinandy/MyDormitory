package com.example.mydormitory;

import static com.example.mydormitory.fragments.LoginPasswordFragment.newPass;
import static com.example.mydormitory.fragments.LoginPasswordFragment.starPass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydormitory.fragments.BlankFragment;
import com.example.mydormitory.fragments.LoginPasswordFragment;

public class Settings extends AppCompatActivity {

    DBManager dbManagerSettings;
    public static String pass = "";
    Fragment fragmentLoginPass;
    boolean fr_login_pass = false;
    TextView loginPassText;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        dbManagerSettings = new DBManager(this);
        try {
            dbManagerSettings.open();
        }catch (Exception e) {
            e.printStackTrace();
        }

        loginPassText = (TextView) findViewById(R.id.loginPasswordText);

        read();

        if (!pass.equals("")) {
            loginPassText.setText("Изменить пароль или удалить");
        }
    }

    @Override
    public void finish() {
        dbManagerSettings.close();
        super.finish();
    }

    public void read() {

        Cursor cursor = dbManagerSettings.fetch();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(DBOpenHelper.USER_ID));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(DBOpenHelper.USER_PASSWORD));
                pass = password;
                id = ID;
            } while (cursor.moveToNext());
        }
    }

    public  void loginPass(View view) {
        fragmentLoginPass = null;
        if (!fr_login_pass) {
            fragmentLoginPass = new LoginPasswordFragment();
            fr_login_pass = true;
        }
        else {
            fragmentLoginPass = new BlankFragment();
            fr_login_pass = false;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.loginPassword, fragmentLoginPass);
        ft.commit();
        read();
    }

    public void btnSavePass (View view) {

        if (pass.equals("")) {
            if (starPass.getText().toString().equals("")) {
                Toast.makeText(this, "Введите Пароль!",Toast.LENGTH_LONG).show();
            } else if (!newPass.getText().toString().equals(starPass.getText().toString())) {
                Toast.makeText(this, "Пароли не совпадают!",Toast.LENGTH_LONG).show();
            } else {
                dbManagerSettings.insert(newPass.getText().toString());
                Toast.makeText(this, "Готово!",Toast.LENGTH_LONG).show();
                loginPassText.setText("Изменить пароль или удалить");
                fr_login_pass = true;
                loginPass(view);
            }
        } else {
            if (starPass.getText().toString().equals("")) {
                Toast.makeText(this, "Введите старый Пароль!",Toast.LENGTH_LONG).show();
            } else if (!pass.equals(starPass.getText().toString())) {
                Toast.makeText(this, "Неверный старый Пароль!",Toast.LENGTH_LONG).show();
            } else if (newPass.getText().toString().equals("")) {
                Toast.makeText(this, "Введите новый Пароль!",Toast.LENGTH_LONG).show();
            } else {
                dbManagerSettings.update(Long.parseLong(id), newPass.getText().toString());
                Toast.makeText(this, "Готово!",Toast.LENGTH_LONG).show();
                fr_login_pass = true;
                loginPass(view);
            }
        }
    }

    public void btnDelPass (View view) {

        if (!pass.equals("")) {
            if (!starPass.getText().toString().equals(pass)) {
                Toast.makeText(this, "Введите старый Пароль!",Toast.LENGTH_LONG).show();
            } else {
                dbManagerSettings.delete(Long.parseLong(id));
                pass = "";
                loginPassText.setText("Установить пароль для входа");
                Toast.makeText(this, "Готово!",Toast.LENGTH_LONG).show();
                fr_login_pass = true;
                loginPass(view);
            }
        }
    }
}