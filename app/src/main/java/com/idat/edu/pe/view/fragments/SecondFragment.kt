package com.idat.edu.pe.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.idat.edu.pe.R
import com.idat.edu.pe.common.JsonPlaceholderPhotosAdapter
import com.idat.edu.pe.databinding.FragmentSecondBinding
import com.idat.edu.pe.viewmodel.JsonPlaceHolderViewModel

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var jsonPlaceHolderViewModel: JsonPlaceHolderViewModel
    private lateinit var adapter: JsonPlaceholderPhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)

        jsonPlaceHolderViewModel =
            ViewModelProvider(this)[JsonPlaceHolderViewModel::class.java]

        jsonPlaceHolderViewModel.responseObtenerFotos.observe(viewLifecycleOwner, Observer {
            adapter = JsonPlaceholderPhotosAdapter(binding.root.context, it)
            binding.rcvListadoFotos.layoutManager = LinearLayoutManager(binding.root.context)
            binding.rcvListadoFotos.adapter = adapter
        })

        jsonPlaceHolderViewModel.obtenerFotos()

        return binding.root
    }
}