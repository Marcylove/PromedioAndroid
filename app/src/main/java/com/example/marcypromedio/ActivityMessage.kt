package com.example.marcypromedio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityMessage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val mensaje = findViewById<TextView>(R.id.textViewShow)

        var miBundle : Bundle? =this.intent.extras

        if(miBundle != null){
            mensaje.text="${miBundle.getString("Resultado")}"
        }

        val btnVolver: Button =findViewById(R.id.buttonVolver)
        btnVolver.setOnClickListener{onClick()}
    }
    private fun onClick(){
        finish()
    }
}