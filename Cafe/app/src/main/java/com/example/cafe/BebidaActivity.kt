package com.example.cafe

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BebidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bebida)
// Ação para exibir o botão de voltar na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val imgBebida = intent.getIntExtra("imgBebida", 0)
        val nomeBebida = intent.getStringExtra("nomeBebida")
        val descBebida = intent.getStringExtra("descBebida")
        if (imgBebida > 0) {
            val img = findViewById<View>(R.id.img) as ImageView
            img.setImageResource(imgBebida)
            val nome = findViewById<View>(R.id.tNome) as TextView
            nome.text = nomeBebida
            val text = findViewById<View>(R.id.descricao) as TextView
            text.setText(descBebida)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}