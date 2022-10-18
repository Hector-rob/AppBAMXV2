package com.application.app.modules.donaciones.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.application.app.DineroFormulario
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityDonacionesBinding
import com.application.app.modules.alimentos.ui.AlimentosActivity
import com.application.app.modules.dinero.ui.DineroActivity
import com.application.app.modules.donaciones.`data`.viewmodel.DonacionesVM
import com.application.app.modules.donaciones.ui.DonacionesActivity.Companion.getIntent
import com.application.app.modules.higieneylimpieza.ui.HigieneYLimpiezaActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.seleccinalimentos.ui.FoodDonations
import com.application.app.modules.voluntariado.ui.VoluntariadoActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class DonacionesActivity : BaseActivity<ActivityDonacionesBinding>(R.layout.activity_donaciones) {
  private val viewModel: DonacionesVM by viewModels<DonacionesVM>()

  private var products = HashMap<String, String>()
  private var keys = arrayListOf<String>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.donacionesVM = viewModel

    readDB("CanastaBasica")
    readDB("Frutas")
    readDB("Embutidos")
    readDB("Abarrotes")

  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnAlimentos.setOnClickListener {
      val intent = Intent(this, FoodDonations::class.java)
      intent.putExtra("Products", products)
      intent.putExtra("keys", keys)
      startActivity(intent)
    }
    binding.btnTiempo.setOnClickListener {
      val destIntent = VoluntariadoActivity.getIntent(this, null)
      val intent = Intent(this, FormularioComun::class.java)
      intent.putExtra("donation","Persona voluntaria")
      startActivity(intent)
    }
    binding.btnHigieneLimpiezaOne.setOnClickListener {
      val destIntent = HigieneYLimpiezaActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnDinero.setOnClickListener {
      val destIntent = Intent(this,DineroFormulario::class.java)
      startActivity(destIntent)
    }
  }

  private fun readDB(collection: String){
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
          keys.add(name)
          products[name] = img
          Log.e("Firestore", "img = $img")
          Log.e("Firestore", "name = ${keys[i]}")


          Log.e("Firestore", "${document.id} => ${document.data}")
        }
      }
      .addOnFailureListener { exception ->
        Log.e("Firestore", "Error getting documents: ", exception)
      }
  }

  companion object {
    const val TAG: String = "DONACIONES_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DonacionesActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
