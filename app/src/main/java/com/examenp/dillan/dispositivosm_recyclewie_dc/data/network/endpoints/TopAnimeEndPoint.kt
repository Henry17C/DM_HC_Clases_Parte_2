package com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.endpoints

import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.jikan.top.TopAnimes
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimeEndPoint {

    @GET("top/anime/") //v4/top/anime        top/anime
    suspend fun getAllTopAnimes():Response<TopAnimes>
    //response devuelve la cabezera y el cuerpo.

    //devuelve una lista de animes y no necesito ningun parametro

}