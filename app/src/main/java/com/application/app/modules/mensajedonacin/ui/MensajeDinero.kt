package com.application.app.modules.mensajedonacin.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MensajeDinero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje_dinero)
        var gracias = findViewById<TextView>(R.id.txtGraciasportu)
        val hash= intent.getSerializableExtra("donation") as HashMap<Any,Any>
        gracias.setText("¡Muchas gracias por tu donación " + hash.get("name") + "!")
        subirDatos(hash)

    }


    fun returnMenu2(){
            val intent = Intent(this, MenPrincipalActivity::class.java)
            startActivity(intent)
    }


    fun subirDatos(hash: HashMap<Any,Any>){

        val collection : CollectionReference =
            Firebase.firestore.collection("donors")
        collection.add(hash)

    /*taskAdd.addOnSuccessListener { documentReference ->
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{error ->
            Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()
            Log.e("Firestore","error: $error")
        }

         */

       /* val taskAdd = hash?.let { collection.add(it) }
        taskAdd?.addOnSuccessListener { documentReference ->
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
        }?.addOnFailureListener{error ->
            Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()

            Log.e("Firestore","error: $error")

        }
        */


    }
}