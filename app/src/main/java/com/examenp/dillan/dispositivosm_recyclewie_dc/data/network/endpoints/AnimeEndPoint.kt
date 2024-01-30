package com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.endpoints
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.jikan.anime.FullInfoAnime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeEndPoint {


    @GET("anime/{id}/full/")
    suspend fun getAnimeFullInfo(@Path("id") name:Int):Response<FullInfoAnime>
    //response devuelve la cabezera y el cuerpo.

}