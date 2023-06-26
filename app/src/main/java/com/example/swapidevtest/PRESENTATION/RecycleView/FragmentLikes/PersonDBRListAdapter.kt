package com.example.swapidevtest.PRESENTATION.RecycleView.FragmentLikes

import com.example.swapidevtest.PRESENTATION.RecycleView.MyListClickListener
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.swapidevtest.DATA.DB.PersonDao
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.databinding.PersonDbBinding
import javax.inject.Inject

class PersonDBRListAdapter @Inject constructor(val dao: PersonDao) :
    ListAdapter<PersonEntity, MyModelVievHolder>(
        MyModelDiffUtill()
    ) {
    lateinit var binding: PersonDbBinding

    private var actions: MyListClickListener? = null
    fun bindAction(action: MyListClickListener) {
        this.actions = action
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelVievHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = PersonDbBinding.inflate(inflater, parent, false)

        return MyModelVievHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyModelVievHolder, position: Int) {
        val myPerson = getItem(position)
        holder.bindTo(myPerson)
        holder.binding.button2.setOnClickListener {


            actions.let {
                it?.deletePersonEntity(myPerson)
            }


        }

    }
}