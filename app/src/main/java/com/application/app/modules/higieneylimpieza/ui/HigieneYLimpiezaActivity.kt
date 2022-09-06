package com.application.app.modules.higieneylimpieza.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityHigieneYLimpiezaBinding
import com.application.app.modules.higieneylimpieza.`data`.model.SpinnerListBoxMainModel
import com.application.app.modules.higieneylimpieza.`data`.viewmodel.HigieneYLimpiezaVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class HigieneYLimpiezaActivity :
    BaseActivity<ActivityHigieneYLimpiezaBinding>(R.layout.activity_higiene_y_limpieza) {
  private val viewModel: HigieneYLimpiezaVM by viewModels<HigieneYLimpiezaVM>()

  //lateinit var categoria: EditText
  //lateinit var productos: EditText
  //lateinit var descripcion: EditText

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerListBoxMainList.value = mutableListOf(
    SpinnerListBoxMainModel("Limpieza"),
    SpinnerListBoxMainModel("Detergentes"),
    SpinnerListBoxMainModel("Uso personal"),
    //SpinnerListBoxMainModel("Item4"),
    //SpinnerListBoxMainModel("Item5")
    )
    val spinnerListBoxMainAdapter =
    SpinnerListBoxMainAdapter(this,R.layout.spinner_item,viewModel.spinnerListBoxMainList.value?:
    mutableListOf())
    binding.spinnerListBoxMain.adapter = spinnerListBoxMainAdapter
    binding.higieneYLimpiezaVM = viewModel




  }

  fun registerHigieneDonation(){
    var categoria = findViewById<EditText>(R.id.higieneCategoriaText).text.toString()
    var productos = findViewById<EditText>(R.id.higieneCantidadText).text.toString()
    var descripcion = findViewById<EditText>(R.id.higieneDescripciónText).text.toString()
    val donacion = hashMapOf(
      "categoria" to categoria,
      "productos" to productos,
      "descripcion" to descripcion,
    )
    val collection : CollectionReference =
      Firebase.firestore.collection("higieneDonors")

    val taskAdd = collection.add(donacion)
    taskAdd.addOnSuccessListener { documentReference ->
      Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener{error ->
      Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show()

      Log.e("Firestore","error: $error")

    }
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnEnviar.setOnClickListener {

      registerHigieneDonation()

      val destIntent = MensajeDonaciNActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "HIGIENE_Y_LIMPIEZA_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HigieneYLimpiezaActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
