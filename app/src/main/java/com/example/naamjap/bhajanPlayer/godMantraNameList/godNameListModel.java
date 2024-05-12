package com.example.naamjap.bhajanPlayer.godMantraNameList;

import androidx.room.PrimaryKey;

public class godNameListModel {
    private String name ;

    private String mantra1 ;
    private int mantra1Add;

    private String mantra2  ;
    private int mantra2Add;

    private String  mantra3 ;
    private int mantra3Add;
    private int imageId;




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

    public String getMantra2() {
        return mantra2;
    }

    public void setMantra2(String mantra2) {
        this.mantra2 = mantra2;
    }

    public String getMantra3() {
        return mantra3;
    }

    public void setMantra3(String mantra3) {
        this.mantra3 = mantra3;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getMantra1Add() {
        return mantra1Add;
    }

    public void setMantra1Add(int mantra1Add) {
        this.mantra1Add = mantra1Add;
    }

    public int getMantra2Add() {
        return mantra2Add;
    }

    public void setMantra2Add(int mantra2Add) {
        this.mantra2Add = mantra2Add;
    }

    public int getMantra3Add() {
        return mantra3Add;
    }

    public void setMantra3Add(int mantra3Add) {
        this.mantra3Add = mantra3Add;
    }

    public godNameListModel(String name, String mantra1, int mantra1Add, String mantra2, int mantra2Add, String mantra3, int mantra3Add, int imageId) {
        this.name = name;
        this.mantra1 = mantra1;
        this.mantra1Add = mantra1Add;
        this.mantra2 = mantra2;
        this.mantra2Add = mantra2Add;
        this.mantra3 = mantra3;
        this.mantra3Add = mantra3Add;
        this.imageId = imageId;
    }
}
