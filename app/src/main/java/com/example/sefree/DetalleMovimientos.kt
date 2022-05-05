package com.example.sefree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sefree.databinding.ActivityDetalledeMovimientosBinding
import com.example.sefree.databinding.ActivityMovimientosBinding
import com.example.sefree.models.Category
import com.google.gson.Gson

class DetalleMovimientos : AppCompatActivity() {

    private lateinit var binding: ActivityDetalledeMovimientosBinding

    private var descripcion: String? = null
    private var gasto: Double? = null
    private var item: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetalledeMovimientosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupData()
        initViews()
    }

    private fun setupData() {
        descripcion = intent.getStringExtra("descripcion")
        gasto = intent.getDoubleExtra("gasto", 0.0)
        item = Gson().fromJson(intent.getStringExtra("data"), Category::class.java)

    }

    private fun initViews() {
        binding.tvDescrip.text = descripcion
        binding.tvGasto.text = "S/ $gasto"
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()

    }
}