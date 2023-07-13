package com.example.swapidevtest.PRESENTATION.UI.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowapi.Presentation.UI.Base.UiState
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.AdPersonToDbAndMakeApiRequest
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildAdapter.ChildListAdapter
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.CommonListAdapter
import com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ProvideList
import com.example.swapidevtest.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainFragment() : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    val viewModel: MainViewModel by viewModels()

    lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var adapter: CommonListAdapter

    @Inject
    lateinit var subAdapter: ChildListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
//        // TODO: Use the ViewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        observeChanges()

        setupZipObserver()
        setupFilmsObserver()
        adPeopleToDBandMakeFilmRequest()
//        button()

        findPeopleViaEditText()
    }
//
//    fun button() {
//
//        binding.buttonToLikes.setOnClickListener {
//            findNavController().navigate(R.id.action_peopleFragment_to_likesFragment)
//        }
//
//    }


    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchPeopleState.collect {
                    when (it) {
                        is UiState.Success -> {
                            println("@@@$it")
                        }

                        is UiState.Loading -> {
                            println(it)
                        }

                        is UiState.Error -> {
                            //Handle Error
                            println("@@@${it.message}")
                            Toast.makeText(
                                requireContext(),
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun setupZipObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchZipListState.collect {
                    when (it) {
                        is UiState.Success -> {
                            it.data?.let {
                                commonRecycler(it)

                            }
                            println(it)
                        }

                        is UiState.Loading -> {
                            println(it)
                        }

                        is UiState.Error -> {
                            //Handle Error
                            println("@@@${it.message}")
                            Toast.makeText(
                                requireContext(),
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun setupFilmsObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchFilmsState.collect {
                    when (it) {
                        is UiState.Success -> {
                            it.data?.let {
//                                subRecycler(it.toMutableList())
                                adapter.bindList(object :ProvideList {
                                    override fun provideList(): MutableList<FilmResponse> {
                                      return it
                                    }
                                })

                            }

                            for (element in it.data) {
                                println("###" + element.title)
                            }

                            println(it)
                        }

                        is UiState.Loading -> {
                            println(it)
                        }

                        is UiState.Error -> {
                            //Handle Error
                            println("@@@${it.message}")
                            Toast.makeText(
                                requireContext(),
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    fun commonRecycler(list: MutableList<CommonItem>?) {

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(list)
    }

    fun subRecycler(list: MutableList<Any>?) {


//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//        }
//        binding.recyclerView.adapter = adapter
        subAdapter.submitList(list)
    }

    //    private fun observeChanges() {
//
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.searchPeople.collect {
//                    it?.let {
//                        val listOfPerson = it.people
////                        listOfPerson?.apply {recycler(this)
////
////                        }
//                        if(listOfPerson !=null){
//                        recycler(listOfPerson)}
//                        println(it.people.toString())
//
//                    }
//
//                }
//            }
//
//        }
//    }
//
    fun adPeopleToDBandMakeFilmRequest() {
        adapter.bindAction(object : AdPersonToDbAndMakeApiRequest {
            override fun getFilms(listOfFilms: MutableList<String>) {
                viewModel.getFilms(listOfFilms)
            }


            override fun savePeopletoDb(personEntity: PersonEntity) {
                viewModel.savePeopleToDb(personEntity)
            }

            override fun provideList(list: MutableList<Any>): MutableList<FilmResponse> {
                TODO("Not yet implemented")
            }


        })
    }

    fun findPeopleViaEditText() {
        binding.edittext.afterTextChanged { }
    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            private var searchFor = ""
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val searchText = s.toString().trim()
                if (searchText.length < 2) {

                    return
                } else {

                    searchFor = searchText
//                    viewModel.getPeople(qwerty = searchFor )

                    launch {
                        delay(3000)
                        if (searchText != searchFor)
                            return@launch
                        viewModel.getZipList(qwerty = searchFor)

                    }
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }
}




