package com.example.mydormitory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchStudy extends AppCompatActivity {

    ImageButton btn_search;
    Context context;
    EditText edSearch;
    ListView listSearch;
    DBManager dbManagerSearch;
    HashMap<String, String> studySearch = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_study);

        context = getApplicationContext();

        edSearch = (EditText) findViewById(R.id.edSearch);
        btn_search = (ImageButton) findViewById(R.id.btn_search_study);
        listSearch = (ListView) findViewById(R.id.listSearch);

        dbManagerSearch = new DBManager(this);
        try {
            dbManagerSearch.open();
        }catch (Exception e) {
            e.printStackTrace();
        }

        addListenerOnButton();
    }

    public void addListenerOnButton () {

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studySearch.clear();

                Cursor cursor = dbManagerSearch.fetchStudySearch(edSearch.getText().toString());
                if (cursor.moveToFirst()) {
                    do {
                        @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(DBOpenHelper.STUDY_ID));
                        @SuppressLint("Range") String fio = cursor.getString(cursor.getColumnIndex(DBOpenHelper.FIO));
                        studySearch.put(ID, fio);
                        System.out.println(fio);
                    } while (cursor.moveToNext());
                }

                listSearch.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, studySearch.values().toArray()));
            }
        });

        listSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemClicked, int i, long l) {

                TextView textItem = (TextView) itemClicked;
                String study = textItem.getText().toString();

                for (Map.Entry entry: studySearch.entrySet()
                     ) {
                    if (study.equals(entry.getValue())){
                        Intent intent = new Intent(context, StudyId.class);
                        intent.putExtra("ID", entry.getKey().toString());
                        startActivity(intent);
                        break;
                    }
                }
            }
        });
    }
}