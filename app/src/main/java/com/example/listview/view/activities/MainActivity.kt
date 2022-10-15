package com.example.listview.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding
import com.example.listview.model.Anime
import com.example.listview.view.adapters.Adaptador

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = ArrayList<Anime>()

        for (i in 1..10) {
            val animeTmp = Anime(i.toLong(), "Título $i", "Tipo $i", "Fecha $i")
            datos.add(animeTmp)
        }

        datos.add(Anime(1234, "Naruto", "Drama", "13/10/1995"))

        val adaptador = Adaptador(this@MainActivity, datos)

        binding.lv.adapter = adaptador

        binding.lv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this,
                "Se hizo clic en el elemento con el ID $id, en la posición $position",
                Toast.LENGTH_LONG
            ).show()

            // para obtener data del elemento seleccionado, podemos usar el adapter

            val seleccionado = parent.adapter.getItem(position) as Anime

            Toast.makeText(
                this,
                "El título del Anime seleccionado es: ${seleccionado.titulo}",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}