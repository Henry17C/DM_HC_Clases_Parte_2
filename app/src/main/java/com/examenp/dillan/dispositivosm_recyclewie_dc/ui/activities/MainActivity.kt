package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.examenp.dillan.dispositivosm_recyclewie_dc.R
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.entities.Users
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.ActivityMainBinding
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.adapters.UsersAdapter
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.adapters.UsersAdapterDiffUtil
import com.google.android.material.snackbar.Snackbar
import okhttp3.internal.notify

class MainActivity : AppCompatActivity() {


    private var userList: MutableList<Users> = ArrayList<Users>()
    private var count: Int = 1

    private lateinit var binding: ActivityMainBinding
    private var usersAdapter = UsersAdapter({deleteUsers(it)},{selectUser(it)})// uso de funcion lamda y un iteretor que sabe la posicion que se elmina
   private var userDiffAdapter= UsersAdapterDiffUtil({deleteUsersDiff(it)},{selectUser(it)})
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
        initListeners()
    }

    fun initRecycleView() {
        binding.rvUsers.adapter = userDiffAdapter
        binding.rvUsers.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

    }

    fun initListeners() {
        binding.btnListener.setOnClickListener {
            val usuarios = Users(
                1,
                "Henry $count",
                "Doctor profesor Patricio",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDBIA8BA0-Iry0msdzBgIsZ6g8g022Yiy-kA&usqp=CAU"
            )
            count++

         // insertUsers(usuarios)
            insertUsersDiff(usuarios)
        }
    }

    private fun insertUsers(usuarios: Users) {
        userList.add(usuarios)
        Log.d("List", userList.toString())
        usersAdapter.listUsers= userList
        usersAdapter.notifyItemInserted(userList.size)
    }


    private fun deleteUsers(position : Int){
        userList.removeAt(position)
        usersAdapter.listUsers= userList
        usersAdapter.notifyItemRemoved(position)
    }

    private fun insertUsersDiff(usuarios: Users) {
        userList.add(usuarios)
        userDiffAdapter.submitList(userList.toList())

    }


    private fun deleteUsersDiff(position : Int){
        userList.removeAt(position)
        userDiffAdapter.submitList(userList.toList())

    }




    private  fun selectUser(user: Users){
        Snackbar.make(this, binding.btnListener, user.name, Snackbar.LENGTH_LONG).show()
        /*val i= Intent(this,Illegada)
        i.putExtra("usuarioId", user.id)
        startActivity(i)*/
    }




}