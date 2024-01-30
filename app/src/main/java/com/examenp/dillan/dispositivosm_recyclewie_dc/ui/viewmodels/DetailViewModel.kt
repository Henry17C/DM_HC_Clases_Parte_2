package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.load
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.entities.FullInfoAnimeLG
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.usercases.jikan.JikanAnimeUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel: ViewModel() {


    val anime= MutableLiveData<FullInfoAnimeLG>()
    val error= MutableLiveData<String>()
    fun loadInfoAnime(animeID:Int){
        Log.d("UCE",animeID.toString())

        viewModelScope.launch(Dispatchers.Main) {

            val resp= withContext(Dispatchers.IO){
                JikanAnimeUserCase().getFullAnimeInfo(animeID)
            }

            resp.onSuccess {
                it.name=it.name+"La gloriosa"
                anime.postValue(it)
            }
            resp.onFailure {
                error.postValue(it.message.toString())
            }


        }
    }

}