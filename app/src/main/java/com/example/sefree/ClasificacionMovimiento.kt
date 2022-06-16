package com.example.sefree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sefree.adapter.CustomAdapter
import com.example.sefree.databinding.ActivityClasificacionMovimientoBinding
import com.example.sefree.models.Category
import com.google.gson.Gson

class ClasificacionMovimiento : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter

    lateinit var binding: ActivityClasificacionMovimientoBinding

    private var type: String? = null
    val listCategories = arrayListOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClasificacionMovimientoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupData()
        initView()
        initListeners()

    }

    private fun setupData() {
        type = intent.getStringExtra("type")

        val listener = object : CustomAdapter.CustomAdapterListener {
            override fun onClickContainer(item: Category) {
                val intent = Intent(this@ClasificacionMovimiento, movimientos::class.java)
                intent.putExtra("data", Gson().toJson(item).toString())
                startActivity(intent)
            }

        }

        adapter = CustomAdapter(listener)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }


    private fun initView() {
        when (type) {
            "i" -> {

                //val listCategories = arrayListOf<Category>()
                listCategories.add(Category(R.drawable.ic_book, "Educacion"))
                listCategories.add(Category(R.drawable.ic_diet, "Alimentacion"))
                listCategories.add(Category(R.drawable.ic_earth, "Viaje"))
                listCategories.add(Category(R.drawable.ic_fashion, "Vestimenta"))
                listCategories.add(Category(R.drawable.ic_gift, "Regalo"))
                listCategories.add(Category(R.drawable.ic_heartbeat, "Salud"))
                listCategories.add(Category(R.drawable.ic_house, "Hogar"))
                listCategories.add(Category(R.drawable.loanthree, "Prestamo"))
                listCategories.add(Category(R.drawable.ic_taxes, "Impuestos"))
                listCategories.add(Category(R.drawable.ic_laugh, "Diversion"))
                listCategories.add(Category(R.drawable.ic_investing, "Inversion"))


                adapter.updateData(listCategories)
            }

            "e" -> {
                //val listCategories = arrayListOf<Category>()
                listCategories.add(Category(R.drawable.salary, "Sueldo"))
                listCategories.add(Category(R.drawable.loanthree, "Prestamo"))
                listCategories.add(Category(R.drawable.acquisition, "Inversion"))
                listCategories.add(Category(R.drawable.rental, "Alquiler"))

                adapter.updateData(listCategories)
            }
        }
    }

    private fun initListeners() {

    }
}