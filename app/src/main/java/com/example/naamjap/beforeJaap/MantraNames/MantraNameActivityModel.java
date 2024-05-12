package com.example.naamjap.beforeJaap.MantraNames;

public class MantraNameActivityModel {
    private String mantra ;
    private int mantraAdd ;

    public MantraNameActivityModel(String mantra, int mantraAdd) {
        this.mantra = mantra;
        this.mantraAdd = mantraAdd;
    }

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
}
