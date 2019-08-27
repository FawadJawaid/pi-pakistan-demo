package com.androidbuts.fawad.retrofit.api;

import com.androidbuts.fawad.model.VodTabList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fawadjawaidmalik on 13/10/2016.
 */
public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of VodTabList
    */
    @GET("/PitvBackend/api/getAllVODCategories/V1/en/android")
    Call<VodTabList> getVODTabs();
}
