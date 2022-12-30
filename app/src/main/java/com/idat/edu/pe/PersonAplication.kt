package com.idat.edu.pe

import android.app.Application
import androidx.room.Room
import com.idat.edu.pe.database.PacienteDatabase

class PersonAplication : Application() {

    companion object {
        lateinit var database: PacienteDatabase
    }

    override fun onCreate() {
        super.onCreate()

    }
}