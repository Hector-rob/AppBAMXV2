package com.application.app.modules.recetas.ui


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

import android.content.Intent


class RecetasActivityIntento : AppCompatActivity(), View.OnClickListener{

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

  lateinit var verRecetaFragment: FragmentVerReceta


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recetas_intento)

      titulo = findViewById(R.id.txtH5)
      titulo.text = "RECETAS"

      recyclerView = findViewById(R.id.recyclerViewRecetas)
      recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
      recyclerView.setHasFixedSize(true)

      recetaArrayList = arrayListOf()

      myAdapter = RecetitaAdapter(recetaArrayList, this)
      recyclerView.adapter = myAdapter

      home = findViewById(R.id.linear1Tab)
      info = findViewById(R.id.linearColumnvolume)
      flecha = findViewById(R.id.imageArrowleft)

      verRecetaFragment = FragmentVerReceta()




      eventChangeListener()

  }




    private fun eventChangeListener() {
      db = FirebaseFirestore.getInstance()
      db.collection("recipes").orderBy("title", Query.Direction.ASCENDING).
              addSnapshotListener(object : EventListener<QuerySnapshot>{
                  override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                      if (error != null){
                          return
                      }

                      for(dc: DocumentChange in value?.documentChanges!!){
                          if (dc.type == DocumentChange.Type.ADDED){
                              recetaArrayList.add(dc.document.toObject(Receta::class.java))
                              //Log.wtf("Firestore", "$recetaArrayList")
                          }
                      }

                      myAdapter.notifyDataSetChanged()
                  }
              })




  }



    fun goHome(view: View?){
        val intent = Intent(this, MenPrincipalActivity::class.java)
        startActivity(intent)
    }

    fun regresar(view: View?){
        finish()
    }


  companion object {
    const val TAG: String = "RECETAS_ACTIVITY"

  }

    override fun onClick(p0: View?) {
        val position = p0?.let { recyclerView.getChildLayoutPosition(it) }
        Log.wtf("Firestore", "id: $position")
        Toast.makeText(this, "id: $position", Toast.LENGTH_SHORT).show()
        Log.wtf("Firestore", "lista: ${recetaArrayList[position!!]}")

        val intent = Intent(this, VerRecetasActivity::class.java)
        intent.putExtra("titulo", recetaArrayList[position].title)
        intent.putExtra("ingredientes", recetaArrayList[position].ingredients)
        intent.putExtra("descripcion", recetaArrayList[position].description)

        startActivity(intent)

    }


}


