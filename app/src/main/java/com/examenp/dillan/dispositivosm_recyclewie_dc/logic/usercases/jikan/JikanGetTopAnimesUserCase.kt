package com.examenp.dillan.dispositivosm_recyclewie_dc.logic.usercases.jikan

import android.util.Log
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.repository.RetrofitBase
import com.examenp.dillan.dispositivosm_recyclewie_dc.core.getFullInfoAnimeLG
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.endpoints.TopAnimeEndPoint
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.entities.FullInfoAnimeLG
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.Constants


class JikanGetTopAnimesUserCase {

    suspend fun invoke(): Result<List<FullInfoAnimeLG>> {
        var result:Result<List<FullInfoAnimeLG>>?=null
        val items=ArrayList<FullInfoAnimeLG>()


        try {
            val baseService= RetrofitBase.getRetrofitJikanConnection()
            val service= baseService.create(TopAnimeEndPoint::class.java) //creo mi servicio
            val call= service.getAllTopAnimes() //ahora si podria acceder a travez de servicio a los metodos

            if(call.isSuccessful){
                val infoAnime=call.body()!! //es una lista de top animes
                infoAnime.data.forEach{
                    items.add(it.getFullInfoAnimeLG())

                }
                result = Result.success(items.toList())
            }else{
                Log.d(Constants.TAG, "Error en el llamado a la API de Jikan")
                result=Result.failure(Exception("Error en el llamado a la API de Jikan"))
            }
        }catch (ex:Exception){
            Log.e(Constants.TAG, ex.stackTraceToString())
            result=Result.failure(Exception(ex))

        };
        return result!!

    }



}