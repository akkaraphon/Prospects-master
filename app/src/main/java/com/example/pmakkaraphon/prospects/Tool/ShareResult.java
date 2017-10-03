package com.example.pmakkaraphon.prospects.Tool;

public class ShareResult {
    public String name,lastname,birthday,idCard,exp,tel,mobile,email /*-----*/,idHome,mu,build,soi,road,city,district,zipcode;
    public int sms;
    private static final ShareResult result = new ShareResult();
    public static ShareResult getInstance(){return result;}
}
