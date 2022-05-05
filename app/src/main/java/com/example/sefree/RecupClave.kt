package com.example.sefree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sefree.databinding.ActivityRecupClaveBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecupClave : AppCompatActivity() {
    lateinit var binding: ActivityRecupClaveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecupClaveBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btCorreoRecuperar.setOnClickListener() {
            if (!binding.etCorreoRecuperar.text.toString().contains("@gmail.com")) {
                Toast.makeText(baseContext, "corregir el correo ingresado", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val correoelectronico = binding.etCorreoRecuperar.text.toString()
                Firebase.auth.sendPasswordResetEmail(correoelectronico)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val ceIntent = Intent(this, CreacionSefree::class.java)
                            startActivity(ceIntent)

                        } else {

                            Toast.makeText(this, "Ingrese un email de una cuenta valida.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}