package com.example.recyclerviewapp_gr2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recyclerviewapp_gr2.databinding.FragmentGalleryBinding
import com.example.recyclerviewapp_gr2.models.Person

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val person = Person("Filan","Fisteku",99)
        val person = Person(
            firstName = "Filan",
            lastName = "Fisteku",
            age = 99
        )
        binding.personObject = person
    }







}