package com.application.app.modules.recetas.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.google.firebase.firestore.*


class RecetasActivityIntento : AppCompatActivity(), View.OnClickListener{

  lateinit var recyclerView: RecyclerView
  lateinit var recetaArrayList : ArrayList<Receta>
  lateinit var myAdapter: RecetitaAdapter
  lateinit var db: FirebaseFirestore

  lateinit var filteredList : ArrayList<Receta>


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

  lateinit var searchView: SearchView


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recetas_intento)

      titulo = findViewById(R.id.txtH5)
      titulo.text = "RECETAS"

      recyclerView = findViewById(R.id.recyclerViewRecetas)
      recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
      recyclerView.setHasFixedSize(true)

      recetaArrayList = arrayListOf()

      filteredList = arrayListOf()

      myAdapter = RecetitaAdapter(recetaArrayList, this)
      recyclerView.adapter = myAdapter

      home = findViewById(R.id.linear1Tab)
      info = findViewById(R.id.linearColumnvolume)
      flecha = findViewById(R.id.imageArrowleft)


        /*
      searchView = findViewById(R.id.searchView)
      searchView.clearFocus()
      searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

          override fun onQueryTextSubmit(query: String?): Boolean {
              filterList(query)
              return false;
          }

          override fun onQueryTextChange(newText: String?): Boolean {
              //filterList(newText)
              return true;
          }

      })

         */

      verRecetaFragment = FragmentVerReceta()

      eventChangeListener()

  }

    /*

    private fun filterList(text: String?) {

        for (receta in recetaArrayList){
            if(receta.title.toString().lowercase().contains(text.toString().lowercase())
                or receta.ingredients.toString().lowercase().contains(text.toString().lowercase())){

                filteredList.add(receta)
                Log.wtf("lista", "$filteredList")
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
            //myAdapter.setFilteredList(recetaArrayList)

        }
        else {
            myAdapter.setFilteredList(filteredList)
        }
    }

     */


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

    fun buscar(view: View?){
        val intent = Intent(this, RecetasFiltradasActivity::class.java)
        startActivity(intent)
    }


  companion object {
    const val TAG: String = "RECETAS_ACTIVITY"

  }

    override fun onClick(p0: View?) {
        val position = p0?.let { recyclerView.getChildLayoutPosition(it) }
        Log.wtf("Firestore", "id: $position")
        //Toast.makeText(this, "id: $position", Toast.LENGTH_SHORT).show()
        Log.wtf("Firestore", "lista: ${recetaArrayList[position!!]}")

        val intent = Intent(this, VerRecetasActivity::class.java)
        intent.putExtra("titulo", recetaArrayList[position].title)
        intent.putExtra("ingredientes", recetaArrayList[position].ingredients)
        intent.putExtra("descripcion", recetaArrayList[position].description)

        startActivity(intent)

    }


}




