package com.example.android.paginationusingretrofit.retrofit;


import com.example.android.paginationusingretrofit.model.HomeModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {
    @FormUrlEncoded
    @POST("list_quotes_new")
    Call<HomeModel> getHomeList(@Field("last_quote_id") int last_quote_id);

}