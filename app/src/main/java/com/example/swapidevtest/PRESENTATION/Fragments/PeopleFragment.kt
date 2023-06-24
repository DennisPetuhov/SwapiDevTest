package com.example.swapidevtest.PRESENTATION.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapyter.PersonRecyclerAdapter
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleFragment : Fragment() {
    val viewModel: PeopleViewModel by viewModels()

    lateinit var binding: FragmentPeopleBinding

    companion object {
        fun newInstance() = PeopleFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
//        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeChanges()
        button()
    }

    fun button() {
        binding.button.setOnClickListener {
            viewModel.getPeople()
        }

    }

    fun recycler(list:List<Person>?){
        val adapter = PersonRecyclerAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.recyclerView.adapter=adapter
        adapter.submitList(list)
    }
    private fun observeChanges() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchPeople.collect {
                    it?.let {
                        val listOfPerson = it.people
//                        listOfPerson?.apply {recycler(this)
//
//                        }
                        if(listOfPerson !=null){
                        recycler(listOfPerson)}
                        println(it.people.toString())

                    }

                }
            }

        }
    }
}

