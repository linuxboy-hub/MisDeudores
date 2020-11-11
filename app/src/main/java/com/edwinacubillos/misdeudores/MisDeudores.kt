package com.edwinacubillos.misdeudores

import android.app.Application
import androidx.room.Room
import com.edwinacubillos.misdeudores.data.database.DeudorDatabase
import com.edwinacubillos.misdeudores.data.database.UsuarioDatabase

class MisDeudores : Application() {

    companion object {
        lateinit var database: DeudorDatabase
        lateinit var usuariodatabase: UsuarioDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            DeudorDatabase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()

        usuariodatabase = Room.databaseBuilder(
            this,
            UsuarioDatabase::class.java,
            "usuario_DB"
        ).allowMainThreadQueries()
            .build()
    }
}