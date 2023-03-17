package com.example.marcypromedio

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var nombre: EditText?=null
    var materia: EditText?=null
    var nota1: EditText?=null
    var nota2: EditText?=null
    var nota3: EditText?=null
    var resultado: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre=findViewById(R.id.editName)
        materia=findViewById(R.id.editMateria)
        nota1=findViewById(R.id.editNote1)
        nota2=findViewById(R.id.editNote2)
        nota3=findViewById(R.id.editNote3)
        resultado=findViewById(R.id.textViewResult)

        val miBoton1:Button = findViewById(R.id.button1)
        miBoton1.setOnClickListener{onClick(1)}

        val miBoton2:Button = findViewById(R.id.button2)
        miBoton2.setOnClickListener{onClick(2)}

    }

    private fun onClick(boton : Int) {

        var result=""

        when(boton){
            1 -> {
                val nombre: String = nombre?.text.toString()
                val materia: String = materia?.text.toString()
                val nota1: Double = nota1?.text.toString().toDouble()
                val nota2: Double = nota2?.text.toString().toDouble()
                val nota3: Double = nota3?.text.toString().toDouble()

                var promedio: Double = (nota1 + nota2 + nota3) / 3

                if (nota1 > 5 || nota1 < 0 || nota2 > 5 || nota2 < 0 || nota3 > 5 || nota3 < 0) {
                    result="El Valor Ingresado En La Nota Es Invalido"
                    resultado!!.setTextColor(Color.RED)
                } else if (promedio >= 3.5) {
                    result="${nombre} Gano la Materia ${materia} con una Nota de ${promedio}"
                    resultado!!.setTextColor(Color.GREEN)
                } else{
                    result="${nombre} perdio la Materia ${materia} con una Nota de ${promedio}"
                    resultado!!.setTextColor(Color.RED)
                }

                resultado?.text = result

            }
            2 ->{
                val intent = Intent (this,ActivityMessage::class.java)
                val miBundle : Bundle=Bundle()
                miBundle.putString("Resultado", resultado!!.text.toString())
                intent.putExtras(miBundle)
                startActivity(intent)
            }

        }
    }

}