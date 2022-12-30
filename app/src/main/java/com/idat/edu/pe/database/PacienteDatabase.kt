package com.idat.edu.pe.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PacienteEntity::class], version = 1)
abstract class PacienteDatabase : RoomDatabase() {
    abstract fun pacienteDao(): PacienteDao
}