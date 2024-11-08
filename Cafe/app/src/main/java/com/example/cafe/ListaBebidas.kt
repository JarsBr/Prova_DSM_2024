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
//window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_bebidas)
// Ação para exibir o botão de voltar na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
// Configura o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
// Obtenha a lista de planetas
        bebidas = BebidaData.getBebidas()
// Configura o Adapter e o click listener
        adapter = BebidaAdapter(this, bebidas, onClickPlaneta())
        recyclerView.adapter = adapter
    }

    // Função que retorna o listener para os clicks nos planetas
    private fun onClickPlaneta(): BebidaAdapter.PlanetaOnClickListener {
        return object : BebidaAdapter.PlanetaOnClickListener {
            @SuppressLint("RestrictedApi")
            override fun onClickPlaneta(holder: BebidaAdapter.PlanetasViewHolder?, idx: Int) {
// Verifica se o holder e a lista de planetas não são nulos antes de continuar
                val bebida = bebidas?.getOrNull(idx) ?: return
                val context = holder?.itemView?.context ?: return
// Intent para navegar para a PlanetaActivity
                val intent = Intent(baseContext, BebidaActivity::class.java)
                intent.putExtra("imgBebida", bebida.img)
                intent.putExtra("nomeBebida", bebida.nome)
                intent.putExtra("descBebida", bebida.descricao)

// Inicia a atividade com a animação personalizada
                startActivity(intent)
            }
        }
    }
}