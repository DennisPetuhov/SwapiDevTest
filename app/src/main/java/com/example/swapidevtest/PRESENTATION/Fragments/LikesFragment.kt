package com.example.swapidevtest.PRESENTATION.Fragments

import androidx.lifecycle.ViewModelProvider
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
import com.example.swapidevtest.DATA.DB.PersonDao
import com.example.swapidevtest.R
import com.example.swapidevtest.databinding.FragmentLikesBinding
import com.example.swapidevtest.databinding.FragmentPeopleBinding
import com.example.swapidevtest.databinding.PersonViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class LikesFragment  : Fragment() {
    private lateinit var binding: FragmentLikesBinding
    private val viewModel: LikesViewModel by viewModels()



    companion object {
        fun newInstance() = LikesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikesBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeChanges()
        button()
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

    private fun observeChanges() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listOfPeople.collect {

                        println(it.people.toString())

                    }

                }
            }

        }
    }

