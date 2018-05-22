package com.jsystems.testautomation;

public class GamePlay {
    public String play(int number){
        if (number==0) throw new IllegalArgumentException("Number must not be 0");
        if (number%3==0)return "OK";
        if (number%3!=0)return "NOT OK";

        return String.valueOf(number);

    }

}
