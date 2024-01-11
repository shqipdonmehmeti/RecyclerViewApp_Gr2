package com.example.recyclerviewapp_gr2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp_gr2.adapters.UserAdapter
import com.example.recyclerviewapp_gr2.databinding.FragmentHomeBinding
import com.example.recyclerviewapp_gr2.helpers.Helpers.provideRetrofitInstance
import com.example.recyclerviewapp_gr2.models.User
import com.example.recyclerviewapp_gr2.viewmodels.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getUsers()
        observeData()
    }

    private fun observeData() {
        viewModel.listOfUsers.observe(viewLifecycleOwner) {listOfUsers ->
            val userAdapter = UserAdapter(listOfUsers)
            binding.rvUserList.layoutManager = LinearLayoutManager(requireContext())
            binding.rvUserList.adapter = userAdapter
        }

        viewModel.loading.observe(viewLifecycleOwner){ loading ->
            if (loading){
                binding.progressBar.visibility = View.VISIBLE
            }else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}















