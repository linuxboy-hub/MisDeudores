package com.edwinacubillos.misdeudores.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.edwinacubillos.misdeudores.data.database.entities.Deudor

@Dao
interface DeudorDAO {

    @Insert
    fun insertDeudor(deudor: Deudor)

    @Query("SELECT * FROM tabla_deudor WHERE nombre LIKE :nombre")
    fun searchDeudor(nombre: String): Deudor

    @Delete
    fun deleteDeudor(deudor: Deudor)
}