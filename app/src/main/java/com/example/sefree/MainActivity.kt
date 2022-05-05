package com.example.sefree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.sefree.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.getInstance
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    private lateinit var firebaseAnalytics: FirebaseAnalytics
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//ANALYTICS EVENT las siguientes 4 lineas y 2 lineas de arriba que dicen firebase
        
        val analytics : FirebaseAnalytics  = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle ()
        bundle.putString("mensaje","Integracion SeFree completa")
        analytics.logEvent("InitScreen", bundle)





        binding.CrearCuenta.setOnClickListener {
            val miIntent = Intent(
                this,CreacionSefree::class.java)

            startActivity(miIntent)}

        }



    }

