package com.application.app.modules.higieneylimpieza.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityHigieneYLimpiezaBinding
import com.application.app.modules.higieneylimpieza.`data`.model.SpinnerListBoxMainModel
import com.application.app.modules.higieneylimpieza.`data`.viewmodel.HigieneYLimpiezaVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import com.application.app.modules.voluntariado.MainActivity
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class HigieneYLimpiezaActivity :
    BaseActivity<ActivityHigieneYLimpiezaBinding>(R.layout.activity_higiene_y_limpieza) {
  private val viewModel: HigieneYLimpiezaVM by viewModels<HigieneYLimpiezaVM>()

  lateinit var categoriaT: String
  //lateinit var productos: EditText
  //lateinit var descripcion: EditText

  override fun onInitialized(): Unit {
    /*
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
     */

    var titulo = findViewById<TextView>(R.id.txtH5)
    titulo.text = "HIGIENE Y LIMPIEZA"

    var menu = findViewById<TextView>(R.id.txtCaption)
    var info = findViewById<TextView>(R.id.txtCaptionOne)

    menu.text = "Menú"
    info.text = "Información"



    val spinner: Spinner = findViewById(R.id.spinnerListBoxMain)
    val categorias = resources.getStringArray(R.array.categorias)

    if (spinner != null) {
      val adapter = ArrayAdapter(
        this,
        android.R.layout.simple_spinner_dropdown_item, categorias
      )
      spinner.adapter = adapter



      spinner.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected( parent: AdapterView<*>,  view: View, position: Int, id: Long) {
          //Toast.makeText( this@HigieneYLimpiezaActivity, getString(R.string.item) + " " +
                    // "" + categorias[position], Toast.LENGTH_SHORT
          //).show()


          //obtener selección de spinner
          categoriaT = categorias[position]

        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
          TODO("Not yet implemented")
        }

      }
    }
  }

  fun returnMenu1(view: View?){
      val intent = Intent(this,MenPrincipalActivity::class.java)
      startActivity(intent)
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
      subir()


      //Cambiar esto si se va mandar a formulario general
      //var categoria = findViewById<EditText>(R.id.higieneCategoriaText).text.toString()


    }
  }

  fun info(view: View){
    val intent = Intent(this, QhacemosActivity::class.java)
    startActivity(intent)
  }

  fun subir(){

    // Intent para mandar al formulario general
    var cantidad = findViewById<EditText>(R.id.higieneCantidadText).text.toString()
    var productos = findViewById<EditText>(R.id.higieneDescripciónText).text.toString()
    val donacion = hashMapOf(
      "categoria" to categoriaT,
      //"categoria" to categoria,
      "cantidad" to cantidad,
      "productos" to productos
    )
    if(cantidad.trim().isNotEmpty() &&
      cantidad.trim().isNotBlank() &&
      productos.trim().isNotEmpty() &&
      productos.trim().isNotBlank() &&
      categoriaT.trim().isNotEmpty() &&
      categoriaT.trim().isNotBlank()) {

      val intent = Intent(this, ResumenHigieneYLimpieza::class.java)
      intent.putExtra( "donation", donacion)
      startActivity(intent)
    }
    else{
      Toast.makeText(this, "Campo faltante", Toast.LENGTH_SHORT).show()
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
