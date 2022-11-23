package com.example.mydormitory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends MainActivity {

    Button btn_save, btn_read, btn_edit, btn_del;
    Context context;
    Toast toast;
    EditText edRegPass, edId, edUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        addListenerOnButton();
    }

    private void addListenerOnButton () {
        btn_save = (Button) findViewById(R.id.button_save);
        btn_edit = (Button) findViewById(R.id.button_edit);
        btn_read = (Button) findViewById(R.id.button_read);
        btn_del = (Button) findViewById(R.id.button_del);
        edId = (EditText) findViewById(R.id.editId);
        edRegPass = (EditText) findViewById(R.id.editRegPass);
        edUser = (EditText) findViewById(R.id.editUser);
        context = getApplicationContext();

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dbManager.fetch();

                if (cursor.moveToFirst()) {
                    do {
                        @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(DBOpenHelper.USER_ID));
                        @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(DBOpenHelper.USER_PASSWORD));
                        edUser.setText("Пользователь:\n" +"ID:" + ID + "\nПароль:" + password);

                    } while (cursor.moveToNext());
                }
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edId.getText().toString().equals("")) {
                    toast = Toast.makeText(context, "Введите ID!",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    dbManager.update(Long.parseLong(edId.getText().toString()), edRegPass.getText().toString());
                    edUser.setText("");
                }
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edId.getText().toString().equals("")) {
                    toast = Toast.makeText(context, "Введите ID!",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    dbManager.delete(Long.parseLong(edId.getText().toString()));
                    toast = Toast.makeText(context, "Пользователь удален!",Toast.LENGTH_LONG);
                    toast.show();
                    edUser.setText("");
                }
            }
        });

        btn_del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dbManager.deleteAll();
                toast = Toast.makeText(context, "Таблица удалена!",Toast.LENGTH_LONG);
                toast.show();
                edUser.setText("");
                return false;
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edRegPass.getText().toString().equals("")) {
                    toast = Toast.makeText(context, "Введите Пароль!",Toast.LENGTH_LONG);
                } else {
                    dbManager.insert(edRegPass.getText().toString());
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                }
                toast.show();
            }
        });
    }

    public void readLogin() {}
}