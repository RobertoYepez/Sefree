package com.example.sefree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.sefree.databinding.ActivityTipodeMovimientoBinding

class TipodeMovimiento : AppCompatActivity() {

    lateinit var binding: ActivityTipodeMovimientoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTipodeMovimientoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.Ingresos.setOnClickListener {
            val miIntent = Intent(
                this, ClasificacionMovimiento::class.java)
            miIntent.putExtra("type", "e")

            startActivity(miIntent)
        }

        binding.Egresos.setOnClickListener {
            val miIntent = Intent(
                this, ClasificacionMovimiento::class.java)
            miIntent.putExtra("type", "i")
            startActivity(miIntent)
        }

    }
}