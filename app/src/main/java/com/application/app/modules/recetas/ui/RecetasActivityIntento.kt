package com.application.app.modules.recetas.ui

import android.os.Bundle
import android.util.Log
import android.view.View
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
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RecetasActivityIntento : AppCompatActivity(), View.OnClickListener{

  //private val viewModel: RecetasVM by viewModels<RecetasVM>()

  //Ya alv hay que hacerlo como en la act 4

  lateinit var recyclerView: RecyclerView
  lateinit var recetitaArrayList : ArrayList<Recetita>
  //lateinit var recetitaAdapter: RecetitaAdapter
  lateinit var db: FirebaseFirestore

  lateinit var llm: LinearLayoutManager

  lateinit var titulos: ArrayList<String>
  lateinit var ingredientes: ArrayList<String>


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recetas_intento)

    recyclerView = findViewById(R.id.recyclerViewRecetas)


      titulos = ArrayList()
      ingredientes = ArrayList()


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

          for(documentoActual in result) {
              //Log.wtf("Firestore", "${documentoActual.id} ${documentoActual.data}")

              titulos.add(documentoActual.data["title"].toString())
              ingredientes.add(documentoActual.data["ingredients"].toString())

              Log.wtf("Firestore", "${documentoActual.data["title"].toString()} , ${documentoActual.data["ingredients"].toString()}")

              //aquí vamos a hacer dos arrays, tipo la actividad 4
              /*
          uno para titulos
          otro para ingredientes
          luego se lo pasas a recetita adapter(la modificas como perrito adapter)
           */
              //recetitaArrayList.add(Recetita(documentoActual.data.get("title").toString(), documentoActual.data.get("ingredients").toString()))
              //Log.wtf("Firestore", "$recetitaArrayList")

          }

          /*
          val adapter = RecetitaAdapter(titulos, ingredientes, this)
          recyclerView.layoutManager = llm
          recyclerView.adapter = adapter

           */




      }.addOnFailureListener{ error ->
          Log.wtf("Firestore", "Error en query: $error")
      }

      val adapter = RecetitaAdapter(titulos, ingredientes, this)
      recyclerView.layoutManager = llm
      recyclerView.adapter = adapter



  }


  fun eventChangeListener() {

    /*
      val coleccion = Firebase.firestore.collection("recipes")
    val queryTask = coleccion.get()

    queryTask.addOnSuccessListener { result ->
        //algo sencillo - recorrer datos
        Toast.makeText(
          this,
          "Query exitoso",
          Toast.LENGTH_SHORT
        ).show()

        for(documentoActual in result) {
          //Log.wtf("Firestore", "${documentoActual.id} ${documentoActual.data}")

              titulos.add(documentoActual.data["title"].toString())
              ingredientes.add(documentoActual.data["ingredients"].toString())

            Log.wtf("Firestore", "$titulos , $ingredientes")

              //aquí vamos a hacer dos arrays, tipo la actividad 4
              /*
          uno para titulos
          otro para ingredientes
          luego se lo pasas a recetita adapter(la modificas como perrito adapter)
           */
              //recetitaArrayList.add(Recetita(documentoActual.data.get("title").toString(), documentoActual.data.get("ingredients").toString()))
              //Log.wtf("Firestore", "$recetitaArrayList")

            }

        val adapter = RecetitaAdapter(titulos, ingredientes, this)
        recyclerView.layoutManager = llm
        recyclerView.adapter = adapter




    }.addOnFailureListener{ error ->
      Log.wtf("Firestore", "Error en query: $error")
    }


    //otra cosa


     */





  }


  companion object {
    const val TAG: String = "RECETAS_ACTIVITY"

  }

  override fun onClick(row: View?) {
    TODO("Not yet implemented")
  }
}
