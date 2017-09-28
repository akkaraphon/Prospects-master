package com.example.pmakkaraphon.prospects.Model;

import com.google.gson.annotations.Expose;

public class PrenameModel {


    /**
     * PN_CODE : 00
     * PN_NAME : คุณ
     */
    @Expose
    private String PN_CODE;
    @Expose
    private String PN_NAME;

    public String getPN_CODE() {
        return PN_CODE;
    }

    public void setPN_CODE(String PN_CODE) {
        this.PN_CODE = PN_CODE;
    }

    public String getPN_NAME() {
        return PN_NAME;
    }

    public void setPN_NAME(String PN_NAME) {
        this.PN_NAME = PN_NAME;
    }
}