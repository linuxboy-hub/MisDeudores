package com.edwinacubillos.misdeudores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val EMPTY = ""
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registrar_button.setOnClickListener {
            val nombre = nombre_edit_text.text.toString()
            val correo = correo_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val contrasena = contraseña_edit_text.text.toString()
            val repContrasena = rep_contraseña_edit_text.text.toString()
            val genero = if (masculino_radio_button.isChecked) getString(R.string.masculino) else getString(R.string.femenino)

            var pasatiempos = EMPTY
            if (nadar_check_box.isChecked) pasatiempos += getString(R.string.nadar) + SPACE
            if (cine_check_box.isChecked) pasatiempos += getString(R.string.cine) + SPACE
            if (comer_check_box.isChecked) pasatiempos += getString(R.string.comer)

            val ciudadDeNacimiento = ciudad_nacimiento_spinner.selectedItem

            respuesta_text_view.text = getString(R.string.respuesta, nombre, correo, telefono, genero, pasatiempos, ciudadDeNacimiento)
        }
    }
}