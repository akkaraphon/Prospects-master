package com.example.pmakkaraphon.prospects.API;

import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.User;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;


public interface Service {


    @GET("getPrename")
    Call<List<PrenameModel>> getPrename();

    @FormUrlEncoded
    @POST("postCheckName")
    Call<User> updateUser(@Field("name") String name, @Field("lastname") String lastname);

    @FormUrlEncoded
    @POST("getDistrict")
    Call<List<DistictModel>> getDistrict(@Field("PV_CODE") String disname);

}