package com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {


    //Acceso a los endpoint
    private const val JIKAN_URL= "https://api.jikan.moe/v4/"
    fun getRetrofitJikanConnection(): Retrofit=
        Retrofit.Builder().baseUrl(JIKAN_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()



    fun getRetrofitNetflixConnection(): Retrofit=
        Retrofit.Builder().baseUrl(JIKAN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()





}