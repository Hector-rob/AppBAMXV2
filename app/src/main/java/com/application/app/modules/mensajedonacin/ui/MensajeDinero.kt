package com.application.app.modules.mensajedonacin.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.application.app.R
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MensajeDinero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje_dinero)
    }

    fun subirDatos(view: View?){

        val hash= intent.getSerializableExtra("hashMap") as HashMap<String, String>?


        val collection : CollectionReference =
            Firebase.firestore.collection("donors")

        val taskAdd = collection.add(hash)

        val intent = Intent(this,MensajeDonaciNActivity::class.java)
        startActivity(intent)


    }
}