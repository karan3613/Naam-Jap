package com.example.naamjap.godMantraList;

public class godMantraModel {

    private String name ;
    private String mantra1 ;
    private int mantra1Add;
    private String mantra2  ;
    private int  mantra2Add;
    private String mantra3 ;
    private int mantra3Add;
    private String mantra4  ;
    private int mantra4Add ;
    private String mantra5 ;
    private  int mantra5Add;

    public godMantraModel(String name, String mantra1, int mantra1Add, String mantra2,
                          int mantra2Add, String mantra3, int mantra3Add,
                          String mantra4, int mantra4Add, String mantra5, int mantra5Add) {
        this.name = name;
        this.mantra1 = mantra1;
        this.mantra1Add = mantra1Add;
        this.mantra2 = mantra2;
        this.mantra2Add = mantra2Add;
        this.mantra3 = mantra3;
        this.mantra3Add = mantra3Add;
        this.mantra4 = mantra4;
        this.mantra4Add = mantra4Add;
        this.mantra5 = mantra5;
        this.mantra5Add = mantra5Add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMantra1() {
        return mantra1;
    }

    public void setMantra1(String mantra1) {
        this.mantra1 = mantra1;
    }

    public int getMantra1Add() {
        return mantra1Add;
    }

    public void setMantra1Add(int mantra1Add) {
        this.mantra1Add = mantra1Add;
    }

    public String getMantra2() {
        return mantra2;
    }

    public void setMantra2(String mantra2) {
        this.mantra2 = mantra2;
    }

    public int getMantra2Add() {
        return mantra2Add;
    }

    public void setMantra2Add(int mantra2Add) {
        this.mantra2Add = mantra2Add;
    }

    public String getMantra3() {
        return mantra3;
    }

    public void setMantra3(String mantra3) {
        this.mantra3 = mantra3;
    }

    public int getMantra3Add() {
        return mantra3Add;
    }

    public void setMantra3Add(int mantra3Add) {
        this.mantra3Add = mantra3Add;
    }

    public String getMantra4() {
        return mantra4;
    }

    public void setMantra4(String mantra4) {
        this.mantra4 = mantra4;
    }

    public int getMantra4Add() {
        return mantra4Add;
    }

    public void setMantra4Add(int mantra4Add) {
        this.mantra4Add = mantra4Add;
    }

    public String getMantra5() {
        return mantra5;
    }

    public void setMantra5(String mantra5) {
        this.mantra5 = mantra5;
    }

    public int getMantra5Add() {
        return mantra5Add;
    }

    public void setMantra5Add(int mantra5Add) {
        this.mantra5Add = mantra5Add;
    }
}
