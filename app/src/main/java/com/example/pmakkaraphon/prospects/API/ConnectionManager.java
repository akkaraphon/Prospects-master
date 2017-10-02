package com.example.pmakkaraphon.prospects.API;

import android.util.Log;

import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;


import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class ConnectionManager {

String API ="http://rmis.lpn.co.th/prospect/api/";

    public ConnectionManager() {

    }
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Service git = retrofit.create(Service.class);
    public void callPrename(final PreNameCallbackListener listener) {

        Call call  = git.getPrename();
        call.enqueue(new Callback<List<PrenameModel>>() {
            @Override
            public void onResponse(Response<List<PrenameModel>> response, Retrofit retrofit) {
                List<PrenameModel> model = response.body();

                if (model == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse( model, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }
    public void callProvince(final ProvinceCallbackListener listener){
        Call call  = git.getProvince();
        call.enqueue(new Callback<List<ProvinceModel>>() {
            @Override
            public void onResponse(Response<List<ProvinceModel>> response, Retrofit retrofit) {
                List<ProvinceModel> model = response.body();

                if (model == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse( model, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public void callDis(final DistictCallbackListener listener, String pv_code){
        Call call = git.getDistrict(pv_code);
        call.enqueue(new Callback<List<DistictModel>>() {
            @Override
            public void onResponse(Response<List<DistictModel>> response, Retrofit retrofit) {

                List<DistictModel> dis = response.body();
                if (dis == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse( dis, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("POON TEST",t.toString());
            }
        });
    }
}