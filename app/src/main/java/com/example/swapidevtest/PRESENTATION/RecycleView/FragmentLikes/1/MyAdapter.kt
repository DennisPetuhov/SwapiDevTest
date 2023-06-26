package com.example.recyclerretrofitsealed.RecyclerView

import com.example.swapidevtest.PRESENTATION.RecycleView.MyListClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DATA.DB.PersonDao
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.databinding.PersonDbBinding
import javax.inject.Inject

class MyAdapter @Inject constructor(val dao: PersonDao) : RecyclerView.Adapter<MyViewHolder>() {
    var personList: MutableList<PersonEntity> = mutableListOf() // ?=null


    private var actions: MyListClickListener? = null
    fun bindAction(action: MyListClickListener) {
          this.actions = action
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = PersonDbBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person: PersonEntity = personList[position]
//        // обновить элемент списка
//        val item =
//            getItem(holder.layoutPosition)//layoutPosition Returns the position of the ViewHolder
//        // in terms of the latest layout pass.This position is mostly used by RecyclerView
//        // components to be consistent while RecyclerView lazily processes adapter updates.
        holder.bindTo(person)

        holder.binding.button2.setOnClickListener {
            actions.let {
                it?.deletePersonEntity(person)

            }




        }

    }

    override fun getItemCount(): Int {
        return personList.size

    }
    private fun getItem(position: Int): PersonEntity {

        return personList[position]
    }

    fun updateList(list: MutableList<PersonEntity>) {
        val diffCallBack = MovieDiffUtill(personList, list)
        val diference = DiffUtil.calculateDiff(diffCallBack, true)
        personList = list
        diference.dispatchUpdatesTo(this)



    }


}