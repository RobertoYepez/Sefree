package com.example.sefree

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
import com.example.sefree.databinding.ActivityCreacionSefreeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class CreacionSefree : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityCreacionSefreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCreacionSefreeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = Firebase.auth
        createAccount()
        signIn()
        recuperarClave()
        //kjhskdjfhdkjfh

        binding.switch2.setOnClickListener{
            val miIntent = Intent(
                this,PoliticasYCondiciones::class.java)

            startActivityForResult(miIntent,1)}

    }

    //devolver respuesta de Politicas y condiciones para activar el switch

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1){
            if(resultCode==Activity.RESULT_OK){
                binding.switch2.isChecked = true
            }
        }
    }
    //Inicializa la sesion sin necesidad de volver a poner data
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun createAccount() {    // [START create_user_with_email]

        binding.bttonRegsitrarme.setOnClickListener {

            if (binding.switch2.isChecked) {

                if (!binding.etCorreo.text.toString().contains("@gmail.com")) {
                    Toast.makeText(baseContext, "corregir el correo ingresado", Toast.LENGTH_SHORT)
                        .show()
                }
                if (binding.etCorreo.text.isNotEmpty() && binding.etclave1.text.isNotEmpty()) {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(binding.etCorreo.text.toString(),
                            binding.etclave1.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {   // Sign in success, update UI with the signed-in user's information
                                ShowHome(binding.etCorreo.text.toString())  //con esta linea se puede enviar el correo a otra activity

                            } else {                  // If sign in fails, display a message to the user.
                                Log.e(TAG, "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                                updateUI(null)
                            }
                        }
                    // [END create_user_with_email]
                } else {
                    Toast.makeText(this, "campo(s) vacio(s)", Toast.LENGTH_SHORT).show()
                }
            }

            else{Toast.makeText(this,"Aceptar los terminos y condiciones",Toast.LENGTH_SHORT).show()}
        }
    }

    private fun signIn() {

        binding.bttonAcceder.setOnClickListener {
            if (!binding.etCorreo.text.toString().contains("@gmail.com")) {
                Toast.makeText(baseContext, "corregir el correo ingresado", Toast.LENGTH_SHORT)
                    .show()
            }

            if (binding.etCorreo.text.isNotEmpty() && binding.etclave1.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.etCorreo.text.toString(),
                        binding.etclave1.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {             // Sign in success, update UI with the signed-in user's information
                            ShowHome2()
                        } else {                             // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "clave incorrecta.",
                                Toast.LENGTH_SHORT).show()
                            updateUI(null)
                        }
                    }
                // [END singIn_user_with_email]
            } else {
                Toast.makeText(this, "No hay dato(s)", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun ShowHome(email: String) {
        val homeIntent = Intent(this, TipodeMovimiento::class.java).apply {
            putExtra("correo",
                email)  //enviar a la activity el correo, debe de existir un get en la activity que recibe para que funcione
        }
        startActivity(homeIntent)
    }

    private fun ShowHome2() {
        val homeIntent2 = Intent(this, TipodeMovimiento::class.java)
        startActivity(homeIntent2)
    }



    private fun recuperarClave(){

        binding.tvRecuperarclave.setOnClickListener(){

        val claveIntent = Intent(this,RecupClave::class.java)
        startActivity(claveIntent)
    }
    }

    private fun sendEmailVerification() {   //verificacion de correo enviando un mensaje a la bandeja del email
        // [START send_email_verification]
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email Verification sent
            }
        // [END send_email_verification]
    }  // Para enviar un correo de verificacion al correo y que acepten desde el email para que pueda usar el app

    private fun updateUI(user: FirebaseUser?) {  //Perfil de usuario donde figure una foto, correo, nombres y otros

    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "CreacionSefree"
    }
}