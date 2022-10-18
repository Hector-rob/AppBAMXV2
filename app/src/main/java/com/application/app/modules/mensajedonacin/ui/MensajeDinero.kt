package com.application.app.modules.mensajedonacin.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MensajeDinero : AppCompatActivity() {

    lateinit var menu : LinearLayout
    lateinit var backButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje_dinero)
        var gracias = findViewById<TextView>(R.id.txtGraciasportu)
        val hash= intent.getSerializableExtra("donation") as HashMap<Any,Any>
        gracias.setText("¡Muchas gracias por tu donación " + hash.get("name") + "!")
        subirDatos(hash)

        menu = findViewById(R.id.linear1Tab)
        backButton = findViewById(R.id.imageArrowleft)

        menu.setOnClickListener{
            val intent = Intent(this, MenPrincipalActivity::class.java)
            startActivity(intent)
        }
        backButton.setOnClickListener{
            val intent = Intent(this, MenPrincipalActivity::class.java)
            startActivity(intent)
        }

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


    fun info(view: View){
        val intent = Intent(this, QhacemosActivity::class.java)
        startActivity(intent)
    }
}