package com.example.listadapyter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.swapidevtest.DATA.DB.PersonDao
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DATA.DB.personToPersonEntity
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.databinding.PersonViewBinding
import javax.inject.Inject

class PersonRecyclerAdapter @Inject constructor(val dao: PersonDao) :ListAdapter<Person,MyModelVievHolder>(MyModelDiffUtill()) {
    lateinit var binding: PersonViewBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyModelVievHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding=PersonViewBinding.inflate(inflater,parent,false)

       return MyModelVievHolder(binding)
    }

    override fun onBindViewHolder(holder: MyModelVievHolder, position: Int) {
        val myPerson
        =getItem(position)
       holder.bindTo(myPerson)
        holder.binding.button2.setOnClickListener {

            dao.insertPerson(PersonEntity().personToPersonEntity(myPerson))


        }

    }
}