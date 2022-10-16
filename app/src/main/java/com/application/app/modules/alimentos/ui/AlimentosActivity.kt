package com.application.app.modules.alimentos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.*
import com.application.app.modules.alimentos.`data`.viewmodel.AlimentosVM
import com.application.app.modules.donaciones.ui.DonacionesActivity
import com.application.app.modules.formulariootroalimento.ui.FormularioOtroAlimentoActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.seleccinalimentos.ui.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class AlimentosActivity : BaseActivity<ActivityAlimentosBinding>(R.layout.activity_alimentos) {
  private val viewModel: AlimentosVM by viewModels<AlimentosVM>()

  private var productsCanasta = HashMap<String, String>()
  private var productsFrutas = HashMap<String, String>()
  private var productsEmbutidos = HashMap<String, String>()
  private var productsAbarrotes = HashMap<String, String>()
  private var canastaKeys = arrayListOf<String>()
  private var frutasKeys = arrayListOf<String>()
  private var embutidosKeys = arrayListOf<String>()
  private var abarrotesKeys = arrayListOf<String>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.alimentosVM = viewModel

    readDBCanasta("CanastaBasica")
    readDBFrutas("Frutas")
    readDBEmbutidos("Embutidos")
    readDBAbarrotes("Abarrotes")

  }

  override fun setUpClicks(): Unit {
    binding.btnCanastaBasica.setOnClickListener {
      val intent = Intent(this, CanastaBasicaActivity::class.java)
      intent.putExtra("CanastaBasica", productsCanasta)
      intent.putExtra("keys", canastaKeys)
      startActivity(intent)
    }
    binding.btnFrutasYVerduras.setOnClickListener {
      val intent = Intent(this, FrutasYVerdurasActivity::class.java)
      intent.putExtra("Frutas", productsFrutas)
      intent.putExtra("keys", frutasKeys)
      startActivity(intent)
    }
    binding.btnEmbutidosYLacteos.setOnClickListener {
      val intent = Intent(this, EmbutidosActivity::class.java)
      intent.putExtra("Embutidos", productsEmbutidos)
      intent.putExtra("keys", embutidosKeys)
      startActivity(intent)
    }
    binding.btnAbarrotes.setOnClickListener {
      val intent = Intent(this, AbarrotesActivity::class.java)
      intent.putExtra("Abarrotes", productsAbarrotes)
      intent.putExtra("keys", abarrotesKeys)
      startActivity(intent)
    }

    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnOtro.setOnClickListener {
      val destIntent = FormularioOtroAlimentoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = DonacionesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  private fun readDBCanasta(collection: String) {
    val db = Firebase.firestore

    val productos = db.collection(collection)

    productos
      .get()
      .addOnSuccessListener { documents ->
        for ((i, document) in documents.withIndex()) {
          //get the image link and name from firebase
          val name = document.id
          var img : String = document.data.toString()
          img = img.subSequence(7, img.length - 1).toString()
          canastaKeys.add(name)
          productsCanasta[name] = img
          Log.e("Firestore", "img = $img")
          Log.e("Firestore", "name = ${canastaKeys[i]}")


          Log.e("Firestore", "${document.id} => ${document.data}")
        }
      }
      .addOnFailureListener { exception ->
        Log.e("Firestore", "Error getting documents: ", exception)
      }
  }

  private fun readDBFrutas(collection: String) {
    val db = Firebase.firestore

    val productos = db.collection(collection)

    productos
      .get()
      .addOnSuccessListener { documents ->
        for ((i, document) in documents.withIndex()) {
          //get the image link and name from firebase
          val name = document.id
          var img : String = document.data.toString()
          img = img.subSequence(7, img.length - 1).toString()
          frutasKeys.add(name)
          productsFrutas[name] = img
          Log.e("Firestore", "img = $img")
          Log.e("Firestore", "name = ${frutasKeys[i]}")


          Log.e("Firestore", "${document.id} => ${document.data}")
        }
      }
      .addOnFailureListener { exception ->
        Log.e("Firestore", "Error getting documents: ", exception)
      }
  }

  private fun readDBEmbutidos(collection: String) {
    val db = Firebase.firestore

    val productos = db.collection(collection)

    productos
      .get()
      .addOnSuccessListener { documents ->
        for ((i, document) in documents.withIndex()) {
          //get the image link and name from firebase
          val name = document.id
          var img : String = document.data.toString()
          img = img.subSequence(7, img.length - 1).toString()
          embutidosKeys.add(name)
          productsEmbutidos[name] = img
          Log.e("Firestore", "img = $img")
          Log.e("Firestore", "name = ${embutidosKeys[i]}")

          Log.e("Firestore", "${document.id} => ${document.data}")
        }
      }
      .addOnFailureListener { exception ->
        Log.e("Firestore", "Error getting documents: ", exception)
      }
  }

  private fun readDBAbarrotes(collection: String) {
    val db = Firebase.firestore

    val productos = db.collection(collection)

    productos
      .get()
      .addOnSuccessListener { documents ->
        for ((i, document) in documents.withIndex()) {
          //get the image link and name from firebase
          val name = document.id
          var img : String = document.data.toString()
          img = img.subSequence(7, img.length - 1).toString()
          abarrotesKeys.add(name)
          productsAbarrotes[name] = img
          Log.e("Firestore", "img = $img")
          Log.e("Firestore", "name = ${abarrotesKeys[i]}")

          Log.e("Firestore", "${document.id} => ${document.data}")
        }
      }
      .addOnFailureListener { exception ->
        Log.e("Firestore", "Error getting documents: ", exception)
      }
  }

  companion object {
    const val TAG: String = "ALIMENTOS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AlimentosActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
