package com.example.naamjap.godMantras;

public class godMantrasModel {
    private String mantra  ;
    private int mantraAdd;

    public String getMantra() {
        return mantra;
    }

    public void setMantra(String mantra) {
        this.mantra = mantra;
    }

    public int getMantraAdd() {
        return mantraAdd;
    }

    public void setMantraAdd(int mantraAdd) {
        this.mantraAdd = mantraAdd;
    }

    public godMantrasModel(String mantra, int mantraAdd) {
        this.mantra = mantra;
        this.mantraAdd = mantraAdd;
    }
}
