package com.application.app.modules.voluntariado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.application.app.R
import com.application.app.databinding.ActivityMainBinding
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    fun registerTimeDonation(view: View?){
        var nameT = findViewById<EditText>(R.id.nameT).text.toString()
        var firstLNT = findViewById<EditText>(R.id.nameT).text.toString()
        var secondLNT = findViewById<EditText>(R.id.nameT).text.toString()
        var mailT = findViewById<EditText>(R.id.nameT).text.toString()
        var numberT = findViewById<EditText>(R.id.nameT).text.toString()
        var stateT = findViewById<EditText>(R.id.nameT).text.toString()
        var suburbT = findViewById<EditText>(R.id.nameT).text.toString()
        val donor = hashMapOf(
            "name" to nameT,
            "firstLN" to firstLNT,
            "secondLN" to secondLNT,
            "mail" to mailT,
            "number" to numberT,
            "state" to stateT,
            "suburb" to suburbT
        )
        val collection : CollectionReference =
            Firebase.firestore.collection("timeDonors")

        val taskAdd = collection.add(donor)
        taskAdd.addOnSuccessListener { documentReference ->
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{error ->
            Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()

            Log.e("Firestore","error: $error")

        }
    }

    fun getDonor(view: View?){
        var one = findViewById<TextView>(R.id.textView)
        var name = findViewById<EditText>(R.id.nameT).text.toString()

        val db = FirebaseFirestore.getInstance()
        db.collection("timeDonors")
            .whereEqualTo("name","$name")
            .get()
            .addOnCompleteListener{
                val result: StringBuffer = StringBuffer()
                if(it.isSuccessful){
                    for(document in it.result!!){
                        result.append(document.data.getValue("name")).append(" ")
                            .append(document.data.getValue("firstLN")).append("\n\n")
                    }
                    one.setText(result)
                }
            }
    }

}