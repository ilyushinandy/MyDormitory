package com.example.mydormitory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "DORMITORY_3.DB";
    static final int DATABASE_VERSION = 9;

    static final String DATABASE_TABLE_U = "USER";

    static final String USER_ID= "_ID";
    static final String USER_PASSWORD= "password";

    static final String DATABASE_TABLE_S = "STUDY";

    static final String STUDY_ID = "_ID";
    static final String FIO = "fio";
    static final String NUMBER_DOG = "number_dog";
    static final String PERIOD_PROG = "period_prog";
    static final String GROUPA = "groupa";
    static final String NUMBER_ROOM = "number_room";
    static final String TELEFON = "telefon";
    static final String FIO_ROD = "fio_rod";
    static final String TEL_ROD = "tel_rod";
    static final String SERIYA = "seriya";
    static final String NOMER = "nomer";
    static final String KEM_V = "kem_v";
    static final String DATA_V = "data_v";
    static final String POL = "pol";
    static final String DATA_R = "data_r";
    static final String MESTO_R = "mesto_r";
    static final String MESTO_G = "mesto_g";

    private static final String CREATE_DB_QUERY_U = "CREATE TABLE " + DATABASE_TABLE_U + " ( "//запрос на создание таблицы пользователь
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ USER_PASSWORD + " TEXT NOT NULL"  + ");";

    private static final String CREATE_DB_QUERY_S = "CREATE TABLE " + DATABASE_TABLE_S + " ( "//запрос на создание таблицы студенты
            + STUDY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FIO + " TEXT NOT NULL, " + NUMBER_DOG + " TEXT NOT NULL," + GROUPA + " TEXT NOT NULL,"
            + PERIOD_PROG + " TEXT NOT NULL," + NUMBER_ROOM + " TEXT NOT NULL," + TELEFON + " TEXT NOT NULL," + FIO_ROD + " TEXT NOT NULL,"
            + TEL_ROD + " TEXT NOT NULL," + SERIYA + " TEXT NOT NULL," + NOMER + " TEXT NOT NULL," + KEM_V + " TEXT NOT NULL," + DATA_V + " TEXT NOT NULL,"
            + POL + " TEXT NOT NULL," + DATA_R + " TEXT NOT NULL," + MESTO_R + " TEXT NOT NULL," + MESTO_G + " TEXT NOT NULL" + ");";

    public DBOpenHelper( Context context) {//метод создания бд и проверки версии
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//запрос на создание таблицы пользователь
        sqLiteDatabase.execSQL(CREATE_DB_QUERY_U);
    }

    public void onCreateStudy(SQLiteDatabase sqLiteDatabase) {//запрос на создание таблицы студенты
        sqLiteDatabase.execSQL(CREATE_DB_QUERY_S);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//метод обновления версии бд
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_U);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_S);
        onCreate(sqLiteDatabase);
        onCreateStudy(sqLiteDatabase);
    }
}