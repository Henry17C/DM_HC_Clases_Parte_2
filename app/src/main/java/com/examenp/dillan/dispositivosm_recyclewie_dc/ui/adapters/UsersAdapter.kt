package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.examenp.dillan.dispositivosm_recyclewie_dc.R
import com.examenp.dillan.dispositivosm_recyclewie_dc.data.entities.Users
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.UsersItemsBinding

class UsersAdapter(
   private val onDeleteItem:(Int)-> Unit,
   private val onSelectItem:(Users)->Unit)
    :RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    public var listUsers: List<Users> = listOf()

    class UsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //se maneja los elementos(items)  uno por uno iterativamente. Esta se
        // manera de acuerdo a las necesidades de la aplicacion, es maneja la logica ligada a la UI, no a la logica de negocio
        private var binding: UsersItemsBinding = UsersItemsBinding.bind(view)

        fun render(item: Users,
                   onDeleteItem:(Int)-> Unit,
                   onSelectItem:(Users)->Unit) {
            binding.UserName.text=item.name
            binding.UserDesc.text=item.desc
            binding.imgUser.load(item.img)
            binding.btnBorrar.setOnClickListener {
                onDeleteItem(adapterPosition)
            }
            binding.imgUser.setOnClickListener{
                onSelectItem(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        //se hace el binding para el  layout que tenemos
        val inflater = LayoutInflater.from(parent.context) //

        return UsersViewHolder(inflater.inflate(R.layout.users_items, parent, false)) //

    }

    //cuantos elementos hay para poder pintar en pantalla
    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.render(listUsers[position], onDeleteItem, onSelectItem)
    }


}