package com.example.pmakkaraphon.prospects.API;

import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.Retrofit;


public interface OnNetworkCallbackListener {
    public void onResponse(List<PrenameModel> model, Retrofit retrofit);
    public void onResponse(User user, Retrofit retrofit);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}

