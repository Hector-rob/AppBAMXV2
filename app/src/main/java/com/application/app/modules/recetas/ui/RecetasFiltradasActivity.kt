package com.application.app.modules.recetas.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import com.google.firebase.firestore.*

class RecetasFiltradasActivity : AppCompatActivity(), View.OnClickListener {

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
        setContentView(R.layout.activity_recetas_filtradas)
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

        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(newText: String?): Boolean {
                filterList(newText)

                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //filterList(newText)

                return true;
            }

        })



        eventChangeListener()


        //para guardar recetas
        sharedPrefs = getSharedPreferences(ARCHIVO_PREFS, Context.MODE_PRIVATE)

        //Editar sharedpref
        val editor: SharedPreferences.Editor = sharedPrefs.edit()

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

    }

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


    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("recipes").orderBy("title", Query.Direction.ASCENDING).
        addSnapshotListener(object : EventListener<QuerySnapshot> {
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

    fun cancelar(view: View?){
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
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
        //Log.wtf("Firestore", "lista: ${filteredList[position!!]}")

        val intent = Intent(this, VerRecetasActivity::class.java)
        intent.putExtra("titulo", filteredList[position!!].title)
        intent.putExtra("ingredientes", filteredList[position!!].ingredients)
        intent.putExtra("descripcion", filteredList[position!!].description)
        intent.putExtra("imagen", filteredList[position!!].image)
        intent.putExtra("link", filteredList[position!!].link)


        startActivity(intent)

    }


}