package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DATA.DB.PersonDao

import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.ItemType
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildAdapter.ChildListAdapter
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildStarshipAdapter.ChildStarShipListAdapter
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.SAM.MyPrinterInterface
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.SAM.ProvideList
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.SAM.SavePersonToDBFlow

import com.example.swapidevtest.databinding.PersonViewBinding
import com.example.swapidevtest.databinding.StarshipViewBinding
import com.example.ui.DATA.Api.ApiService
import javax.inject.Inject

class CommonListAdapter @Inject constructor(val dao: PersonDao, val apiService: ApiService) :
    ListAdapter<CommonItem, RecyclerView.ViewHolder>(
        MyModelDiffUtil()
    ) {

    lateinit var subAdapterPerson: ChildListAdapter
    lateinit var subAdapterStarShip: ChildStarShipListAdapter

    private var printer: MyPrinterInterface? = null
    private var pressToSavePersonToDBFlow: SavePersonToDBFlow? = null
//    private var pressToSavePersonToDB: SavePersonToDB? = null
//    fun bindPressToSavePersonToDb(action: SavePersonToDB) {
//        this.pressToSavePersonToDB = action
//    }

    fun bindPressToSavePersonToDbFLOW(action: SavePersonToDBFlow) {
        this.pressToSavePersonToDBFlow = action
    }

    fun bindPrinter(printer: MyPrinterInterface) {
        this.printer = printer
    }

    var action: AdPersonToDbAndMakeApiRequest? = null
    var list: ProvideList? = null
    fun bindAction(action: AdPersonToDbAndMakeApiRequest) {
        this.action = action
    }

    fun bindList(list: ProvideList) {
        this.list = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ItemType.TYPE_PERSON -> {
                val binding = PersonViewBinding.inflate(inflater, parent, false)
                PersonVievHolder(binding)
            }

            ItemType.TYPE_STARSHIP -> {
                val binding = StarshipViewBinding.inflate(inflater, parent, false)
                StarShipViewHolder(binding)
            }


            else -> {
                throw IllegalAccessError("no such view")
            }
        }


    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CommonItem.Person -> ItemType.TYPE_PERSON
            is CommonItem.StarShips -> ItemType.TYPE_STARSHIP
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is StarShipViewHolder -> {
                holder.bindStarship(item as CommonItem.StarShips)
                subAdapterStarShip = ChildStarShipListAdapter()
                val layoutManager = LinearLayoutManager(
                    holder.binding.root.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                holder.binding.subRecyclerView.layoutManager = layoutManager

                holder.binding.subRecyclerView.adapter = subAdapterStarShip



                holder.binding.starshipLayout.setOnClickListener {

                    subAdapterStarShip.submitList(item.listOfFilmResponse.toList())







                    printer.let {
                        it?.print(item.name)
                    }

                    if (holder.binding.subRecyclerView.isVisible) {
                        holder.binding.subRecyclerView.visibility = View.GONE
                    } else {
                        holder.binding.subRecyclerView.visibility = View.VISIBLE
                    }
                }

            }

            is PersonVievHolder -> {

                holder.bindPerson(item as CommonItem.Person)


                subAdapterPerson = ChildListAdapter()
                val layoutManager = LinearLayoutManager(
                    holder.binding.root.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                holder.binding.subRecyclerView.layoutManager = layoutManager

                holder.binding.subRecyclerView.adapter = subAdapterPerson

                subAdapterPerson.submitList(item.listOfFilmResponse.toList())

                holder.binding.personLayout.setOnClickListener {

                    if (holder.binding.subRecyclerView.isVisible) {
                        holder.binding.subRecyclerView.visibility = View.GONE
                    } else {
                        holder.binding.subRecyclerView.visibility = View.VISIBLE
                    }
                }
                holder.binding.button2.setOnClickListener {
                    pressToSavePersonToDBFlow.let {
                        it?.savePersonToDbFlow(item)
                    }


                }


            }

        }


    }
}