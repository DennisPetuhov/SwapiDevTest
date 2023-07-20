package com.example.swapidevtest.PRESENTATION.UI.Fragments

import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MyListClickListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.FragmentLikes.PersonDBRListAdapter
import com.example.swapidevtest.R
import com.example.swapidevtest.databinding.FragmentLikesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LikesFragment : Fragment() {
    private lateinit var binding: FragmentLikesBinding
    private val viewModel: LikesViewModel by viewModels()

    @Inject
    lateinit var adapter: PersonDBRListAdapter

//    @Inject
//    lateinit var adapterR: MyAdapter


    companion object {
        fun newInstance() = LikesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        deleteItemFromList()
        button()
        observeChanges()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    fun button() {

        binding.buttonToMainFragment.setOnClickListener {
            findNavController().navigate(R.id.action_likesFragment_to_peopleFragment)
        }
        binding.button4.setOnClickListener {
            viewModel.getPeopleFromDB()


        }

    }

    fun listRecycler(list: List<PersonEntity>?) {

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(list?.toMutableList())
    }


//    private fun setupRecyclerView(list: MutableList<PersonEntity>?) {
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(requireContext())
////            adapter=adapterR
//            list?.let {
//                adapterR.updateList(it)
//
//
//            }
//        }
//
//    }

    private fun observeChanges() {

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {


                viewModel.listOfPeople.collect {
                    listRecycler(it)

//                    adapterR.updateList(it)

//                    setupRecyclerView(it)

                    println(it)

                }

            }
        }

    }


//    private fun deleteItemFromList() {
//
//
//        adapter.bindAction(object : MyListClickListener {
//            override fun deletePersonEntity(person: PersonEntity) {
//                viewModel.deletePersonEntity(person)
//                viewModel.getPeopleFromDB()
//
//            }
//        })
//
//
////        binding.recyclerView.adapter = adapterR
//
//    }
}

