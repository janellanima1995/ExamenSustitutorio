package com.idat.edu.pe.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PacienteEntity")
data class PacienteEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var codPaciente: String?,
    var password: String,
    var nombreApellido: String,
    var celular: String
)
