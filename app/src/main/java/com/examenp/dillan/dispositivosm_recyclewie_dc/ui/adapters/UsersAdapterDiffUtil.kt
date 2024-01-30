package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.examenp.dillan.dispositivosm_recyclewie_dc.R
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.UsersItemsBinding
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.entities.FullInfoAnimeLG


class UsersAdapterDiffUtil(
    private val onDeleteItem:(Int) -> Unit,
    private val onSelectItem:(FullInfoAnimeLG)->Unit
):ListAdapter<FullInfoAnimeLG,UsersAdapterDiffUtil.ViewHolderUsers>(DiffUtilUserCallback) {


    class ViewHolderUsers(view: View) :RecyclerView.ViewHolder(view){

        private var binding: UsersItemsBinding=UsersItemsBinding.bind(view)
        fun render(
            item: FullInfoAnimeLG
            ,onDeleteItem:(Int) -> Unit
            , onSelectItem:(FullInfoAnimeLG)->Unit  ){
            binding.txtUserName.text=item.name
            binding.txtUserDesc.text=item.synopsis
            binding.imgUser.load(item.big_image)

            binding.btnBorrar.setOnClickListener {
                onDeleteItem(adapterPosition)
            }

            binding.imgUser.setOnClickListener {
                onSelectItem(item)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsers {
        val inflater= LayoutInflater.from(parent.context)
        return ViewHolderUsers(inflater.inflate(R.layout.users_items,parent,false))

    }


    override fun onBindViewHolder(holder: ViewHolderUsers, position: Int) {

        holder.render(getItem(position),onDeleteItem , onSelectItem)

    }


}

private object DiffUtilUserCallback : DiffUtil.ItemCallback<FullInfoAnimeLG>() {
    override fun areItemsTheSame(oldItem: FullInfoAnimeLG, newItem: FullInfoAnimeLG): Boolean {
        return (oldItem.id==newItem.id)
    }

    override fun areContentsTheSame(oldItem: FullInfoAnimeLG, newItem: FullInfoAnimeLG): Boolean {
        return (oldItem==newItem)
    }


}
