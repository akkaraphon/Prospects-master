package com.example.pmakkaraphon.prospects.API;

import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.User;



import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {

    @FormUrlEncoded
    @POST("postCheckName")
    Call<User> updateUser(@Field("name") String name, @Field("lastname") String lastname);


}