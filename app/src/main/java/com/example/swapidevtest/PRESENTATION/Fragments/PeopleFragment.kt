package com.example.swapidevtest.PRESENTATION.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.PRESENTATION.RecycleView.PeopleFragment.PersonRecyclerAdapter
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.PRESENTATION.RecycleView.PeopleFragment.AdPersonToDbAndMakeApiRequest
import com.example.swapidevtest.R
import com.example.swapidevtest.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class PeopleFragment() : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    val viewModel: PeopleViewModel by viewModels()

    lateinit var binding: FragmentPeopleBinding

    companion object {
        fun newInstance() = PeopleFragment()
    }
    @Inject
    lateinit var     adapter: PersonRecyclerAdapter



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
        adPeopleToDBandMakeFilmRequest()
        button()
        findPeopleViaEditText()
    }

    fun button() {

        binding.buttonToLikes.setOnClickListener {
            findNavController().navigate(R.id.action_peopleFragment_to_likesFragment)
        }

    }

    fun recycler(list:List<Person>?){

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

    fun adPeopleToDBandMakeFilmRequest(){
        adapter.bindAction(object:AdPersonToDbAndMakeApiRequest{
            override fun getFilms() {
            viewModel.getFilms()
            }

            override fun savePeopletoDb(personEntity: PersonEntity) {
                viewModel.savePeopleToDb(personEntity)
            }

        })
    }
    fun findPeopleViaEditText(){
        binding.edittext.afterTextChanged {  }
    }
    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            private var searchFor = ""
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val searchText = s.toString().trim()
                if (searchText.length < 2) {
                    println("!!!!!!!!!!!!!!!!!!   "+searchText.length.toString())
                    return
                } else {

                    searchFor = searchText
//                    viewModel.getPeople(qwerty = searchFor )

                    launch {
                        delay(3000)
                        if (searchText != searchFor)
                            return@launch
                        viewModel.getPeople(qwerty = searchFor )

//                        println("**********************************************************************")
                    }
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }
}

