package com.example.pmakkaraphon.prospects.API;

import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.Retrofit;


public interface OnNetworkCallbackListener {
    public void onResponsePre(List<PrenameModel> prenameModels, Retrofit retrofit);
    public void onResponsePro(List<ProvinceModel> provinceModels, Retrofit retrofit);
    public void onResponse(User user, Retrofit retrofit);
    public void onResponseDis(List<DistictModel> distictModels, Retrofit retrofit);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}

