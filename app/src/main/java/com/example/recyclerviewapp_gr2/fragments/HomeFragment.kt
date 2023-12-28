package com.example.recyclerviewapp_gr2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp_gr2.adapters.UserAdapter
import com.example.recyclerviewapp_gr2.databinding.FragmentHomeBinding
import com.example.recyclerviewapp_gr2.helpers.Helpers.provideRetrofitInstance
import com.example.recyclerviewapp_gr2.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

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

        provideRetrofitInstance().getUsers().enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                if (response.isSuccessful && response.body() != null) {
                    val listOfUsers = response.body()!!
                    val userAdapter = UserAdapter(listOfUsers)
                    binding.rvUserList.layoutManager = LinearLayoutManager(requireContext())
//                    binding.rvUserList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false) -> show list in horizontal orientation
                    binding.rvUserList.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {

            }
        })
    }
}