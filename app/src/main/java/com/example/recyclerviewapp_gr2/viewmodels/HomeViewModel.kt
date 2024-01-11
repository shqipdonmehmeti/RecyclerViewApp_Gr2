package com.example.recyclerviewapp_gr2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewapp_gr2.helpers.Helpers
import com.example.recyclerviewapp_gr2.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    val listOfUsers: MutableLiveData<List<User>> = MutableLiveData(mutableListOf())
    val loading: MutableLiveData<Boolean> = MutableLiveData(false)
    init {
//        getUsers()
    }

    fun getUsers() {
            loading.value = true

            Helpers.provideRetrofitInstance().getUsers().enqueue(object : Callback<List<User>?> {
                override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                    if (response.isSuccessful && response.body() != null) {
                        listOfUsers.value = response.body()!!
                    }
                    loading.value = false
                }

                override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                    loading.value = false
                }
            })
    }
}