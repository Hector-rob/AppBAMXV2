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
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DineroFormulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinero_formulario)
    }

    fun subirDatos(view: View?){
        var nombre = findViewById<EditText>(R.id.nombreFormularioComunInputDinero).text.toString()
        var apellidoP = findViewById<EditText>(R.id.APFormularioComunInputDinero).text.toString()
        var apellidoM = findViewById<EditText>(R.id.AMFormularioComunInputDinero).text.toString()
        var correo = findViewById<EditText>(R.id.CorreoFormularioComunInputDinero).text.toString()
        var numero = findViewById<EditText>(R.id.NumeroFormularioComunInputDinero).text.toString()
        var dinero = findViewById<EditText>(R.id.DineroForm).text.toString()
        //var hash = intent.getStringArrayExtra("foodDonations")
        val donor = hashMapOf(
            "name" to nombre,
            "firstLN" to apellidoP,
            "secondLN" to apellidoM,
            "mail" to correo,
            "number" to numero,
            "dinero" to dinero

        )
        /*
        val collection : CollectionReference =
            Firebase.firestore.collection("donors")

        val taskAdd = collection.add(donor)
        taskAdd.addOnSuccessListener { documentReference ->
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{error ->
            Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()

            Log.e("Firestore","error: $error")

        }
        */
        val intent = Intent(this, Stripe::class.java)
        intent.putExtra("dinero",dinero.toInt())
        intent.putExtra("donor",donor)
        startActivity(intent)


    }

    fun returnMenu(view: View?){
        val intent = Intent(this, MenPrincipalActivity::class.java)
        startActivity(intent)
    }
}