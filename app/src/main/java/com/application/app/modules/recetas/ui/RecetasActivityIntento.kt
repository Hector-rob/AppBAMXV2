package com.application.app.modules.recetas.ui


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import com.application.app.modules.qhacemos.ui.QhacemosActivity
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

  var ARCHIVO_PREFS = "preferencias.prefs"
    private lateinit var sharedPrefs: SharedPreferences



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

      //para guardar recetas
      sharedPrefs = getSharedPreferences(ARCHIVO_PREFS, Context.MODE_PRIVATE)

      //Editar sharedpref
      val editor: SharedPreferences.Editor = sharedPrefs.edit()



      eventChangeListener()



      //borar sharedprefs
      //editor.clear()
      //editor.commit()


      // ********** NOTA **********
      // Receta 1 y 2 solo se deben correr una vez para que se guarden en sharedprefs
      // Después de eso, comentar esa sección de código
      // En caso de cagarla y seguir corriéndolo, borrar sharedprefs y volver a correr 1 una vez

      //Comienzo de código comentado

      /*
      //receta 1
      val titulito1 = "Ensalada de nopales"
      val ingredientitos1 = "Nopales, jitomate, cebolla, cilantro"
      val descripcioncita1 = "Cortar los nopales, hervirlos con sal por 15 min. Añadir jitomate, cilantro, cebolla picada y sal al gusto. Revolver"
      val imagen1="https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2017/10/consejosparaprepararlamejorensaladadenopales.jpg"
      val link1="https://www.youtube.com/watch?v=2ZfK3nKYzMw"
      editor.putString("title: " + (0).toString(), titulito1)
      editor.putString("ingredients: " + (0).toString(), ingredientitos1)
      editor.putString("description: " + (0).toString(), descripcioncita1)
      editor.putString("image: " + (0).toString(), imagen1)
      editor.putString("link: " + (0).toString(), link1)
      //editor.commit()

      //Receta2
      val titulito2 = "Caldo de res"
      val ingredientitos2 = "Carne de res, chayotes, papas, zanahorias, elotes, col"
      val descripcioncita2 = "Condimentar la carne de res con una pizca de sal.\n" +
              "Calentar el aceite en una olla a fuego alto.\n" +
              "Poner el hueso y la carne en la olla y dorar.\n" +
              "Agregar agua, una cucharada pequeña de sal y el ajo en polvo. Cocínar a fuego alto para hervir el agua.\n" +
              "Reducir el calor y cocina a fuego lento. Remover constantemente la espuma que se acumula en la parte superior. Cocinar la carne por aproximadamente 1 hora.\n" +
              "Agregar las papas y siguir cocinando a fuego lento aproximadamente 10 minutos.\n" +
              "Agregar la col, el elote, la calabaza verde, las zanahorias. Y seguir cocinando a fuego lento por otros 5-10 minutos."
      val imagen2="https://www.lamichoacanameatmarket.com/wp-content/uploads/2017/05/Receta-de-Caldo-de-Res-900x600.jpg"
      val link2="https://www.youtube.com/watch?v=LDketd0gQx4"
      editor.putString("title: " + (1).toString(), titulito2)
      editor.putString("ingredients: " + (1).toString(), ingredientitos2)
      editor.putString("description: " + (1).toString(), descripcioncita2)
      editor.putString("image: " + (1).toString(), imagen2)
      editor.putString("link: " + (1).toString(), link2)
      editor.commit()

       */

      //Fin de código comentado


      var titulito: String
      var ingredientitos:String
      var descripcioncita:String
      var imagencita:String
      var linkcito:String


      for (i in 0 until 2) {
          titulito = sharedPrefs.getString("title: $i", "No hay datos").toString()
          ingredientitos = sharedPrefs.getString("ingredients: $i", "No hay datos").toString()
          descripcioncita = sharedPrefs.getString("description: $i", "No hay datos").toString()
          imagencita = sharedPrefs.getString("image: $i", "No hay datos").toString()
          linkcito = sharedPrefs.getString("link: $i", "No hay datos").toString()
          recetaArrayList.add(Receta(titulito, ingredientitos, descripcioncita, imagencita, linkcito))
      }


      verRecetaFragment = FragmentVerReceta()

      //eventChangeListener()

      recetaArrayList.sortBy { it.title }

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

    fun info(view: View){
        val intent = Intent(this, QhacemosActivity::class.java)
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
        intent.putExtra("imagen", recetaArrayList[position].image)
        intent.putExtra("link", recetaArrayList[position].link)

        startActivity(intent)

    }


}




