package com.edwinacubillos.misdeudores.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.data.database.entities.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDatabase : RoomDatabase() {

    abstract fun UsuarioDAO(): UsuarioDAO
}