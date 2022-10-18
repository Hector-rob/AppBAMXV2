package com.application.app.modules.higieneylimpieza.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.application.app.FormularioComun
import com.application.app.R

class ResumenHigieneYLimpieza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_higiene_ylimpieza)

        var cant = findViewById<EditText>(R.id.cantHigiene)
        var nombre = findViewById<EditText>(R.id.nombreHigiene)
        var categoria = findViewById<EditText>(R.id.tipoHigiene)
        var hashMap = intent.getSerializableExtra("donation") as HashMap<String?, Any?>?
        var btn = findViewById<Button>(R.id.btn)


        categoria.setText("Categoría: " + " " + hashMap!!["categoria"])
        cant.setText("Cantidad de productos: " + " " + hashMap!!["cantidad"])
        nombre.setText("Productos: " + " " + hashMap!!["productos"])


         btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FormularioComun::class.java)
            intent.putExtra("donation", hashMap)
            startActivity(intent)

        })
    }

    fun back(view: View?) {
        finish()
    }

    fun ir(view: View, hashMap: HashMap<String?,Any?>) {
        val intent = Intent(this, FormularioComun::class.java)
        intent.putExtra("donation", hashMap)
        startActivity(intent)
    }

}



