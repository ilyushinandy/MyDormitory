package com.example.mydormitory;

import static com.example.mydormitory.Room.setFocusRoom;
import static com.example.mydormitory.StudyId.setFocusStudy;
import static com.example.mydormitory.fragments.FragmentDopInfo.edFioRod;
import static com.example.mydormitory.fragments.FragmentDopInfo.edTelRod;
import static com.example.mydormitory.fragments.PasportFragment.edNomer;
import static com.example.mydormitory.fragments.PasportFragment.edSeriya;
import static com.example.mydormitory.fragments.PasportFragment.pol;
import static com.example.mydormitory.fragments.PasportFragment.edDataR;
import static com.example.mydormitory.fragments.PasportFragment.edDataV;
import static com.example.mydormitory.fragments.PasportFragment.edKemV;
import static com.example.mydormitory.fragments.PasportFragment.edMestoR;
import static com.example.mydormitory.fragments.PasportFragment.edMestoG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydormitory.fragments.BlankFragment;
import com.example.mydormitory.fragments.FragmentDopInfo;
import com.example.mydormitory.fragments.PasportFragment;

import java.util.Arrays;
import java.util.List;

public class AddStudy extends AppCompatActivity {

    Button btn_save;
    Context context;
    Toast toast;
    EditText edFio, edNumber_dog, edPeriod, edGroup, edNumberRoom, edTelefon;
    TextView addStudy;
    DBManager dbManagerAddStudy;
    Fragment fragmentDopInfo, frPasDann;
    public static String ID, FioRod, TelROd, Seriya, Nomer, KemV, DataV, DataR, MestoR, MestoG, Pol = "";

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

    boolean fr_dop_info = false, fr_pas_dan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_study);

        btn_save = (Button) findViewById(R.id.btn_save_study);
        edFio = (EditText) findViewById(R.id.edFio);
        edNumber_dog = (EditText) findViewById(R.id.edNumber_dog);
        edTelefon = (EditText) findViewById(R.id.edtelefon);
        edPeriod = (EditText) findViewById(R.id.edperiod_prog);
        edGroup = (EditText) findViewById(R.id.edGroup);
        edNumberRoom = (EditText) findViewById(R.id.edNumber_room);
        addStudy = (TextView) findViewById(R.id.addStudy);

        ID = getIntent().getStringExtra("ID");
        edFio.setText(getIntent().getStringExtra("Fio"));
        edNumber_dog.setText(getIntent().getStringExtra("Number_dog"));
        edTelefon.setText(getIntent().getStringExtra("Telefon"));
        edPeriod.setText(getIntent().getStringExtra("Period"));
        edGroup.setText(getIntent().getStringExtra("Group"));
        edNumberRoom.setText(getIntent().getStringExtra("NumberRoom"));
        FioRod = getIntent().getStringExtra("FioRod");
        TelROd = getIntent().getStringExtra("TelRod");
        Seriya = getIntent().getStringExtra("Seriya");
        Nomer  = getIntent().getStringExtra("Nomer");
        KemV = getIntent().getStringExtra("KemV");
        DataV  = getIntent().getStringExtra("DataV");
        Pol = getIntent().getStringExtra("Pol");
        DataR  = getIntent().getStringExtra("DataR");
        MestoR = getIntent().getStringExtra("MestoR");
        MestoG = getIntent().getStringExtra("MestoG");

        if (ID != null) {
            addStudy.setText("Редактирование студента");
        }

        context = getApplicationContext();

        dbManagerAddStudy = new DBManager(this);
        try {
            dbManagerAddStudy.open();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finish() {
        dbManagerAddStudy.close();
        super.finish();
    }

    public  void DopInfo(View view) {//открытие фрагмента дополнительная информация
        fragmentDopInfo = null;
        if (!fr_dop_info) {
            fragmentDopInfo = new FragmentDopInfo();
            fr_dop_info = true;
        }
        else {
            fragmentDopInfo = new BlankFragment();
            fr_dop_info = false;
            fr_pas_dan = false;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.FrDopInfo, fragmentDopInfo);
        ft.commit();
    }
    public  void PasportDann(View view) {//открытие фрагмента паспортные данные
        frPasDann = null;
        if (!fr_pas_dan) {
            frPasDann = new PasportFragment();
            fr_pas_dan = true;
        }
        else {
            frPasDann = new BlankFragment();
            fr_pas_dan = false;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.PasportDann, frPasDann);
        ft.commit();
    }

    public boolean checkEdit() {//проверка полей ввода и правильность номера комнаты
        if (edFio.getText().toString().equals("") || edNumber_dog.getText().toString().equals("") || edPeriod.getText().toString().equals("") ||
                edGroup.getText().toString().equals("") || edNumberRoom.getText().toString().equals("") || edTelefon.getText().toString().equals("")) {
            toast = Toast.makeText(context, "Введите данные для обязательного заполнения!",Toast.LENGTH_LONG);
            toast.show();
            return false;
        } else {
            String number = edNumberRoom.getText().toString().trim();
            if (number.contains("a") || number.contains("A") || number.contains("а")) {
                number = number.charAt(0) + "А";
                edNumberRoom.setText(number);
            }
            if (allRoom.contains(number)){
                edNumberRoom.setText(number);
                return true;
            } else {
                edNumberRoom.setText(number + "!!!");
                toast = Toast.makeText(context, "Номер комнаты некорректый!",Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
        }
    }

    public void saveStudy(View view) {//добавление студента или обновление данных о стуженте
        if (checkEdit()) {
            if (ID == null) {//проверка обновление
                if (fr_dop_info && fr_pas_dan) {
                    dbManagerAddStudy.insertStudy(edFio.getText().toString(), edNumber_dog.getText().toString(), edPeriod.getText().toString(), edGroup.getText().toString(),
                            edNumberRoom.getText().toString(),edTelefon.getText().toString(), edFioRod.getText().toString(), edTelRod.getText().toString(),
                            edSeriya.getText().toString(), edNomer.getText().toString(), edKemV.getText().toString(), edDataV.getText().toString(), pol,
                            edDataR.getText().toString(), edMestoR.getText().toString(), edMestoG.getText().toString());
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                    toast.show();
                } else if (!fr_pas_dan && fr_dop_info) {
                    dbManagerAddStudy.insertStudy(edFio.getText().toString(), edNumber_dog.getText().toString(), edPeriod.getText().toString(), edGroup.getText().toString(),
                            edNumberRoom.getText().toString(), edTelefon.getText().toString(), edFioRod.getText().toString(), edTelRod.getText().toString(),
                            "", "", "", "", "", "", "", "");
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    dbManagerAddStudy.insertStudy(edFio.getText().toString(), edNumber_dog.getText().toString(), edPeriod.getText().toString(), edGroup.getText().toString(),
                            edNumberRoom.getText().toString(), edTelefon.getText().toString(), "", "",
                            "", "", "", "", "", "", "", "");
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                    toast.show();
                }
                setFocusRoom(true);
            } else {
                if (fr_dop_info && fr_pas_dan) {
                    dbManagerAddStudy.updateStudy(Long.parseLong(ID), edFio.getText().toString(), edNumber_dog.getText().toString(), edPeriod.getText().toString(), edGroup.getText().toString(),
                            edNumberRoom.getText().toString(),edTelefon.getText().toString(), edFioRod.getText().toString(), edTelRod.getText().toString(),
                            edSeriya.getText().toString(), edNomer.getText().toString(), edKemV.getText().toString(), edDataV.getText().toString(), pol,
                            edDataR.getText().toString(), edMestoR.getText().toString(), edMestoG.getText().toString());
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                    toast.show();
                } else if (!fr_pas_dan && fr_dop_info) {
                    dbManagerAddStudy.updateStudy(Long.parseLong(ID), edFio.getText().toString(), edNumber_dog.getText().toString(), edPeriod.getText().toString(), edGroup.getText().toString(),
                            edNumberRoom.getText().toString(),edTelefon.getText().toString(), edFioRod.getText().toString(), edTelRod.getText().toString(),
                            Seriya, Nomer, KemV, DataV, Pol, DataR, MestoR, MestoG);
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    dbManagerAddStudy.updateStudy(Long.parseLong(ID), edFio.getText().toString(), edNumber_dog.getText().toString(), edPeriod.getText().toString(), edGroup.getText().toString(),
                            edNumberRoom.getText().toString(),edTelefon.getText().toString(), FioRod, TelROd,
                            Seriya, Nomer, KemV, DataV, Pol, DataR, MestoR, MestoG);
                    toast = Toast.makeText(context, "Готово!",Toast.LENGTH_LONG);
                    toast.show();
                }
                setFocusStudy(true);
            }
            finish();
        }
    }
}