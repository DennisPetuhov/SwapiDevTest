package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DATA.DB.PersonDao

import com.example.swapidevtest.DOMAIN.model.CommonItem

import com.example.swapidevtest.databinding.PersonViewBinding
import com.example.swapidevtest.databinding.StarshipViewBinding
import javax.inject.Inject

class CommonListAdapter @Inject constructor(val dao: PersonDao) :
    ListAdapter<CommonItem, RecyclerView.ViewHolder>(
        MyModelDiffUtill()
    ) {

    var action: AdPersonToDbAndMakeApiRequest? = null
    fun bindAction(action: AdPersonToDbAndMakeApiRequest) {
        this.action = action
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  {
        val inflater = LayoutInflater.from(parent.context)
       return when (viewType) {
            CommonItem.ItemType.TYPE_PERSON-> {
              val  binding = PersonViewBinding.inflate(inflater, parent, false)
                 PersonVievHolder(binding)
            }

            CommonItem.ItemType.TYPE_STARSHIP -> {
              val  binding = StarshipViewBinding.inflate(inflater, parent, false)
               StarShipViewHolder(binding)
            }


           else -> { throw IllegalAccessError ("no such view")}
       }


    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CommonItem.Person -> CommonItem.ItemType.TYPE_PERSON
            is CommonItem.StarShips -> CommonItem.ItemType.TYPE_STARSHIP
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is StarShipViewHolder-> {
                holder.bindStarship(item as CommonItem.StarShips)
            }
            is PersonVievHolder ->{ holder.bindPerson(item as CommonItem.Person)

            }

        }

//        holder.binding.button2.setOnClickListener {
//            action.let {
//                it?.savePeopletoDb(PersonEntity().personToPersonEntity(myPerson))
//            }
//
//
//        }

    }
}