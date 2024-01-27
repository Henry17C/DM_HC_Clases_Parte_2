package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.entities.Users
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.ActivityMainBinding
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.adapters.UsersAdapterDiffUtil
import com.google.android.material.snackbar.Snackbar
import com.test.dm_clases_hc.data.network.endpoint.jikan.top.TopAnimes
import com.test.dm_clases_hc.logic.entities.FullInfoAnimeLG
import com.test.dm_clases_hc.logic.usercases.jikan.JikanGetTopAnimesUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



}