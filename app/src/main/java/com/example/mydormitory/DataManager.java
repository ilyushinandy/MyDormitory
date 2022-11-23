package com.example.mydormitory;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataManager extends AppCompatActivity {

    Context context;
    DBManager dbManagerBD;
    Toast toast;
    TextView textInfoBD, textErrorRooms;
    boolean errorRoom = false;
    String errorRoomLoad = "";
    public static boolean focusDataManager = false;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_manager);

        textInfoBD = (TextView) findViewById(R.id.info_bd_text);
        textErrorRooms = (TextView) findViewById(R.id.textErrorRoom);

        context = getApplicationContext();

        textInfoBD.setText("Для сохранения базы данных в формате MS Excel, нажмите \"Сохранить БД\"." +
                "\n\nДля загрузки базы данных из файла Excel фомата \".xls\", сохраните БД, скопируйте файл, " +
                "добавьте изменения, замените в исходной папке, и нажмите \"Загрузить БД\"" +
                "\n\nФайл \"Студенты общежития.xls\" хранится в папке:" + context.getExternalFilesDir(null).toString());

        dbManagerBD = new DBManager(this);
        try {
            dbManagerBD.open();
        }catch (Exception e) {
            e.printStackTrace();
        }
        loadDM();
    }

    public void loadDM() {
        Cursor cursor = dbManagerBD.fetchStudyErrorRooms();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String number_room = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NUMBER_ROOM));
                errorRoomLoad = number_room;
            } while (cursor.moveToNext());
        }
        if (errorRoomLoad.equals("")){
            textErrorRooms.setVisibility(View.GONE);
        } else {
            textErrorRooms.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && focusDataManager) {
            focusDataManager = false;
            errorRoomLoad = "";
            loadDM();
        }
    }

    public void errorBtn(View view){
        Intent intent = new Intent(context, Room.class);
        intent.putExtra("NumberRoom", "!!!");
        context.startActivity(intent);
    }

    public void saveBD (View view) {//сохранение бд, если нет данных, то сохраняется пустой шаблон

        Workbook book = new HSSFWorkbook();//создание книги
        // создание листа
        Sheet sheet = book.createSheet("Студенты общежития");
        //создание строки заголовка
        Row row_0 = sheet.createRow(0);
        //создание столбцов заголовков
        row_0.createCell(0).setCellValue("ФИО");
        row_0.createCell(1).setCellValue("Номер договора");
        row_0.createCell(2).setCellValue("Период проживания");
        row_0.createCell(3).setCellValue("Группа");
        row_0.createCell(4).setCellValue("Номер комнаты");
        row_0.createCell(5).setCellValue("Телефон");
        row_0.createCell(6).setCellValue("ФИО родителей");
        row_0.createCell(7).setCellValue("Телефон родителей");
        row_0.createCell(8).setCellValue("Серия");
        row_0.createCell(9).setCellValue("Номер");
        row_0.createCell(10).setCellValue("Кем выдан");
        row_0.createCell(11).setCellValue("Дата выдачи");
        row_0.createCell(12).setCellValue("Пол");
        row_0.createCell(13).setCellValue("Дата рождения");
        row_0.createCell(14).setCellValue("Место рождения");
        row_0.createCell(15).setCellValue("Место жительства");

        int Row = 1;
        Cursor cursor = dbManagerBD.fetchStudy();//считывание из базы данных
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

                Row row = sheet.createRow(Row);//создание строки
                Cell cell = row.createCell(0);//создание столбца
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(fio);//запись данных в ячейку

                cell = row.createCell(1);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(number_dog);

                cell = row.createCell(2);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(period_prog);

                cell = row.createCell(3);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(group);

                cell = row.createCell(4);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(number_room);

                cell = row.createCell(5);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(telefon);

                cell = row.createCell(6);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(fio_rod);

                cell = row.createCell(7);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(tel_rod);

                cell = row.createCell(8);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(seriya);

                cell = row.createCell(9);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(nomer);

                cell = row.createCell(10);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(kem_v);

                cell = row.createCell(11);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(data_v);

                cell = row.createCell(12);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(pol);

                cell = row.createCell(13);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(data_r);

                cell = row.createCell(14);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(mesto_r);

                cell = row.createCell(15);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(mesto_g);

                Row++;

            } while (cursor.moveToNext());
        }

        boolean isSuccess;//создание файла
        File fileOutput = new File(context.getExternalFilesDir(null), "Студенты общежития.xls");
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileOutput);
            book.write(fileOutputStream);//запись в файл
            Log.e(TAG, "Writing file" + fileOutput);
            isSuccess = true;
        } catch (IOException e) {
            Log.e(TAG, "Error writing Exception: ", e);
            isSuccess = false;
        } catch (Exception e) {
            Log.e(TAG, "Failed to save file due to Exception: ", e);
            isSuccess = false;
        } finally {
            try {
                if (null != fileOutputStream) {
                    fileOutputStream.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                isSuccess = false;
            }
        }

        if (isSuccess) {
            toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(context, "Ошибка!",Toast.LENGTH_LONG);
        }
        toast.show();
    }

    public void loadBD(View view) {//загрузка из файла

        // получаем файл в формате xls
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(new File(context.getExternalFilesDir(null), "Студенты общежития.xls"));
        } catch (Exception e) {//FileNotFoundException
            e.printStackTrace();
            toast = Toast.makeText(context, "Ошибка!\nПроверьте наличие файла, имя файла и формат!", Toast.LENGTH_LONG);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            if( v != null) v.setGravity(Gravity.CENTER);
            toast.show();
        }

        // формируем из файла экземпляр HSSFWorkbook
        Workbook workbook = null;
        try {
            if(fileInput != null) {
                workbook = new HSSFWorkbook(fileInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
            toast = Toast.makeText(context, "Ошибка!\nПроверьте формат файла \".xls\"!", Toast.LENGTH_LONG);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            if( v != null) v.setGravity(Gravity.CENTER);
            toast.show();
        }
        if (workbook != null) {
            // выбираем первый лист для обработки
            Sheet sheet = workbook.getSheetAt(0);
            // получаем Iterator по всем строкам в листе
            Iterator<Row> it = sheet.iterator();
            String[] insert = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
            int n = 0;
            dbManagerBD.deleteAllStudy();//очищаем бд
            //проходим по всему листу
            while (it.hasNext()) {
                Row row = it.next();
                if (row.getRowNum() > 0) {
                    // получаем Iterator по всем ячейкам в строке
                    Iterator<Cell> cells = row.iterator();
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        //перебираем возможные типы ячеек
                        int cellType = cell.getCellType();
                        //перебираем возможные типы ячеек
                        switch (cellType) {
                            case Cell.CELL_TYPE_STRING:
                                insert[n] = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                insert[n] = "" + cell.getNumericCellValue();
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                System.out.println("BLANK");
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                System.out.println("ERROR");
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                System.out.println("Formuls");
                                break;
                            default:
                                insert[n] = "Ошибка формата!";
                                break;
                        }
                        n++;
                    }

                    if (!(insert[0].equals("") || insert[1].equals("") || insert[2].equals("") || insert[3].equals("") ||
                            insert[4].equals(""))) {
                        if (insert[4].contains("a") || insert[4].contains("A") || insert[4].contains("а")) {
                            insert[4] = insert[4].charAt(0) + "А";
                        }
                        insert[4] = insert[4].trim();
                        if (!allRoom.contains(insert[4])) {
                            insert[4] = insert[4] + "!!!";
                            errorRoom = true;
                        }
                        if (insert[5].equals("")) {
                            insert[5] = "7---------";
                        }
                        if (insert[12].equals("M") || insert[12].equals("m") || insert[12].equals("м")) {
                            insert[12] = "М";
                        }
                        //вставка в бд
                        dbManagerBD.insertStudy(insert[0], insert[1], insert[2], insert[3],insert[4], insert[5], insert[6], insert[7],
                                insert[8], insert[9], insert[10], insert[11], insert[12], insert[13], insert[14], insert[15]);

                        Arrays.fill(insert, "");
                    }
                    n = 0;
                }
            }
            try {
                fileInput.close();
                if (errorRoom) {
                    textErrorRooms.setVisibility(View.VISIBLE);
                    toast = Toast.makeText(context, "Готово! Есть ошибки!",Toast.LENGTH_LONG);
                } else {
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                }
                toast.show();
            } catch (IOException e) {
                e.printStackTrace();
                toast = Toast.makeText(context, "Ошибка!",Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    public void delAll(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        //заголовок
        builder.setTitle("Подтверидите очистку БД!");
        //ок
        builder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss(); // Close Dialog
                dbManagerBD.deleteAllStudy();
                Toast.makeText(view.getContext(), "Готово!",Toast.LENGTH_LONG).show();
            }
        });
        //нет
        builder.setCancelable(true);
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //выход из диалолг окна
                dialog.cancel();
            }
        });
        //создание диалог окна
        AlertDialog alert = builder.create();
        alert.show();
    }
}