package com.example.cafe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listview)

        val cadapio = resources.getStringArray(R.array.cadapio)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cadapio)
        listView.adapter = adapter

        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, idx: Int, id: Long) {
        val item = parent?.getItemAtPosition(idx).toString()
        if (item == "Bebidas") {
            val intent = Intent(this, ListaBebidas::class.java)
            startActivity(intent)
        } else if (item == "Comida"){
            Toast.makeText(this, "Ainda não servimos Comida", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ainda não trabalhamos com mercearia", Toast.LENGTH_SHORT).show()
        }
    }
}

