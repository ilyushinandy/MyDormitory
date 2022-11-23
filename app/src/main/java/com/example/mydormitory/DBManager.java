package com.example.mydormitory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DBOpenHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager (Context ctx) {
        context = ctx;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBOpenHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public DBManager openFirst() throws SQLException {
        dbHelper = new DBOpenHelper(context);
        database = dbHelper.getWritableDatabase();
        dbHelper.onCreateStudy(database);
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insertStudy (String fio, String number_dog, String period, String groupa, String number_room, String telefon, String fio_rod, String tel_rod, String seriya,
                             String nomer, String kem_v, String data_v, String pol, String data_r, String mesto_r, String mesto_g) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBOpenHelper.FIO, fio);
        contentValues.put(DBOpenHelper.NUMBER_DOG, number_dog);
        contentValues.put(DBOpenHelper.PERIOD_PROG, period);
        contentValues.put(DBOpenHelper.GROUPA, groupa);
        contentValues.put(DBOpenHelper.NUMBER_ROOM, number_room);
        contentValues.put(DBOpenHelper.TELEFON, telefon);
        contentValues.put(DBOpenHelper.FIO_ROD, fio_rod);
        contentValues.put(DBOpenHelper.TEL_ROD, tel_rod);
        contentValues.put(DBOpenHelper.SERIYA, seriya);
        contentValues.put(DBOpenHelper.NOMER, nomer);
        contentValues.put(DBOpenHelper.KEM_V, kem_v);
        contentValues.put(DBOpenHelper.DATA_V, data_v);
        contentValues.put(DBOpenHelper.POL, pol);
        contentValues.put(DBOpenHelper.DATA_R, data_r);
        contentValues.put(DBOpenHelper.MESTO_R, mesto_r);
        contentValues.put(DBOpenHelper.MESTO_G, mesto_g);
        database.insert(DBOpenHelper.DATABASE_TABLE_S, null, contentValues);
    }

    public Cursor fetchStudy() {//метод считывания из бд с запросом на всю таблицу
        String [] columns = new String[] {DBOpenHelper.STUDY_ID, DBOpenHelper.FIO, DBOpenHelper.NUMBER_DOG, DBOpenHelper.PERIOD_PROG, DBOpenHelper.GROUPA, DBOpenHelper.NUMBER_ROOM,
                DBOpenHelper.TELEFON, DBOpenHelper.FIO_ROD,DBOpenHelper.TEL_ROD, DBOpenHelper.SERIYA, DBOpenHelper.NOMER, DBOpenHelper.KEM_V, DBOpenHelper.DATA_V,
                DBOpenHelper.POL, DBOpenHelper.DATA_R,DBOpenHelper.MESTO_R, DBOpenHelper.MESTO_G};
        Cursor cursor = database.query(DBOpenHelper.DATABASE_TABLE_S, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchStudyRoom(String number_room) {//метод считывания из бд с запросом поиска по комнате
        String [] columns = new String[] {DBOpenHelper.STUDY_ID, DBOpenHelper.FIO, DBOpenHelper.NUMBER_DOG, DBOpenHelper.PERIOD_PROG, DBOpenHelper.GROUPA, DBOpenHelper.NUMBER_ROOM,
                DBOpenHelper.TELEFON};
        Cursor cursor = database.query(DBOpenHelper.DATABASE_TABLE_S, columns, "number_room = ?", new String[] {number_room}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchStudySearch(String fio) {//метод считывания из бд с запросом поиска по фио
        String [] columns = new String[] {DBOpenHelper.STUDY_ID, DBOpenHelper.FIO};
        Cursor cursor = database.query(DBOpenHelper.DATABASE_TABLE_S, columns, DBOpenHelper.FIO + " LIKE ?", new String[] {"%" + fio + "%"}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchStudyID(String id) {//метод считывания из бд с запросом поиска по id
        String [] columns = new String[] {DBOpenHelper.STUDY_ID, DBOpenHelper.FIO, DBOpenHelper.NUMBER_DOG, DBOpenHelper.PERIOD_PROG, DBOpenHelper.GROUPA, DBOpenHelper.NUMBER_ROOM,
                DBOpenHelper.TELEFON, DBOpenHelper.FIO_ROD,DBOpenHelper.TEL_ROD, DBOpenHelper.SERIYA, DBOpenHelper.NOMER, DBOpenHelper.KEM_V, DBOpenHelper.DATA_V,
                DBOpenHelper.POL, DBOpenHelper.DATA_R,DBOpenHelper.MESTO_R, DBOpenHelper.MESTO_G};
        Cursor cursor = database.query(DBOpenHelper.DATABASE_TABLE_S, columns, "_ID = ?", new String[] {id}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor fetchStudyErrorRooms() {//метод считывания из бд с запросом поиска ошибочных номеров комнат
        String [] columns = new String[] {DBOpenHelper.STUDY_ID, DBOpenHelper.FIO, DBOpenHelper.NUMBER_DOG, DBOpenHelper.PERIOD_PROG, DBOpenHelper.GROUPA, DBOpenHelper.NUMBER_ROOM,
                DBOpenHelper.TELEFON};
        Cursor cursor = database.query(DBOpenHelper.DATABASE_TABLE_S, columns, DBOpenHelper.NUMBER_ROOM + " LIKE ?", new String[] {"%" + "!!!" + "%"}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int updateStudy(long _id, String fio, String number_dog, String period, String groupa, String number_room, String telefon, String fio_rod, String tel_rod, String seriya,
                           String nomer, String kem_v, String data_v, String pol, String data_r, String mesto_r, String mesto_g) {//запрос на обновление данных о студенте
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBOpenHelper.FIO, fio);
        contentValues.put(DBOpenHelper.NUMBER_DOG, number_dog);
        contentValues.put(DBOpenHelper.PERIOD_PROG, period);
        contentValues.put(DBOpenHelper.GROUPA, groupa);
        contentValues.put(DBOpenHelper.NUMBER_ROOM, number_room);
        contentValues.put(DBOpenHelper.TELEFON, telefon);
        contentValues.put(DBOpenHelper.FIO_ROD, fio_rod);
        contentValues.put(DBOpenHelper.TEL_ROD, tel_rod);
        contentValues.put(DBOpenHelper.SERIYA, seriya);
        contentValues.put(DBOpenHelper.NOMER, nomer);
        contentValues.put(DBOpenHelper.KEM_V, kem_v);
        contentValues.put(DBOpenHelper.DATA_V, data_v);
        contentValues.put(DBOpenHelper.POL, pol);
        contentValues.put(DBOpenHelper.DATA_R, data_r);
        contentValues.put(DBOpenHelper.MESTO_R, mesto_r);
        contentValues.put(DBOpenHelper.MESTO_G, mesto_g);
        int ret = database.update(DBOpenHelper.DATABASE_TABLE_S, contentValues, DBOpenHelper.STUDY_ID + "=" + _id, null);
        return ret;
    }


    public void deleteStudy(long _id) {//удаление студента
        database.delete(DBOpenHelper.DATABASE_TABLE_S, DBOpenHelper.STUDY_ID + "=" + _id, null);
    }

    public void deleteAllStudy() {//удаление всей таблицы студенты
        database.execSQL("DROP TABLE IF EXISTS " + DBOpenHelper.DATABASE_TABLE_S);
        dbHelper.onCreateStudy(database);
    }

    public void insert (String password) {//запрос на вставку в таблицу пользователь
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBOpenHelper.USER_PASSWORD, password);
        database.insert(DBOpenHelper.DATABASE_TABLE_U, null, contentValues);
    }

    public Cursor fetch() {//запрос на считывание из таблицы всех записей
        String [] columns = new String[] {DBOpenHelper.USER_ID, DBOpenHelper.USER_PASSWORD};
        Cursor cursor = database.query(DBOpenHelper.DATABASE_TABLE_U, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBOpenHelper.USER_PASSWORD, password);
        int ret = database.update(DBOpenHelper.DATABASE_TABLE_U, contentValues, DBOpenHelper.USER_ID + "=" + _id, null);
        return ret;
    }

    public void delete(long _id) {
        database.delete(DBOpenHelper.DATABASE_TABLE_U, DBOpenHelper.USER_ID + "=" + _id, null);
    }

    public void deleteAll() {
        database.execSQL("DROP TABLE IF EXISTS " + DBOpenHelper.DATABASE_TABLE_U);
        dbHelper.onCreate(database);
    }
}