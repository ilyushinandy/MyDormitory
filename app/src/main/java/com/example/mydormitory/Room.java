package com.example.mydormitory;

import static com.example.mydormitory.DataManager.focusDataManager;
import static com.example.mydormitory.Rooms.focusRooms;
import static com.example.mydormitory.Statistics.focusStats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mydormitory.adapter.StudyAdapter;
import com.example.mydormitory.model.Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room extends AppCompatActivity {

    RecyclerView studyRecycler;
    StudyAdapter studyAdapter;
    public static Context contextRoom;
    public static String id;
    DBManager dbManagerRoom;
    TextView room, kol;
    int n = 0;


    List<String> threeRoom = Arrays.asList("1А", "8", "16", "24", "32", "40", "48", "56", "64", "72", "80", "88", "96", "104",
            "112", "120", "128", "136", "144", "152", "160", "168", "176", "184", "192", "200", "208", "216", "224", "232", "240",
            "4А", "11", "19", "27", "35", "43", "51", "59", "67", "75", "83", "91", "99", "107", "115", "123", "131", "139", "147",
            "155", "163", "171", "179", "187", "195", "203", "211", "219", "227", "235", "243", "5А", "4", "12", "20", "28", "36",
            "44", "52", "60", "68", "76", "84", "92", "100", "108", "116", "124", "132", "140", "148", "156", "164", "172", "180",
            "188", "196", "204", "212", "220", "228", "236", "244", "8А", "7", "15", "23", "31", "39", "47", "55", "63", "71", "79",
            "87", "95", "103", "111", "119", "127", "135", "143", "151", "159", "167", "175", "183", "191", "199", "207", "215",
            "223","231", "239", "247");
    List<String> twoRoom = Arrays.asList("2А",	"9",	"17",	"25",	"33",	"41",	"49",	"57",	"65",	"73",	"81",
            "89",	"97",	"105",	"113",	"121",	"129",	"137",	"145",	"153",	"161",	"169",	"177",	"185",	"193",	"201",
            "209",	"217",	"225",	"233",	"241",	"3А",	"10",	"18",	"26",	"34",	"42",	"50",	"58",	"66",	"74",
            "82",	"90",	"98",	"106",	"114",	"122",	"130",	"138",	"146",	"154",	"162",	"170",	"178",	"186",	"194",
            "202",	"210",	"218",	"226",	"234",	"242",	"6А",	"5",	"13",	"21",	"29",	"37",	"45",	"53",	"61",
            "69",	"77",	"85",	"93",	"101",	"109",	"117",	"125",	"133",	"141",	"149",	"157",	"165",	"173",	"181",
            "189",	"197",	"205",	"213",	"221",	"229",	"237",	"245",	"7А",	"6",	"14",	"22",	"30",	"38",	"46",
            "54",	"62",	"70",	"78",	"86",	"94",	"102",	"110",	"118",	"126",	"134",	"142",	"150",	"158",	"166",
            "174",	"182",	"190",	"198",	"206",	"214",	"222",	"230",	"238",	"246");

    public static boolean focusRoom = false;
    public static boolean isFocusRoom() {
        return focusRoom;
    }
    public static void setFocusRoom(boolean focus) {
        Room.focusRoom = focus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        room = (TextView) findViewById(R.id.room);
        room.setText("Комната " + getIntent().getStringExtra("NumberRoom"));
        kol = (TextView) findViewById(R.id.kol);

        contextRoom = getApplicationContext();

        dbManagerRoom = new DBManager(this);
        try {
            dbManagerRoom.open();
        }catch (Exception e) {
            e.printStackTrace();
        }

        loadRoom();
    }

    @Override
    public void finish() {
        focusStats = true;
        focusRooms = true;
        focusDataManager = true;
        super.finish();
    }

    public void loadRoom() {

        List<Study> studyList = new ArrayList<>();
        Cursor cursor = null;
        if (getIntent().getStringExtra("NumberRoom").equals("!!!")){
            cursor = dbManagerRoom.fetchStudyErrorRooms();
        } else {
            cursor = dbManagerRoom.fetchStudyRoom(getIntent().getStringExtra("NumberRoom"));
        }
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(DBOpenHelper.STUDY_ID));
                @SuppressLint("Range") String fio = cursor.getString(cursor.getColumnIndex(DBOpenHelper.FIO));
                @SuppressLint("Range") String number_dog = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NUMBER_DOG));
                @SuppressLint("Range") String period_prog = cursor.getString(cursor.getColumnIndex(DBOpenHelper.PERIOD_PROG));
                @SuppressLint("Range") String group = cursor.getString(cursor.getColumnIndex(DBOpenHelper.GROUPA));
                @SuppressLint("Range") String telefon = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TELEFON));
                studyList.add(new Study(ID, fio, number_dog, period_prog, group,telefon));
                n++;
            } while (cursor.moveToNext());
        }

        setStudyRecycler(studyList);

        if (threeRoom.contains(getIntent().getStringExtra("NumberRoom"))){
            kol.setText("Проживают: " + n + "/3");
            if(n > 3) {
                kol.setTextColor(Color.RED);
            } else {
                kol.setTextColor(Color.BLACK);
            }
        } else if (twoRoom.contains(getIntent().getStringExtra("NumberRoom"))) {
            kol.setText("Проживают: " + n + "/2");
            if(n > 2) {
                kol.setTextColor(Color.RED);
            } else {
                kol.setTextColor(Color.BLACK);
            }
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && isFocusRoom()) {
            setFocusRoom(false);
            n = 0;
            loadRoom();
        }
    }

    private void setStudyRecycler(List<Study> studyList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        studyRecycler = findViewById(R.id.studies);
        studyRecycler.setLayoutManager(layoutManager);

        studyAdapter = new StudyAdapter(getApplicationContext(), studyList);
        studyRecycler.setAdapter(studyAdapter);
    }

    public void btn_add_room(View view) {
        Intent intent = new Intent(contextRoom, AddStudy.class);
        intent.putExtra("NumberRoom", getIntent().getStringExtra("NumberRoom"));
        startActivity(intent);
    }
}