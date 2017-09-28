package com.example.pmakkaraphon.prospects.API;

import com.example.pmakkaraphon.prospects.Model.User;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public interface OnNetworkCallbackListener {
    public void onResponse(User user, Retrofit retrofit);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}