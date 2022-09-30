package com.application.app.modules.recetas.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityRecetasBinding
import com.application.app.modules.favoritos.ui.FavoritosActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.recetas.data.model.RecetasRowModel
import com.application.app.modules.recetas.data.viewmodel.RecetasVM
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.firestore.*
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

      fragmentVerReceta = FragmentVerReceta.newInstance(titulo, ingredientes, descripcion)
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
