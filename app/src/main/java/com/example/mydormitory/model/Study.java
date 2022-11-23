package com.example.mydormitory.model;

public class Study {

    String id, Fio, Number_dog, Period, Group, NumberRoom, Telefon, FioRod, TelRod, Seriya, Nomer, KemV, DataV, Pol, DataR, MestoR, MestoG;

    public Study(String id, String fio, String number_dog, String period, String group, String telefon) {
        this.id = id;
        Fio = fio;
        Number_dog = number_dog;
        Period = period;
        Group = group;
        Telefon = telefon;
    }

    public Study(String id, String fio, String number_dog, String period, String group, String numberRoom, String telefon, String fioRod, String telRod, String seriya, String nomer, String kemV, String dataV, String pol, String dataR, String mestoR, String mestoG) {
        this.id = id;
        Fio = fio;
        Number_dog = number_dog;
        Period = period;
        Group = group;
        NumberRoom = numberRoom;
        Telefon = telefon;
        FioRod = fioRod;
        TelRod = telRod;
        Seriya = seriya;
        Nomer = nomer;
        KemV = kemV;
        DataV = dataV;
        Pol = pol;
        DataR = dataR;
        MestoR = mestoR;
        MestoG = mestoG;
    }

    public String getPol() {
        return Pol;
    }

    public void setPol(String pol) {
        Pol = pol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return Fio;
    }

    public void setFio(String fio) {
        Fio = fio;
    }

    public String getNumber_dog() {
        return Number_dog;
    }

    public void setNumber_dog(String number_dog) {
        Number_dog = number_dog;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getNumberRoom() {
        return NumberRoom;
    }

    public void setNumberRoom(String numberRoom) {
        NumberRoom = numberRoom;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getFioRod() {
        return FioRod;
    }

    public void setFioRod(String fioRod) {
        FioRod = fioRod;
    }

    public String getTelRod() {
        return TelRod;
    }

    public void setTelRod(String telRod) {
        TelRod = telRod;
    }

    public String getSeriya() {
        return Seriya;
    }

    public void setSeriya(String seriya) {
        Seriya = seriya;
    }

    public String getNomer() {
        return Nomer;
    }

    public void setNomer(String nomer) {
        Nomer = nomer;
    }

    public String getKemV() {
        return KemV;
    }

    public void setKemV(String kemV) {
        KemV = kemV;
    }

    public String getDataV() {
        return DataV;
    }

    public void setDataV(String dataV) {
        DataV = dataV;
    }

    public String getDataR() {
        return DataR;
    }

    public void setDataR(String dataR) {
        DataR = dataR;
    }

    public String getMestoR() {
        return MestoR;
    }

    public void setMestoR(String mestoR) {
        MestoR = mestoR;
    }

    public String getMestoG() {
        return MestoG;
    }

    public void setMestoG(String mestoG) {
        MestoG = mestoG;
    }
}