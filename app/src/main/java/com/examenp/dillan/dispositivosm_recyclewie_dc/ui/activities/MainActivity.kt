package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.examenp.dillan.dispositivosm_recyclewie_dc.R
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.entities.Users
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.ActivityMainBinding
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.adapters.UsersAdapter

class MainActivity : AppCompatActivity() {


    private var userList: MutableList<Users> = ArrayList<Users>()
    private lateinit var binding: ActivityMainBinding
    private var usersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
        initListeners()
    }

    fun initRecycleView() {
        binding.rvUsers.adapter = usersAdapter
        binding.rvUsers.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

    }

    fun initListeners() {
        binding.btnListener.setOnClickListener {
            val usuarios = Users(
                1,
                "Henry",
                "Doctor profesor Patricio",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDBIA8BA0-Iry0msdzBgIsZ6g8g022Yiy-kA&usqp=CAU"
            )

            userList.add(usuarios)
            Log.d("List", userList.toString())
            usersAdapter.listUsers= userList
            usersAdapter.notifyDataSetChanged()
        }
    }
}