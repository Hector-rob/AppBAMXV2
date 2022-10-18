package com.application.app.modules.recetas.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity

import com.google.firebase.firestore.ktx.toObject

class VerRecetasActivity : AppCompatActivity(){

  lateinit var titulo : TextView

  lateinit var home: LinearLayout
  lateinit var info: LinearLayout
  lateinit var flecha: ImageView

  lateinit var fragmentVerReceta: FragmentVerReceta

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ver_recetas)

      titulo = findViewById(R.id.txtH5)
      titulo.text = "RECETAS"


      home = findViewById(R.id.linear1Tab)
      info = findViewById(R.id.linearColumnvolume)
      flecha = findViewById(R.id.imageArrowleft)

      fragmentVerReceta = FragmentVerReceta()
      val titulo = intent.getStringExtra("titulo").toString()
      val ingredientes = intent.getStringExtra("ingredientes").toString()
      val descripcion = intent.getStringExtra("descripcion").toString()
      val imagen = intent.getStringExtra("imagen").toString()
      val link = intent.getStringExtra("link").toString()

      fragmentVerReceta = FragmentVerReceta.newInstance(titulo, ingredientes, descripcion, imagen, link)
      val transaction = supportFragmentManager.beginTransaction()
      transaction.add(R.id.fragmentContainerView3, fragmentVerReceta)
      transaction.commit()





  }



    fun goHome(view: View?){
        val intent = Intent(this, MenPrincipalActivity::class.java)
        startActivity(intent)
    }

    fun regresar(view: View?){
        finish()
    }

    fun verMas(view: View?){


    }


  companion object {
    const val TAG: String = "RECETAS_ACTIVITY"

  }






}
