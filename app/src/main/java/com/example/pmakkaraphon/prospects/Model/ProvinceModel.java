package com.example.pmakkaraphon.prospects.Model;

import com.google.gson.annotations.Expose;

public class ProvinceModel {


    /**
     * PV_CODE : SIN
     * PV_TNAME : SINGAPORE
     */
    @Expose
    private String PV_CODE;
    @Expose
    private String PV_TNAME;

    public String getPV_CODE() {
        return PV_CODE;
    }

    public void setPV_CODE(String PV_CODE) {
        this.PV_CODE = PV_CODE;
    }

    public String getPV_TNAME() {
        return PV_TNAME;
    }

    public void setPV_TNAME(String PV_TNAME) {
        this.PV_TNAME = PV_TNAME;
    }
}