package com.idat.edu.pe.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.idat.edu.pe.R
import com.idat.edu.pe.common.JsonPlaceholderAdapter
import com.idat.edu.pe.databinding.FragmentFirstBinding
import com.idat.edu.pe.viewmodel.JsonPlaceHolderViewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var jsonPlaceHolderViewModel: JsonPlaceHolderViewModel
    private lateinit var adapter: JsonPlaceholderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        jsonPlaceHolderViewModel =
            ViewModelProvider(this)[JsonPlaceHolderViewModel::class.java]

        jsonPlaceHolderViewModel.responseObtenerDatos.observe(viewLifecycleOwner, Observer {
            adapter = JsonPlaceholderAdapter(binding.root.context, it)
            binding.rcvListado.layoutManager = LinearLayoutManager(binding.root.context)
            binding.rcvListado.adapter = adapter
        })

        jsonPlaceHolderViewModel.obtenerDatos()

        return binding.root
    }
}