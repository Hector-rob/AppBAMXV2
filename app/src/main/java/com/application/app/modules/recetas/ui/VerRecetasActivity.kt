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

class VerRecetasActivity : AppCompatActivity(), View.OnClickListener{

  //private val viewModel: RecetasVM by viewModels<RecetasVM>()

  //Ya alv hay que hacerlo como en la act 4

  lateinit var recyclerView: RecyclerView
  lateinit var recetaArrayList : ArrayList<Receta>
  lateinit var myAdapter: RecetitaAdapter
  lateinit var db: FirebaseFirestore

  /*
  lateinit var llm: LinearLayoutManager

  lateinit var titulos: ArrayList<String>
  lateinit var ingredientes: ArrayList<String>

   */

  lateinit var titulo : TextView

  lateinit var home: LinearLayout
  lateinit var info: LinearLayout
  lateinit var flecha: ImageView


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ver_recetas)

      titulo = findViewById(R.id.txtH5)
      titulo.text = "RECETAS"

      recyclerView = findViewById(R.id.recyclerViewRecetas)
      recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
      recyclerView.setHasFixedSize(true)

      recetaArrayList = arrayListOf()

      myAdapter = RecetitaAdapter(recetaArrayList)
      recyclerView.adapter = myAdapter

      home = findViewById(R.id.linear1Tab)
      info = findViewById(R.id.linearColumnvolume)
      flecha = findViewById(R.id.imageArrowleft)

      eventChangeListener()

      /*

      titulos = ArrayList()
      ingredientes = ArrayList()

      recyclerView = findViewById(R.id.recyclerViewRecetas)


    val llm = LinearLayoutManager(this)
    llm.orientation = LinearLayoutManager.VERTICAL

      val glm = GridLayoutManager(this, 2)

      recyclerView.layoutManager = llm


    db = FirebaseFirestore.getInstance()
    //recetitaArrayList = arrayListOf(Recetita())
    //recetitaAdapter = RecetitaAdapter(this, recetitaArrayList)

    //recyclerView.adapter = recetitaAdapter;

      val coleccion = Firebase.firestore.collection("recipes")
      val queryTask = coleccion.get()

      queryTask.addOnSuccessListener { result ->
          //algo sencillo - recorrer datos
          Toast.makeText(
              this,
              "Query exitoso",
              Toast.LENGTH_SHORT
          ).show()

          var cont = 0
          for(documentoActual in result) {
              cont +=1
              //Log.wtf("Firestore", "${documentoActual.data.size}")

              titulos.add(documentoActual.data["title"].toString())
              ingredientes.add(documentoActual.data["ingredients"].toString())


          }
          Log.wtf("Firestore", "$titulos, $ingredientes")
          val adapter = RecetitaAdapter(titulos, ingredientes, this)
          recyclerView.layoutManager = llm
          recyclerView.adapter = adapter


          Log.wtf("Firestore", "$llm")




      }.addOnFailureListener{ error ->
          Log.wtf("Firestore", "Error en query: $error")
      }


       */






  }


  private fun eventChangeListener() {


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

  override fun onClick(row: View?) {
    TODO("Not yet implemented")
  }




}
