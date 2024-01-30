package com.examenp.dillan.dispositivosm_recyclewie_dc.logic.usercases.jikan
import android.util.Log
import com.examenp.dillan.dispositivosm_recyclewie_dc.core.getFullInfoAnimeLG
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.endpoints.AnimeEndPoint
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.network.repository.RetrofitBase
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.entities.FullInfoAnimeLG
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.Constants


class JikanAnimeUserCase {

    suspend fun getFullAnimeInfo(nameAnime:Int): Result<FullInfoAnimeLG> {

        var result:Result<FullInfoAnimeLG>?=null
        var infoAnime: FullInfoAnimeLG = FullInfoAnimeLG()
        Log.d(Constants.TAG, "antes de try: ")
        try {
            val baseService= RetrofitBase.getRetrofitJikanConnection()
            Log.d(Constants.TAG, "baseService")
            val service= baseService.create(AnimeEndPoint::class.java) //creo mi servicio
            Log.d(Constants.TAG, "service")
            val call= service.getAnimeFullInfo(nameAnime) //ahora si podria acceder a travez de servicio a los metodos
            //me revuelve un response de FullInfoAnime
            Log.d(Constants.TAG, "call")

            Log.d(Constants.TAG, "antes de call.isSu..: "+call)
            if(call.isSuccessful){
                Log.d(Constants.TAG, "call: "+call)
                val a=call.body()!!
                infoAnime=a.getFullInfoAnimeLG()


                result = Result.success(infoAnime)
                Log.d(Constants.TAG, "result: "+result)
            }else{
                Log.d(Constants.TAG, "Error en el llamado a la API de Jikan")
                result=Result.failure(Exception("Error en el llamado a la API de Jikan"))
            }
        }catch (ex:Exception){
            Log.e(Constants.TAG,"catch: " +ex.stackTraceToString())
            result=Result.failure(Exception(ex))
        };
        return result!!
    }

    fun getAllTopsAnimes(){

        //return List<FullInfoAnimeLG>() //"Listadod de animes"
    }

}