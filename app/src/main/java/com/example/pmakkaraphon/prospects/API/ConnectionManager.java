package com.example.pmakkaraphon.prospects.API;

import android.util.Log;

import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionManager {

    public void callServer(final OnNetworkCallbackListener listener,String name,String lastname){

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://rmis.lpn.co.th/prospect/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service git = retrofit.create(Service.class);

        Call call = git.updateUser(name,lastname);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                if (user == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(user, retrofit);
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }

        });

    }
}