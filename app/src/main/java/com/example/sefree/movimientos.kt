package com.example.sefree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sefree.databinding.ActivityMovimientosBinding

class movimientos : AppCompatActivity() {

    private lateinit var binding: ActivityMovimientosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMovimientosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btGuardar.setOnClickListener {

            if (validateFields()) {
                val miIntent = Intent(this, DetalleMovimientos::class.java)
                miIntent.putExtra("descripcion", binding.etDetalle.text.toString())
                miIntent.putExtra("gasto", binding.etImporte.text.toString().toDouble())

                startActivity(miIntent)
            }
        }
    }
    fun validateFields(): Boolean {

        if (binding.etDetalle.text.toString().equals("") || binding.etDetalle.text == null) {
            Toast.makeText(this, "Necesitas introducir una descripcion.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.etImporte.text.toString().equals("") || binding.etImporte.text == null) {
            Toast.makeText(this, "Necesitas introducir un gasto.", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
