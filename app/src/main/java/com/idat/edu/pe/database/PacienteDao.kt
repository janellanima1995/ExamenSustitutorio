package com.idat.edu.pe.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PacienteDao {
    @Insert
    fun addPaciente(pacienteEntity: PacienteEntity): Long
}