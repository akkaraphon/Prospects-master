package com.example.pmakkaraphon.prospects.Model;

import com.google.gson.annotations.Expose;

public class DistictModel {


    /**
     * DT_CODE : 001
     * DT_TNAME : คลองเตย
     * DT_ZIP : 10110
     */
    @Expose
    private String DT_CODE;
    @Expose
    private String DT_TNAME;
    @Expose
    private String DT_ZIP;

    public String getDT_CODE() {
        return DT_CODE;
    }

    public void setDT_CODE(String DT_CODE) {
        this.DT_CODE = DT_CODE;
    }

    public String getDT_TNAME() {
        return DT_TNAME;
    }

    public void setDT_TNAME(String DT_TNAME) {
        this.DT_TNAME = DT_TNAME;
    }

    public String getDT_ZIP() {
        return DT_ZIP;
    }

    public void setDT_ZIP(String DT_ZIP) {
        this.DT_ZIP = DT_ZIP;
    }
}