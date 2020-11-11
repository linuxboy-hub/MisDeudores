package com.edwinacubillos.misdeudores.ui.registro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.data.database.entities.Usuario
import com.edwinacubillos.misdeudores.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.sql.Types.NULL

class RegistroActivity : AppCompatActivity() {

    companion object {
        private const val EMPTY = ""
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        //Log.d("Método", "onCreate")

        registrar_button.setOnClickListener {
            val nombre = nombre_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val correo = correo_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()
            val repContrasena = rep_contrasena_edit_text.text.toString()

            if (nombre.isEmpty()) {
                Toast.makeText(this, getString(R.string.nombre_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (correo.isEmpty()) {
                Toast.makeText(this, getString(R.string.mail_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (telefono.isEmpty()) {
                Toast.makeText(this, getString(R.string.telefono_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (contrasena.isEmpty()) {
                Toast.makeText(this, getString(R.string.password_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (repContrasena.isEmpty()) {
                Toast.makeText(this, getString(R.string.repassword_vacio), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (contrasena.length < 6) {
                Toast.makeText(this, getString(R.string.min_password), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (contrasena != repContrasena) {
                Toast.makeText(this, getString(R.string.nomatch_password), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            //val genero =
            //if (masculino_radio_button.isChecked) getString(R.string.masculino) else getString(R.string.femenino)

            //var pasatiempos = EMPTY
            //if (nadar_check_box.isChecked) pasatiempos += getString(R.string.nadar) + SPACE
            //if (cine_check_box.isChecked) pasatiempos += getString(R.string.cine) + SPACE
            //if (comer_check_box.isChecked) pasatiempos += getString(R.string.comer)


            //instancia del objeto
            val usuario = Usuario(NULL, nombre, telefono, correo, contrasena)

            //creacion del DAO
            val usuarioDAO: UsuarioDAO = MisDeudores.usuariodatabase.UsuarioDAO()

            //uso de la funcion insertar del DAO
            usuarioDAO.insertUsuario(usuario)

            //Toast de registro exitoso
            Toast.makeText(this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

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






