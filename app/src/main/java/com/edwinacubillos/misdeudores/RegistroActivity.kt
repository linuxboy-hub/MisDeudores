package com.edwinacubillos.misdeudores

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    companion object {
        private const val EMPTY = ""
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val datosRecibidos = intent.extras
        val numeroEnviado = datosRecibidos?.getInt("numero")
        Toast.makeText(this, "El número enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()


        Log.d("Método", "onCreate")

        registrar_button.setOnClickListener {
            val correo = correo_edit_text.text.toString()
            val contrasena = contraseña_edit_text.text.toString()

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("correo", correo)
            intent.putExtra("contrasena", contrasena)
            startActivity(intent)
            finish()

            val nombre = nombre_edit_text.text.toString()

            val telefono = telefono_edit_text.text.toString()

            val repContrasena = rep_contraseña_edit_text.text.toString()
            val genero =
                if (masculino_radio_button.isChecked) getString(R.string.masculino) else getString(R.string.femenino)

            var pasatiempos = EMPTY
            if (nadar_check_box.isChecked) pasatiempos += getString(R.string.nadar) + SPACE
            if (cine_check_box.isChecked) pasatiempos += getString(R.string.cine) + SPACE
            if (comer_check_box.isChecked) pasatiempos += getString(R.string.comer)

            val ciudadDeNacimiento = ciudad_nacimiento_spinner.selectedItem
            respuesta_text_view.text = getString(
                R.string.respuesta,
                nombre,
                correo,
                telefono,
                genero,
                pasatiempos,
                ciudadDeNacimiento
            )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Método", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Método", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Método", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Método", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Método", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Método", "onRestart")
    }
}






