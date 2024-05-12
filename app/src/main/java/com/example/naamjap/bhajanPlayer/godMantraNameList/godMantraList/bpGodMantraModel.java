package com.example.naamjap.bhajanPlayer.godMantraNameList.godMantraList;

public class bpGodMantraModel {
    private String MantraText ;
    private int MantraAdd ;
    private int imageId;


    public bpGodMantraModel(String mantraText, int mantraAdd, int imageId) {
        MantraText = mantraText;
        MantraAdd = mantraAdd;
        this.imageId = imageId;
    }

    public String getMantraText() {
        return MantraText;
    }

    public void setMantraText(String mantraText) {
        MantraText = mantraText;
    }

    public int getMantraAdd() {
        return MantraAdd;
    }

    public void setMantraAdd(int mantraAdd) {
        MantraAdd = mantraAdd;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
