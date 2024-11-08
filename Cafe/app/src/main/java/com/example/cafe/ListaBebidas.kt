package com.example.cafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListaBebidas : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var bebidas: List<Bebida>? = emptyList()
    private lateinit var adapter: BebidaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_bebidas)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        bebidas = BebidaData.getBebidas()
        adapter = BebidaAdapter(this, bebidas, onClickPlaneta())
        recyclerView.adapter = adapter
    }

    private fun onClickPlaneta(): BebidaAdapter.PlanetaOnClickListener {
        return object : BebidaAdapter.PlanetaOnClickListener {
            @SuppressLint("RestrictedApi")
            override fun onClickPlaneta(holder: BebidaAdapter.PlanetasViewHolder?, idx: Int) {
                val bebida = bebidas?.getOrNull(idx) ?: return
                val context = holder?.itemView?.context ?: return
                val intent = Intent(baseContext, BebidaActivity::class.java)
                intent.putExtra("imgBebida", bebida.img)
                intent.putExtra("nomeBebida", bebida.nome)
                intent.putExtra("descBebida", bebida.descricao)

                startActivity(intent)
            }
        }
    }
}