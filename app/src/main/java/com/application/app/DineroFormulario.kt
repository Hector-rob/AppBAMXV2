package com.application.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class DineroFormulario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinero_formulario)
    }

    fun subirDatosaa(view: View?){

        var nombre = findViewById<EditText>(R.id.nombreFormularioComunInputDinero).text.toString()
        var apellidoP = findViewById<EditText>(R.id.APFormularioComunInputDinero).text.toString()
        var apellidoM = findViewById<EditText>(R.id.AMFormularioComunInputDinero).text.toString()
        var correo = findViewById<EditText>(R.id.CorreoFormularioComunInputDinero).text.toString()
        var numero = findViewById<EditText>(R.id.NumeroFormularioComunInputDinero).text.toString()
        var dinero = findViewById<EditText>(R.id.DineroForm).text.toString()

        if (nombre.trim().isNotEmpty() &&
            nombre.trim().isNotBlank() &&
            apellidoP.trim().isNotEmpty() &&
            apellidoP.trim().isNotBlank() &&
            apellidoM.trim().isNotEmpty() &&
            apellidoM.trim().isNotBlank() &&
            correo.trim().isNotEmpty() &&
            correo.trim().isNotBlank() &&
            numero.trim().isNotEmpty() &&
            numero.trim().isNotBlank() &&
            dinero.trim().isNotEmpty() &&
            dinero.trim().isNotBlank()) {

            if(!correo.contains("@") || !(correo.contains(".com") || correo.contains(".mx")
                        || correo.contains(".org"))){
                Toast.makeText(this, "Correo inválido", Toast.LENGTH_SHORT).show()
            }
            else if(numero.length != 10){
                Toast.makeText(this, "El número telefónico tiene que ser de 10 números", Toast.LENGTH_SHORT).show()
            }
            else {
                val donor = hashMapOf(
                    "name" to nombre,
                    "firstLN" to apellidoP,
                    "secondLN" to apellidoM,
                    "mail" to correo,
                    "number" to numero,
                    "dinero" to dinero

                )
                val intent = Intent(this, Stripe::class.java)
                intent.putExtra("dinero", dinero.toInt())
                intent.putExtra("donation", donor)
                startActivity(intent)
            }

            // your code
        } else {
            Toast.makeText(this, "Campo faltante", Toast.LENGTH_SHORT).show()
        }
    }

    fun returnMenu(view: View?){
        val intent = Intent(this, MenPrincipalActivity::class.java)
        startActivity(intent)
    }

    fun back(view: View?){
        finish()
    }

    fun info(view: View){
        val intent = Intent(this, QhacemosActivity::class.java)
        startActivity(intent)
    }


}