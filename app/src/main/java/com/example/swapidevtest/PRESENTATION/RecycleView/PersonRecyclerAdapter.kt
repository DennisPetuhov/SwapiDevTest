package com.example.listadapyter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.databinding.PersonViewBinding

class PersonRecyclerAdapter :ListAdapter<Person,MyModelVievHolder>(MyModelDiffUtill()) {
    lateinit var binding: PersonViewBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelVievHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding=PersonViewBinding.inflate(inflater,parent,false)
//        val view=inflater.inflate(R.layout.model_view,parent,false)
       return MyModelVievHolder(binding)
    }

    override fun onBindViewHolder(holder: MyModelVievHolder, position: Int) {
        val myModel =getItem(position)
       holder.bindTo(myModel)

    }
}