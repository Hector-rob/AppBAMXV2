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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FormularioComun : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_comun)
    }

    fun subirDatos(view: View?){
        val nombre = findViewById<EditText>(R.id.nombreFormularioComunInput).text.toString()
        val apellidoP = findViewById<EditText>(R.id.APFormularioComunInput).text.toString()
        val apellidoM = findViewById<EditText>(R.id.AMFormularioComunInput).text.toString()
        val correo = findViewById<EditText>(R.id.CorreoFormularioComunInput).text.toString()
        val numero = findViewById<EditText>(R.id.NumeroFormularioComunInput).text.toString()
        //var hash = intent.getStringArrayExtra("foodDonations")
        var hash = intent.getSerializableExtra("donation")
        if (nombre.trim().isNotEmpty() &&
            nombre.trim().isNotBlank() &&
            apellidoP.trim().isNotEmpty() &&
            apellidoP.trim().isNotBlank() &&
            apellidoM.trim().isNotEmpty() &&
            apellidoM.trim().isNotBlank() &&
            correo.trim().isNotEmpty() &&
            correo.trim().isNotBlank() &&
            numero.trim().isNotEmpty() &&
            numero.trim().isNotBlank()) {

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
                    "donation" to hash

                )
                val collection: CollectionReference =
                    Firebase.firestore.collection("donors")

                val taskAdd = collection.add(donor)
                taskAdd.addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener { error ->
                    Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()

                    Log.e("Firestore", "error: $error")

                }
                val intent = Intent(this, MensajeDonaciNActivity::class.java)
                startActivity(intent)
            }
         } else {
            Toast.makeText(this, "Campo faltante", Toast.LENGTH_SHORT).show()
         }
}
    fun back(view: View?){
        finish()
    }

    fun info(view: View){
        val intent = Intent(this, QhacemosActivity::class.java)
        startActivity(intent)
    }

    fun returnMenu(view: View?){
        val intent = Intent(this,MenPrincipalActivity::class.java)
        startActivity(intent)
    }

}