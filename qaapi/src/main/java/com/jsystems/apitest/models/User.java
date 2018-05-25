package com.jsystems.apitest.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    public String imie;
    public String nazwisko;
    public List<DeviceObj> device;

    public User(){

    }

    public User(String imie, String nazwisko, List<DeviceObj> device) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.device = device;
    }

    @Override
    public String toString() {
        return "User{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", device=" + device +
                '}';
    }
}
