package com.idat.edu.pe.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.idat.edu.pe.databinding.ActivityMainBinding
import com.idat.edu.pe.model.Paciente

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pacientes: List<Paciente>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarPacientes()

        binding.bntLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val codPaciente = binding.tvCodPaciente.text.toString()
        val password = binding.tvPassword.text.toString()
        var existUser = false

        for (paciente: Paciente in pacientes) {
            if (paciente.codPaciente == codPaciente && paciente.password == password) existUser =
                true
        }

        if (existUser) startActivity(
            Intent(this, HomeActivity::class.java))
        else Toast.makeText(this, "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT)
            .show()
    }

    private fun cargarPacientes() {
        pacientes = listOf(Paciente("P957463928", "password", "Juan Morales", "957463928"),
            Paciente("P928475869", "password", "Maria Becerra", "928475869"),
            Paciente("P903485712", "password", "Catalina Aguirre", "903485712"))
    }
}