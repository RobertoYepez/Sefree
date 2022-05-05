package com.example.sefree

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sefree.databinding.ActivityCreacionSefreeBinding
import com.example.sefree.databinding.ActivityPoliticasYcondicionesBinding

class PoliticasYCondiciones : AppCompatActivity() {

    lateinit var binding: ActivityPoliticasYcondicionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPoliticasYcondicionesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//Preguntar a Nando como vincular el click en aceptar de esta activity con el switch de la activity de Creacion Sefree, hacer que se ponga en ON el switch
        binding.bttAceptar.setOnClickListener{

        setResult(Activity.RESULT_OK)
            finish()

        }
    }
}