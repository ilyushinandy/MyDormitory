package com.example.mydormitory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Statistics extends AppCompatActivity {

    TextView allStudy, leftStudy, rightStudy;
    Context context;
    DBManager dbManagerStats;
    int all_Study = 0, left_Study = 0, right_Study = 0;
    ListView listFreeRooms;

    List<String> leftRoom = Arrays.asList("1А",	"2А",	"3А",	"4А",	"5А",	"6А",	"7А",	"8А",	"4",	"5",	"6",	"7",	"8",	"9",	"10",	"11",	"12",
            "13",	"14",	"15",	"16",	"17",	"18",	"19",	"20",	"21",	"22",	"23",	"24",	"25",	"26",	"27",	"28",	"29",	"30",	"31",	"32",
            "33",	"34",	"35",	"36",	"37",	"38",	"39",	"40",	"41",	"42",	"43",	"44",	"45",	"46",	"47",	"48",	"49",	"50",	"51",	"52",
            "53",	"54",	"55",	"56",	"57",	"58",	"59",	"60",	"61",	"62",	"63",	"64",	"65",	"66",	"67",	"68",	"69",	"70",	"71",	"72",
            "73",	"74",	"75",	"76",	"77",	"78",	"79",	"80",	"81",	"82",	"83",	"84",	"85",	"86",	"87",	"88",	"89",	"90",	"91",	"92",
            "93",	"94",	"95",	"96",	"97",	"98",	"99",	"100",	"101",	"102",	"103",	"104",	"105",	"106",	"107",	"108",	"109",	"110",	"111",	"112",
            "113",	"114",	"115",	"116",	"117",	"118",	"119");
    List<String> rightRoom = Arrays.asList("120",	"121",	"122",	"123",	"124",	"125",	"126",	"127",	"128",	"129",	"130",	"131",	"132",
            "133",	"134",	"135",	"136",	"137",	"138",	"139",	"140",	"141",	"142",	"143",	"144",	"145",	"146",	"147",	"148",	"149",	"150",	"151",	"152",
            "153",	"154",	"155",	"156",	"157",	"158",	"159",	"160",	"161",	"162",	"163",	"164",	"165",	"166",	"167",	"168",	"169",	"170",	"171",	"172",
            "173",	"174",	"175",	"176",	"177",	"178",	"179",	"180",	"181",	"182",	"183",	"184",	"185",	"186",	"187",	"188",	"189",	"190",	"191",	"192",
            "193",	"194",	"195",	"196",	"197",	"198",	"199",	"200",	"201",	"202",	"203",	"204",	"205",	"206",	"207",	"208",	"209",	"210",	"211",	"212",
            "213",	"214",	"215",	"216",	"217",	"218",	"219",	"220",	"221",	"222",	"223",	"224",	"225",	"226",	"227",	"228",	"229",	"230",	"231",	"232",
            "233",	"234",	"235",	"236",	"237",	"238",	"239",	"240",	"241",	"242",	"243",	"244",	"245",	"246",	"247");
    List<String> allRoom = Arrays.asList("1А",	"2А",	"3А",	"4А",	"5А",	"6А",	"7А",	"8А",	"4",	"5",	"6",	"7",	"8",	"9",	"10",	"11",	"12",
            "13",	"14",	"15",	"16",	"17",	"18",	"19",	"20",	"21",	"22",	"23",	"24",	"25",	"26",	"27",	"28",	"29",	"30",	"31",	"32",
            "33",	"34",	"35",	"36",	"37",	"38",	"39",	"40",	"41",	"42",	"43",	"44",	"45",	"46",	"47",	"48",	"49",	"50",	"51",	"52",
            "53",	"54",	"55",	"56",	"57",	"58",	"59",	"60",	"61",	"62",	"63",	"64",	"65",	"66",	"67",	"68",	"69",	"70",	"71",	"72",
            "73",	"74",	"75",	"76",	"77",	"78",	"79",	"80",	"81",	"82",	"83",	"84",	"85",	"86",	"87",	"88",	"89",	"90",	"91",	"92",
            "93",	"94",	"95",	"96",	"97",	"98",	"99",	"100",	"101",	"102",	"103",	"104",	"105",	"106",	"107",	"108",	"109",	"110",	"111",	"112",
            "113",	"114",	"115",	"116",	"117",	"118",	"119",	"120",	"121",	"122",	"123",	"124",	"125",	"126",	"127",	"128",	"129",	"130",	"131",	"132",
            "133",	"134",	"135",	"136",	"137",	"138",	"139",	"140",	"141",	"142",	"143",	"144",	"145",	"146",	"147",	"148",	"149",	"150",	"151",	"152",
            "153",	"154",	"155",	"156",	"157",	"158",	"159",	"160",	"161",	"162",	"163",	"164",	"165",	"166",	"167",	"168",	"169",	"170",	"171",	"172",
            "173",	"174",	"175",	"176",	"177",	"178",	"179",	"180",	"181",	"182",	"183",	"184",	"185",	"186",	"187",	"188",	"189",	"190",	"191",	"192",
            "193",	"194",	"195",	"196",	"197",	"198",	"199",	"200",	"201",	"202",	"203",	"204",	"205",	"206",	"207",	"208",	"209",	"210",	"211",	"212",
            "213",	"214",	"215",	"216",	"217",	"218",	"219",	"220",	"221",	"222",	"223",	"224",	"225",	"226",	"227",	"228",	"229",	"230",	"231",	"232",
            "233",	"234",	"235",	"236",	"237",	"238",	"239",	"240",	"241",	"242",	"243",	"244",	"245",	"246",	"247");
    List<String> filledRooms = new ArrayList<>();
    List<String> freeRooms = new ArrayList<>();

    public static boolean focusStats = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        allStudy = (TextView) findViewById(R.id.allStudy);
        leftStudy = (TextView) findViewById(R.id.leftStudy);
        rightStudy = (TextView) findViewById(R.id.rigthStudy);
        listFreeRooms = (ListView) findViewById(R.id.freeRooms);
        context = getApplicationContext();
        dbManagerStats = new DBManager(this);
        try {
            dbManagerStats.open();
        }catch (Exception e) {
            e.printStackTrace();
        }
        loadStats();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && focusStats) {
            focusStats = false;
            left_Study = 0;
            right_Study = 0;
            all_Study = 0;
            freeRooms.clear();
            loadStats();
        }
    }

    public void loadStats() {

        Cursor cursor = dbManagerStats.fetchStudy();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String number_room = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NUMBER_ROOM));
                all_Study++;
                if (leftRoom.contains(number_room)) {
                    left_Study++;
                    filledRooms.add(number_room);
                } else if (rightRoom.contains(number_room)) {
                    right_Study++;
                    filledRooms.add(number_room);
                }
            } while (cursor.moveToNext());
        }

        allStudy.setText(Integer.toString(all_Study));
        leftStudy.setText(Integer.toString(left_Study));
        rightStudy.setText(Integer.toString(right_Study));

        for (String i : allRoom
             ) {
            if (!filledRooms.contains(i)) {
                freeRooms.add(i);
            }
        }
        listFreeRooms.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, freeRooms));

        listFreeRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemClicked, int i, long l) {

                TextView textItem = (TextView) itemClicked;
                String room = textItem.getText().toString();

                Intent intent = new Intent(context, Room.class);
                intent.putExtra("NumberRoom", room);
                startActivity(intent);
            }
        });
    }
}