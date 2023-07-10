package com.example.swapidevtest.PRESENTATION.UI.RecycleView.FragmentLikes

import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MyListClickListener
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.swapidevtest.DATA.DB.PersonDao
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.databinding.PersonViewLikesBinding
import javax.inject.Inject

class PersonDBRListAdapter @Inject constructor(val dao: PersonDao) :
    ListAdapter<PersonEntity, MyModelVievHolder>(
        MyModelDiffUtill()
    ) {
    lateinit var binding: PersonViewLikesBinding

    private var actions: MyListClickListener? = null
    fun bindAction(action: MyListClickListener) {
        this.actions = action
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelVievHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = PersonViewLikesBinding.inflate(inflater, parent, false)

        return MyModelVievHolder(binding)
    }


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