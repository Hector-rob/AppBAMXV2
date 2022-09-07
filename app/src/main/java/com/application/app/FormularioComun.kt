package com.application.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FormularioComun : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_comun)
    }

    fun subirDatos(view: View?){
        var nombre = findViewById<EditText>(R.id.nombreFormularioComunInput).text.toString()
        var apellidoP = findViewById<EditText>(R.id.APFormularioComunInput).text.toString()
        var apellidoM = findViewById<EditText>(R.id.AMFormularioComunInput).text.toString()
        var correo = findViewById<EditText>(R.id.CorreoFormularioComunInput).text.toString()
        var numero = findViewById<EditText>(R.id.CorreoFormularioComunInput).text.toString()
        //var hash = intent.getStringArrayExtra("foodDonations")
        var hash = intent.getSerializableExtra("foodDonations")
        val donor = hashMapOf(
            "name" to nombre,
            "firstLN" to apellidoP,
            "secondLN" to apellidoM,
            "mail" to correo,
            "number" to numero,
            "donation" to hash
        )
        val collection : CollectionReference =
            Firebase.firestore.collection("donors")

        val taskAdd = collection.add(donor)
        taskAdd.addOnSuccessListener { documentReference ->
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{error ->
            Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()

            Log.e("Firestore","error: $error")

        }


    }

}