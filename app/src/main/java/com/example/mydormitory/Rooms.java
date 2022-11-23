package com.example.mydormitory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rooms extends AppCompatActivity {

    DBManager dbManagerRooms;
    public static boolean focusRooms = false;

    Button btn_room_1a, btn_room_2a, btn_room_3a, btn_room_4a, btn_room_5a, btn_room_6a, btn_room_7a, btn_room_8a, btn_room_4, btn_room_5, btn_room_6, btn_room_7,
            btn_room_8, btn_room_9, btn_room_10, btn_room_11, btn_room_12, btn_room_13, btn_room_14, btn_room_15, btn_room_16, btn_room_17, btn_room_18, btn_room_19,
            btn_room_20, btn_room_30, btn_room_40, btn_room_50, btn_room_60, btn_room_70, btn_room_80, btn_room_90, btn_room_100, btn_room_110, btn_room_120, btn_room_130,
            btn_room_21, btn_room_31, btn_room_41, btn_room_51, btn_room_61, btn_room_71, btn_room_81, btn_room_91, btn_room_101, btn_room_111, btn_room_121, btn_room_131,
            btn_room_22, btn_room_32, btn_room_42, btn_room_52, btn_room_62, btn_room_72, btn_room_82, btn_room_92, btn_room_102, btn_room_112, btn_room_122, btn_room_132,
            btn_room_23, btn_room_33, btn_room_43, btn_room_53, btn_room_63, btn_room_73, btn_room_83, btn_room_93, btn_room_103, btn_room_113, btn_room_123, btn_room_133,
            btn_room_24, btn_room_34, btn_room_44, btn_room_54, btn_room_64, btn_room_74, btn_room_84, btn_room_94, btn_room_104, btn_room_114, btn_room_124, btn_room_134,
            btn_room_25, btn_room_35, btn_room_45, btn_room_55, btn_room_65, btn_room_75, btn_room_85, btn_room_95, btn_room_105, btn_room_115, btn_room_125, btn_room_135,
            btn_room_26, btn_room_36, btn_room_46, btn_room_56, btn_room_66, btn_room_76, btn_room_86, btn_room_96, btn_room_106, btn_room_116, btn_room_126, btn_room_136,
            btn_room_27, btn_room_37, btn_room_47, btn_room_57, btn_room_67, btn_room_77, btn_room_87, btn_room_97, btn_room_107, btn_room_117, btn_room_127, btn_room_137,
            btn_room_28, btn_room_38, btn_room_48, btn_room_58, btn_room_68, btn_room_78, btn_room_88, btn_room_98, btn_room_108, btn_room_118, btn_room_128, btn_room_138,
            btn_room_29, btn_room_39, btn_room_49, btn_room_59, btn_room_69, btn_room_79, btn_room_89, btn_room_99, btn_room_109, btn_room_119, btn_room_129, btn_room_139,
            btn_room_140, btn_room_150, btn_room_160, btn_room_170, btn_room_180, btn_room_190, btn_room_200, btn_room_210, btn_room_220, btn_room_230, btn_room_240,
            btn_room_141, btn_room_151, btn_room_161, btn_room_171, btn_room_181, btn_room_191, btn_room_201, btn_room_211, btn_room_221, btn_room_231, btn_room_241,
            btn_room_142, btn_room_152, btn_room_162, btn_room_172, btn_room_182, btn_room_192, btn_room_202, btn_room_212, btn_room_222, btn_room_232, btn_room_242,
            btn_room_143, btn_room_153, btn_room_163, btn_room_173, btn_room_183, btn_room_193, btn_room_203, btn_room_213, btn_room_223, btn_room_233, btn_room_243,
            btn_room_144, btn_room_154, btn_room_164, btn_room_174, btn_room_184, btn_room_194, btn_room_204, btn_room_214, btn_room_224, btn_room_234, btn_room_244,
            btn_room_145, btn_room_155, btn_room_165, btn_room_175, btn_room_185, btn_room_195, btn_room_205, btn_room_215, btn_room_225, btn_room_235, btn_room_245,
            btn_room_146, btn_room_156, btn_room_166, btn_room_176, btn_room_186, btn_room_196, btn_room_206, btn_room_216, btn_room_226, btn_room_236, btn_room_246,
            btn_room_147, btn_room_157, btn_room_167, btn_room_177, btn_room_187, btn_room_197, btn_room_207, btn_room_217, btn_room_227, btn_room_237, btn_room_247,
            btn_room_148, btn_room_158, btn_room_168, btn_room_178, btn_room_188, btn_room_198, btn_room_208, btn_room_218, btn_room_228, btn_room_238,
            btn_room_149, btn_room_159, btn_room_169, btn_room_179, btn_room_189, btn_room_199, btn_room_209, btn_room_219, btn_room_229, btn_room_239;

    Context context;

    HashMap<String, Integer> nullRoom = new HashMap() {{
        put("1А", 0);	put("2А", 0);	put("3А", 0);	put("4А", 0);	put("5А", 0);	put("6А", 0);	put("7А", 0);	put("8А", 0);	put("4", 0);	put("5", 0);	put("6", 0);	put("7", 0);	put("8", 0);	put("9", 0);	put("10", 0);	put("11", 0);	put("12", 0);
        put("13", 0);	put("14", 0);	put("15", 0);	put("16", 0);	put("17", 0);	put("18", 0);	put("19", 0);	put("20", 0);	put("21", 0);	put("22", 0);	put("23", 0);	put("24", 0);	put("25", 0);	put("26", 0);	put("27", 0);	put("28", 0);	put("29", 0);	put("30", 0);	put("31", 0);	put("32", 0);
        put("33", 0);	put("34", 0);	put("35", 0);	put("36", 0);	put("37", 0);	put("38", 0);	put("39", 0);	put("40", 0);	put("41", 0);	put("42", 0);	put("43", 0);	put("44", 0);	put("45", 0);	put("46", 0);	put("47", 0);	put("48", 0);	put("49", 0);	put("50", 0);	put("51", 0);	put("52", 0);
        put("53", 0);	put("54", 0);	put("55", 0);	put("56", 0);	put("57", 0);	put("58", 0);	put("59", 0);	put("60", 0);	put("61", 0);	put("62", 0);	put("63", 0);	put("64", 0);	put("65", 0);	put("66", 0);	put("67", 0);	put("68", 0);	put("69", 0);	put("70", 0);	put("71", 0);	put("72", 0);
        put("73", 0);	put("74", 0);	put("75", 0);	put("76", 0);	put("77", 0);	put("78", 0);	put("79", 0);	put("80", 0);	put("81", 0);	put("82", 0);	put("83", 0);	put("84", 0);	put("85", 0);	put("86", 0);	put("87", 0);	put("88", 0);	put("89", 0);	put("90", 0);	put("91", 0);	put("92", 0);
        put("93", 0);	put("94", 0);	put("95", 0);	put("96", 0);	put("97", 0);	put("98", 0);	put("99", 0);	put("100", 0);	put("101", 0);	put("102", 0);	put("103", 0);	put("104", 0);	put("105", 0);	put("106", 0);	put("107", 0);	put("108", 0);	put("109", 0);	put("110", 0);	put("111", 0);	put("112", 0);
        put("113", 0);	put("114", 0);	put("115", 0);	put("116", 0);	put("117", 0);	put("118", 0);	put("119", 0);	put("120", 0);	put("121", 0);	put("122", 0);	put("123", 0);	put("124", 0);	put("125", 0);	put("126", 0);	put("127", 0);	put("128", 0);	put("129", 0);	put("130", 0);	put("131", 0);	put("132", 0);
        put("133", 0);	put("134", 0);	put("135", 0);	put("136", 0);	put("137", 0);	put("138", 0);	put("139", 0);	put("140", 0);	put("141", 0);	put("142", 0);	put("143", 0);	put("144", 0);	put("145", 0);	put("146", 0);	put("147", 0);	put("148", 0);	put("149", 0);	put("150", 0);	put("151", 0);	put("152", 0);
        put("153", 0);	put("154", 0);	put("155", 0);	put("156", 0);	put("157", 0);	put("158", 0);	put("159", 0);	put("160", 0);	put("161", 0);	put("162", 0);	put("163", 0);	put("164", 0);	put("165", 0);	put("166", 0);	put("167", 0);	put("168", 0);	put("169", 0);	put("170", 0);	put("171", 0);	put("172", 0);
        put("173", 0);	put("174", 0);	put("175", 0);	put("176", 0);	put("177", 0);	put("178", 0);	put("179", 0);	put("180", 0);	put("181", 0);	put("182", 0);	put("183", 0);	put("184", 0);	put("185", 0);	put("186", 0);	put("187", 0);	put("188", 0);	put("189", 0);	put("190", 0);	put("191", 0);	put("192", 0);
        put("193", 0);	put("194", 0);	put("195", 0);	put("196", 0);	put("197", 0);	put("198", 0);	put("199", 0);	put("200", 0);	put("201", 0);	put("202", 0);	put("203", 0);	put("204", 0);	put("205", 0);	put("206", 0);	put("207", 0);	put("208", 0);	put("209", 0);	put("210", 0);	put("211", 0);	put("212", 0);
        put("213", 0);	put("214", 0);	put("215", 0);	put("216", 0);	put("217", 0);	put("218", 0);	put("219", 0);	put("220", 0);	put("221", 0);	put("222", 0);	put("223", 0);	put("224", 0);	put("225", 0);	put("226", 0);	put("227", 0);	put("228", 0);	put("229", 0);	put("230", 0);	put("231", 0);	put("232", 0);
        put("233", 0);	put("234", 0);	put("235", 0);	put("236", 0);	put("237", 0);	put("238", 0);	put("239", 0);	put("240", 0);	put("241", 0);	put("242", 0);	put("243", 0);	put("244", 0);	put("245", 0);	put("246", 0);	put("247", 0);
    }};

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        dbManagerRooms = new DBManager(this);
        try {
            dbManagerRooms.open();
        }catch (Exception e) {
            e.printStackTrace();
        }

        context = getApplicationContext();

        btn_room_1a = (Button) findViewById(R.id.room_1a);
        btn_room_2a = (Button) findViewById(R.id.room_2a);
        btn_room_3a = (Button) findViewById(R.id.room_3a);
        btn_room_4a = (Button) findViewById(R.id.room_4a);
        btn_room_5a = (Button) findViewById(R.id.room_5a);
        btn_room_6a = (Button) findViewById(R.id.room_6a);
        btn_room_7a = (Button) findViewById(R.id.room_7a);
        btn_room_8a = (Button) findViewById(R.id.room_8a);
        btn_room_4 = (Button) findViewById(R.id.room_4);
        btn_room_5 = (Button) findViewById(R.id.room_5);
        btn_room_6 = (Button) findViewById(R.id.room_6);
        btn_room_7 = (Button) findViewById(R.id.room_7);
        btn_room_8 = (Button) findViewById(R.id.room_8);
        btn_room_9 = (Button) findViewById(R.id.room_9);
        btn_room_10 = (Button) findViewById(R.id.room_10);
        btn_room_11 = (Button) findViewById(R.id.room_11);
        btn_room_12 = (Button) findViewById(R.id.room_12);
        btn_room_13 = (Button) findViewById(R.id.room_13);
        btn_room_14 = (Button) findViewById(R.id.room_14);
        btn_room_15 = (Button) findViewById(R.id.room_15);
        btn_room_16 = (Button) findViewById(R.id.room_16);
        btn_room_17 = (Button) findViewById(R.id.room_17);
        btn_room_18 = (Button) findViewById(R.id.room_18);
        btn_room_19 = (Button) findViewById(R.id.room_19);
        btn_room_20 = (Button) findViewById(R.id.room_20);
        btn_room_21 = (Button) findViewById(R.id.room_21);
        btn_room_22 = (Button) findViewById(R.id.room_22);
        btn_room_23 = (Button) findViewById(R.id.room_23);
        btn_room_24 = (Button) findViewById(R.id.room_24);
        btn_room_25 = (Button) findViewById(R.id.room_25);
        btn_room_26 = (Button) findViewById(R.id.room_26);
        btn_room_27 = (Button) findViewById(R.id.room_27);
        btn_room_28 = (Button) findViewById(R.id.room_28);
        btn_room_29 = (Button) findViewById(R.id.room_29);
        btn_room_30 = (Button) findViewById(R.id.room_30);
        btn_room_31 = (Button) findViewById(R.id.room_31);
        btn_room_32 = (Button) findViewById(R.id.room_32);
        btn_room_33 = (Button) findViewById(R.id.room_33);
        btn_room_34 = (Button) findViewById(R.id.room_34);
        btn_room_35 = (Button) findViewById(R.id.room_35);
        btn_room_36 = (Button) findViewById(R.id.room_36);
        btn_room_37 = (Button) findViewById(R.id.room_37);
        btn_room_38 = (Button) findViewById(R.id.room_38);
        btn_room_39 = (Button) findViewById(R.id.room_39);
        btn_room_40 = (Button) findViewById(R.id.room_40);
        btn_room_41 = (Button) findViewById(R.id.room_41);
        btn_room_42 = (Button) findViewById(R.id.room_42);
        btn_room_43 = (Button) findViewById(R.id.room_43);
        btn_room_44 = (Button) findViewById(R.id.room_44);
        btn_room_45 = (Button) findViewById(R.id.room_45);
        btn_room_46 = (Button) findViewById(R.id.room_46);
        btn_room_47 = (Button) findViewById(R.id.room_47);
        btn_room_48 = (Button) findViewById(R.id.room_48);
        btn_room_49 = (Button) findViewById(R.id.room_49);
        btn_room_50 = (Button) findViewById(R.id.room_50);
        btn_room_51 = (Button) findViewById(R.id.room_51);
        btn_room_52 = (Button) findViewById(R.id.room_52);
        btn_room_53 = (Button) findViewById(R.id.room_53);
        btn_room_54 = (Button) findViewById(R.id.room_54);
        btn_room_55 = (Button) findViewById(R.id.room_55);
        btn_room_56 = (Button) findViewById(R.id.room_56);
        btn_room_57 = (Button) findViewById(R.id.room_57);
        btn_room_58 = (Button) findViewById(R.id.room_58);
        btn_room_59 = (Button) findViewById(R.id.room_59);
        btn_room_60 = (Button) findViewById(R.id.room_60);
        btn_room_61 = (Button) findViewById(R.id.room_61);
        btn_room_62 = (Button) findViewById(R.id.room_62);
        btn_room_63 = (Button) findViewById(R.id.room_63);
        btn_room_64 = (Button) findViewById(R.id.room_64);
        btn_room_65 = (Button) findViewById(R.id.room_65);
        btn_room_66 = (Button) findViewById(R.id.room_66);
        btn_room_67 = (Button) findViewById(R.id.room_67);
        btn_room_68 = (Button) findViewById(R.id.room_68);
        btn_room_69 = (Button) findViewById(R.id.room_69);
        btn_room_70 = (Button) findViewById(R.id.room_70);
        btn_room_71 = (Button) findViewById(R.id.room_71);
        btn_room_72 = (Button) findViewById(R.id.room_72);
        btn_room_73 = (Button) findViewById(R.id.room_73);
        btn_room_74 = (Button) findViewById(R.id.room_74);
        btn_room_75 = (Button) findViewById(R.id.room_75);
        btn_room_76 = (Button) findViewById(R.id.room_76);
        btn_room_77 = (Button) findViewById(R.id.room_77);
        btn_room_78 = (Button) findViewById(R.id.room_78);
        btn_room_79 = (Button) findViewById(R.id.room_79);
        btn_room_80 = (Button) findViewById(R.id.room_80);
        btn_room_81 = (Button) findViewById(R.id.room_81);
        btn_room_82 = (Button) findViewById(R.id.room_82);
        btn_room_83 = (Button) findViewById(R.id.room_83);
        btn_room_84 = (Button) findViewById(R.id.room_84);
        btn_room_85 = (Button) findViewById(R.id.room_85);
        btn_room_86 = (Button) findViewById(R.id.room_86);
        btn_room_87 = (Button) findViewById(R.id.room_87);
        btn_room_88 = (Button) findViewById(R.id.room_88);
        btn_room_89 = (Button) findViewById(R.id.room_89);
        btn_room_90 = (Button) findViewById(R.id.room_90);
        btn_room_91 = (Button) findViewById(R.id.room_91);
        btn_room_92 = (Button) findViewById(R.id.room_92);
        btn_room_93 = (Button) findViewById(R.id.room_93);
        btn_room_94 = (Button) findViewById(R.id.room_94);
        btn_room_95 = (Button) findViewById(R.id.room_95);
        btn_room_96 = (Button) findViewById(R.id.room_96);
        btn_room_97 = (Button) findViewById(R.id.room_97);
        btn_room_98 = (Button) findViewById(R.id.room_98);
        btn_room_99 = (Button) findViewById(R.id.room_99);
        btn_room_100 = (Button) findViewById(R.id.room_100);
        btn_room_101 = (Button) findViewById(R.id.room_101);
        btn_room_102 = (Button) findViewById(R.id.room_102);
        btn_room_103 = (Button) findViewById(R.id.room_103);
        btn_room_104 = (Button) findViewById(R.id.room_104);
        btn_room_105 = (Button) findViewById(R.id.room_105);
        btn_room_106 = (Button) findViewById(R.id.room_106);
        btn_room_107 = (Button) findViewById(R.id.room_107);
        btn_room_108 = (Button) findViewById(R.id.room_108);
        btn_room_109 = (Button) findViewById(R.id.room_109);
        btn_room_110 = (Button) findViewById(R.id.room_110);
        btn_room_111 = (Button) findViewById(R.id.room_111);
        btn_room_112 = (Button) findViewById(R.id.room_112);
        btn_room_113 = (Button) findViewById(R.id.room_113);
        btn_room_114 = (Button) findViewById(R.id.room_114);
        btn_room_115 = (Button) findViewById(R.id.room_115);
        btn_room_116 = (Button) findViewById(R.id.room_116);
        btn_room_117 = (Button) findViewById(R.id.room_117);
        btn_room_118 = (Button) findViewById(R.id.room_118);
        btn_room_119 = (Button) findViewById(R.id.room_119);
        btn_room_120 = (Button) findViewById(R.id.room_120);
        btn_room_121 = (Button) findViewById(R.id.room_121);
        btn_room_122 = (Button) findViewById(R.id.room_122);
        btn_room_123 = (Button) findViewById(R.id.room_123);
        btn_room_124 = (Button) findViewById(R.id.room_124);
        btn_room_125 = (Button) findViewById(R.id.room_125);
        btn_room_126 = (Button) findViewById(R.id.room_126);
        btn_room_127 = (Button) findViewById(R.id.room_127);
        btn_room_128 = (Button) findViewById(R.id.room_128);
        btn_room_129 = (Button) findViewById(R.id.room_129);
        btn_room_130 = (Button) findViewById(R.id.room_130);
        btn_room_131 = (Button) findViewById(R.id.room_131);
        btn_room_132 = (Button) findViewById(R.id.room_132);
        btn_room_133 = (Button) findViewById(R.id.room_133);
        btn_room_134 = (Button) findViewById(R.id.room_134);
        btn_room_135 = (Button) findViewById(R.id.room_135);
        btn_room_136 = (Button) findViewById(R.id.room_136);
        btn_room_137 = (Button) findViewById(R.id.room_137);
        btn_room_138 = (Button) findViewById(R.id.room_138);
        btn_room_139 = (Button) findViewById(R.id.room_139);
        btn_room_140 = (Button) findViewById(R.id.room_140);
        btn_room_141 = (Button) findViewById(R.id.room_141);
        btn_room_142 = (Button) findViewById(R.id.room_142);
        btn_room_143 = (Button) findViewById(R.id.room_143);
        btn_room_144 = (Button) findViewById(R.id.room_144);
        btn_room_145 = (Button) findViewById(R.id.room_145);
        btn_room_146 = (Button) findViewById(R.id.room_146);
        btn_room_147 = (Button) findViewById(R.id.room_147);
        btn_room_148 = (Button) findViewById(R.id.room_148);
        btn_room_149 = (Button) findViewById(R.id.room_149);
        btn_room_150 = (Button) findViewById(R.id.room_150);
        btn_room_151 = (Button) findViewById(R.id.room_151);
        btn_room_152 = (Button) findViewById(R.id.room_152);
        btn_room_153 = (Button) findViewById(R.id.room_153);
        btn_room_154 = (Button) findViewById(R.id.room_154);
        btn_room_155 = (Button) findViewById(R.id.room_155);
        btn_room_156 = (Button) findViewById(R.id.room_156);
        btn_room_157 = (Button) findViewById(R.id.room_157);
        btn_room_158 = (Button) findViewById(R.id.room_158);
        btn_room_159 = (Button) findViewById(R.id.room_159);
        btn_room_160 = (Button) findViewById(R.id.room_160);
        btn_room_161 = (Button) findViewById(R.id.room_161);
        btn_room_162 = (Button) findViewById(R.id.room_162);
        btn_room_163 = (Button) findViewById(R.id.room_163);
        btn_room_164 = (Button) findViewById(R.id.room_164);
        btn_room_165 = (Button) findViewById(R.id.room_165);
        btn_room_166 = (Button) findViewById(R.id.room_166);
        btn_room_167 = (Button) findViewById(R.id.room_167);
        btn_room_168 = (Button) findViewById(R.id.room_168);
        btn_room_169 = (Button) findViewById(R.id.room_169);
        btn_room_170 = (Button) findViewById(R.id.room_170);
        btn_room_171 = (Button) findViewById(R.id.room_171);
        btn_room_172 = (Button) findViewById(R.id.room_172);
        btn_room_173 = (Button) findViewById(R.id.room_173);
        btn_room_174 = (Button) findViewById(R.id.room_174);
        btn_room_175 = (Button) findViewById(R.id.room_175);
        btn_room_176 = (Button) findViewById(R.id.room_176);
        btn_room_177 = (Button) findViewById(R.id.room_177);
        btn_room_178 = (Button) findViewById(R.id.room_178);
        btn_room_179 = (Button) findViewById(R.id.room_179);
        btn_room_180 = (Button) findViewById(R.id.room_180);
        btn_room_181 = (Button) findViewById(R.id.room_181);
        btn_room_182 = (Button) findViewById(R.id.room_182);
        btn_room_183 = (Button) findViewById(R.id.room_183);
        btn_room_184 = (Button) findViewById(R.id.room_184);
        btn_room_185 = (Button) findViewById(R.id.room_185);
        btn_room_186 = (Button) findViewById(R.id.room_186);
        btn_room_187 = (Button) findViewById(R.id.room_187);
        btn_room_188 = (Button) findViewById(R.id.room_188);
        btn_room_189 = (Button) findViewById(R.id.room_189);
        btn_room_190 = (Button) findViewById(R.id.room_190);
        btn_room_191 = (Button) findViewById(R.id.room_191);
        btn_room_192 = (Button) findViewById(R.id.room_192);
        btn_room_193 = (Button) findViewById(R.id.room_193);
        btn_room_194 = (Button) findViewById(R.id.room_194);
        btn_room_195 = (Button) findViewById(R.id.room_195);
        btn_room_196 = (Button) findViewById(R.id.room_196);
        btn_room_197 = (Button) findViewById(R.id.room_197);
        btn_room_198 = (Button) findViewById(R.id.room_198);
        btn_room_199 = (Button) findViewById(R.id.room_199);
        btn_room_200 = (Button) findViewById(R.id.room_200);
        btn_room_201 = (Button) findViewById(R.id.room_201);
        btn_room_202 = (Button) findViewById(R.id.room_202);
        btn_room_203 = (Button) findViewById(R.id.room_203);
        btn_room_204 = (Button) findViewById(R.id.room_204);
        btn_room_205 = (Button) findViewById(R.id.room_205);
        btn_room_206 = (Button) findViewById(R.id.room_206);
        btn_room_207 = (Button) findViewById(R.id.room_207);
        btn_room_208 = (Button) findViewById(R.id.room_208);
        btn_room_209 = (Button) findViewById(R.id.room_209);
        btn_room_210 = (Button) findViewById(R.id.room_210);
        btn_room_211 = (Button) findViewById(R.id.room_211);
        btn_room_212 = (Button) findViewById(R.id.room_212);
        btn_room_213 = (Button) findViewById(R.id.room_213);
        btn_room_214 = (Button) findViewById(R.id.room_214);
        btn_room_215 = (Button) findViewById(R.id.room_215);
        btn_room_216 = (Button) findViewById(R.id.room_216);
        btn_room_217 = (Button) findViewById(R.id.room_217);
        btn_room_218 = (Button) findViewById(R.id.room_218);
        btn_room_219 = (Button) findViewById(R.id.room_219);
        btn_room_220 = (Button) findViewById(R.id.room_220);
        btn_room_221 = (Button) findViewById(R.id.room_221);
        btn_room_222 = (Button) findViewById(R.id.room_222);
        btn_room_223 = (Button) findViewById(R.id.room_223);
        btn_room_224 = (Button) findViewById(R.id.room_224);
        btn_room_225 = (Button) findViewById(R.id.room_225);
        btn_room_226 = (Button) findViewById(R.id.room_226);
        btn_room_227 = (Button) findViewById(R.id.room_227);
        btn_room_228 = (Button) findViewById(R.id.room_228);
        btn_room_229 = (Button) findViewById(R.id.room_229);
        btn_room_230 = (Button) findViewById(R.id.room_230);
        btn_room_231 = (Button) findViewById(R.id.room_231);
        btn_room_232 = (Button) findViewById(R.id.room_232);
        btn_room_233 = (Button) findViewById(R.id.room_233);
        btn_room_234 = (Button) findViewById(R.id.room_234);
        btn_room_235 = (Button) findViewById(R.id.room_235);
        btn_room_236 = (Button) findViewById(R.id.room_236);
        btn_room_237 = (Button) findViewById(R.id.room_237);
        btn_room_238 = (Button) findViewById(R.id.room_238);
        btn_room_239 = (Button) findViewById(R.id.room_239);
        btn_room_240 = (Button) findViewById(R.id.room_240);
        btn_room_241 = (Button) findViewById(R.id.room_241);
        btn_room_242 = (Button) findViewById(R.id.room_242);
        btn_room_243 = (Button) findViewById(R.id.room_243);
        btn_room_244 = (Button) findViewById(R.id.room_244);
        btn_room_245 = (Button) findViewById(R.id.room_245);
        btn_room_246 = (Button) findViewById(R.id.room_246);
        btn_room_247 = (Button) findViewById(R.id.room_247);

        loadButton();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && focusRooms) {
            focusRooms = false;
            for (Map.Entry entry: nullRoom.entrySet()
                 ) {
                entry.setValue(0);
            }
            loadButton();
        }
    }

    public void loadButton() {

        Cursor cursor = dbManagerRooms.fetchStudy();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String number_room = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NUMBER_ROOM));
                if (nullRoom.containsKey(number_room)){
                    nullRoom.replace(number_room, nullRoom.get(number_room) + 1);
                }
            } while (cursor.moveToNext());
        }

        colorButton(btn_room_1a);
        colorButton(btn_room_2a);
        colorButton(btn_room_3a);
        colorButton(btn_room_4a);
        colorButton(btn_room_5a);
        colorButton(btn_room_6a);
        colorButton(btn_room_7a);
        colorButton(btn_room_8a);
        colorButton(btn_room_4 );
        colorButton(btn_room_5 );
        colorButton(btn_room_6 );
        colorButton(btn_room_7 );
        colorButton(btn_room_8 );
        colorButton(btn_room_9 );
        colorButton(btn_room_10);
        colorButton(btn_room_11);
        colorButton(btn_room_12);
        colorButton(btn_room_13);
        colorButton(btn_room_14);
        colorButton(btn_room_15);
        colorButton(btn_room_16);
        colorButton(btn_room_17);
        colorButton(btn_room_18);
        colorButton(btn_room_19);
        colorButton(btn_room_20);
        colorButton(btn_room_21);
        colorButton(btn_room_22);
        colorButton(btn_room_23);
        colorButton(btn_room_24);
        colorButton(btn_room_25);
        colorButton(btn_room_26);
        colorButton(btn_room_27);
        colorButton(btn_room_28);
        colorButton(btn_room_29);
        colorButton(btn_room_30);
        colorButton(btn_room_31);
        colorButton(btn_room_32);
        colorButton(btn_room_33);
        colorButton(btn_room_34);
        colorButton(btn_room_35);
        colorButton(btn_room_36);
        colorButton(btn_room_37);
        colorButton(btn_room_38);
        colorButton(btn_room_39);
        colorButton(btn_room_40);
        colorButton(btn_room_41);
        colorButton(btn_room_42);
        colorButton(btn_room_43);
        colorButton(btn_room_44);
        colorButton(btn_room_45);
        colorButton(btn_room_46);
        colorButton(btn_room_47);
        colorButton(btn_room_48);
        colorButton(btn_room_49);
        colorButton(btn_room_50);
        colorButton(btn_room_51);
        colorButton(btn_room_52);
        colorButton(btn_room_53);
        colorButton(btn_room_54);
        colorButton(btn_room_55);
        colorButton(btn_room_56);
        colorButton(btn_room_57);
        colorButton(btn_room_58);
        colorButton(btn_room_59);
        colorButton(btn_room_60);
        colorButton(btn_room_61);
        colorButton(btn_room_62);
        colorButton(btn_room_63);
        colorButton(btn_room_64);
        colorButton(btn_room_65);
        colorButton(btn_room_66);
        colorButton(btn_room_67);
        colorButton(btn_room_68);
        colorButton(btn_room_69);
        colorButton(btn_room_70);
        colorButton(btn_room_71);
        colorButton(btn_room_72);
        colorButton(btn_room_73);
        colorButton(btn_room_74);
        colorButton(btn_room_75);
        colorButton(btn_room_76);
        colorButton(btn_room_77);
        colorButton(btn_room_78);
        colorButton(btn_room_79);
        colorButton(btn_room_80);
        colorButton(btn_room_81);
        colorButton(btn_room_82);
        colorButton(btn_room_83);
        colorButton(btn_room_84);
        colorButton(btn_room_85);
        colorButton(btn_room_86);
        colorButton(btn_room_87);
        colorButton(btn_room_88);
        colorButton(btn_room_89);
        colorButton(btn_room_90);
        colorButton(btn_room_91);
        colorButton(btn_room_92);
        colorButton(btn_room_93);
        colorButton(btn_room_94);
        colorButton(btn_room_95);
        colorButton(btn_room_96);
        colorButton(btn_room_97);
        colorButton(btn_room_98);
        colorButton(btn_room_99);
        colorButton(btn_room_100);
        colorButton(btn_room_101);
        colorButton(btn_room_102);
        colorButton(btn_room_103);
        colorButton(btn_room_104);
        colorButton(btn_room_105);
        colorButton(btn_room_106);
        colorButton(btn_room_107);
        colorButton(btn_room_108);
        colorButton(btn_room_109);
        colorButton(btn_room_110);
        colorButton(btn_room_111);
        colorButton(btn_room_112);
        colorButton(btn_room_113);
        colorButton(btn_room_114);
        colorButton(btn_room_115);
        colorButton(btn_room_116);
        colorButton(btn_room_117);
        colorButton(btn_room_118);
        colorButton(btn_room_119);
        colorButton(btn_room_120);
        colorButton(btn_room_121);
        colorButton(btn_room_122);
        colorButton(btn_room_123);
        colorButton(btn_room_124);
        colorButton(btn_room_125);
        colorButton(btn_room_126);
        colorButton(btn_room_127);
        colorButton(btn_room_128);
        colorButton(btn_room_129);
        colorButton(btn_room_130);
        colorButton(btn_room_131);
        colorButton(btn_room_132);
        colorButton(btn_room_133);
        colorButton(btn_room_134);
        colorButton(btn_room_135);
        colorButton(btn_room_136);
        colorButton(btn_room_137);
        colorButton(btn_room_138);
        colorButton(btn_room_139);
        colorButton(btn_room_140);
        colorButton(btn_room_141);
        colorButton(btn_room_142);
        colorButton(btn_room_143);
        colorButton(btn_room_144);
        colorButton(btn_room_145);
        colorButton(btn_room_146);
        colorButton(btn_room_147);
        colorButton(btn_room_148);
        colorButton(btn_room_149);
        colorButton(btn_room_150);
        colorButton(btn_room_151);
        colorButton(btn_room_152);
        colorButton(btn_room_153);
        colorButton(btn_room_154);
        colorButton(btn_room_155);
        colorButton(btn_room_156);
        colorButton(btn_room_157);
        colorButton(btn_room_158);
        colorButton(btn_room_159);
        colorButton(btn_room_160);
        colorButton(btn_room_161);
        colorButton(btn_room_162);
        colorButton(btn_room_163);
        colorButton(btn_room_164);
        colorButton(btn_room_165);
        colorButton(btn_room_166);
        colorButton(btn_room_167);
        colorButton(btn_room_168);
        colorButton(btn_room_169);
        colorButton(btn_room_170);
        colorButton(btn_room_171);
        colorButton(btn_room_172);
        colorButton(btn_room_173);
        colorButton(btn_room_174);
        colorButton(btn_room_175);
        colorButton(btn_room_176);
        colorButton(btn_room_177);
        colorButton(btn_room_178);
        colorButton(btn_room_179);
        colorButton(btn_room_180);
        colorButton(btn_room_181);
        colorButton(btn_room_182);
        colorButton(btn_room_183);
        colorButton(btn_room_184);
        colorButton(btn_room_185);
        colorButton(btn_room_186);
        colorButton(btn_room_187);
        colorButton(btn_room_188);
        colorButton(btn_room_189);
        colorButton(btn_room_190);
        colorButton(btn_room_191);
        colorButton(btn_room_192);
        colorButton(btn_room_193);
        colorButton(btn_room_194);
        colorButton(btn_room_195);
        colorButton(btn_room_196);
        colorButton(btn_room_197);
        colorButton(btn_room_198);
        colorButton(btn_room_199);
        colorButton(btn_room_200);
        colorButton(btn_room_201);
        colorButton(btn_room_202);
        colorButton(btn_room_203);
        colorButton(btn_room_204);
        colorButton(btn_room_205);
        colorButton(btn_room_206);
        colorButton(btn_room_207);
        colorButton(btn_room_208);
        colorButton(btn_room_209);
        colorButton(btn_room_210);
        colorButton(btn_room_211);
        colorButton(btn_room_212);
        colorButton(btn_room_213);
        colorButton(btn_room_214);
        colorButton(btn_room_215);
        colorButton(btn_room_216);
        colorButton(btn_room_217);
        colorButton(btn_room_218);
        colorButton(btn_room_219);
        colorButton(btn_room_220);
        colorButton(btn_room_221);
        colorButton(btn_room_222);
        colorButton(btn_room_223);
        colorButton(btn_room_224);
        colorButton(btn_room_225);
        colorButton(btn_room_226);
        colorButton(btn_room_227);
        colorButton(btn_room_228);
        colorButton(btn_room_229);
        colorButton(btn_room_230);
        colorButton(btn_room_231);
        colorButton(btn_room_232);
        colorButton(btn_room_233);
        colorButton(btn_room_234);
        colorButton(btn_room_235);
        colorButton(btn_room_236);
        colorButton(btn_room_237);
        colorButton(btn_room_238);
        colorButton(btn_room_239);
        colorButton(btn_room_240);
        colorButton(btn_room_241);
        colorButton(btn_room_242);
        colorButton(btn_room_243);
        colorButton(btn_room_244);
        colorButton(btn_room_245);
        colorButton(btn_room_246);
        colorButton(btn_room_247);
    }
    public void colorButton(View view) {

        Button btn = (Button) findViewById(view.getId());
        if (nullRoom.containsKey(btn.getText()) && threeRoom.contains(btn.getText())){
            if (nullRoom.get(btn.getText()) < 3) {
                btn.setBackgroundColor(Color.parseColor("#017E68"));
            } else if (nullRoom.get(btn.getText()) > 3) {
                btn.setBackgroundColor(Color.parseColor("#BA0028"));
            } else if (nullRoom.get(btn.getText()) == 3) {
                btn.setBackgroundColor(Color.parseColor("#527da3"));
            }
        } else if (nullRoom.containsKey(btn.getText()) && twoRoom.contains(btn.getText())){
            if (nullRoom.get(btn.getText()) < 2) {
                btn.setBackgroundColor(Color.parseColor("#017E68"));
            } else if (nullRoom.get(btn.getText()) > 2) {
                btn.setBackgroundColor(Color.parseColor("#BA0028"));
            }else if (nullRoom.get(btn.getText()) == 2) {
                btn.setBackgroundColor(Color.parseColor("#527da3"));
            }
        }
    }

    public void addListenerOnButton(View view) {

        Button btn = (Button) findViewById(view.getId());

        Intent intent = new Intent(context, Room.class);
        intent.putExtra("NumberRoom", btn.getText().toString());
        startActivity(intent);

    }
}