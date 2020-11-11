package com.edwinacubillos.misdeudores.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.UsuarioDAO
import com.edwinacubillos.misdeudores.ui.bottom.BottomActivity
import com.edwinacubillos.misdeudores.ui.registro.RegistroActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registrar_button.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }

        iniciar_sesion_button.setOnClickListener {
            val correo = correo_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()

            if (correo.isEmpty()) {
                Toast.makeText(this, "Ingrese su correo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (contrasena.isEmpty()) {
                Toast.makeText(this, "Ingrese su contrasena", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //instancia del DAO
            val usuarioDAO: UsuarioDAO = MisDeudores.usuariodatabase.UsuarioDAO()
            val usuario = usuarioDAO.searchUsuario(correo)

            if (usuario != null) {
                if (usuario.contrasena == contrasena) {
                    Toast.makeText(this, "BIENVENIDO!!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, BottomActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Contrasena incorrecta", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            } else {
                Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }
    }
}