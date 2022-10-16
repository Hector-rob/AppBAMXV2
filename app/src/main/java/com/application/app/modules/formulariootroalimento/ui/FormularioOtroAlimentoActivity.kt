package com.application.app.modules.formulariootroalimento.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityFormularioOtroAlimentoBinding
import com.application.app.modules.formulariootroalimento.`data`.model.Listlabel1RowModel
import com.application.app.modules.formulariootroalimento.`data`.viewmodel.FormularioOtroAlimentoVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FormularioOtroAlimentoActivity :
    BaseActivity<ActivityFormularioOtroAlimentoBinding>(R.layout.activity_formulario_otro_alimento)
    {
  private val viewModel: FormularioOtroAlimentoVM by viewModels<FormularioOtroAlimentoVM>()
      private lateinit var fruitAndVeggies : String
      private lateinit var nonPerishable : String

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    binding.formularioOtroAlimentoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnDonar.setOnClickListener {
      val foodDonations = hashMapOf(
        "frutasYVegetales" to binding.frutasVerdurasInput.text.toString(),
        "noPerecederos" to binding.noPerecederosInput.text.toString())
      val intent = Intent(this, FormularioComun::class.java)
      intent.putExtra("donation",foodDonations)
      startActivity(intent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }
      fun info(view: View){
        val intent = Intent(this, QhacemosActivity::class.java)
        startActivity(intent)
      }

  companion object {
    const val TAG: String = "FORMULARIO_OTRO_ALIMENTO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FormularioOtroAlimentoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
