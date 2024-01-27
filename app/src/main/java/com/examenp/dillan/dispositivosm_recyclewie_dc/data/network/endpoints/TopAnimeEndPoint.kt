package com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.endpoints

import com.test.dm_clases_hc.data.network.endpoint.jikan.top.TopAnimes
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimeEndPoint {

    @GET("top/anime")
     suspend fun  getAllTopAnimes(): Response<TopAnimes>
}