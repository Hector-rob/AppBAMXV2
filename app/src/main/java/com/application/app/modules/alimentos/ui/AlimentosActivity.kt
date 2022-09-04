package com.application.app.modules.alimentos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityAlimentosBinding
import com.application.app.modules.alimentos.`data`.viewmodel.AlimentosVM
import com.application.app.modules.donaciones.ui.DonacionesActivity
import com.application.app.modules.formulariootroalimento.ui.FormularioOtroAlimentoActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.seleccinalimentos.ui.SelecciNAlimentosActivity
import kotlin.String
import kotlin.Unit

class AlimentosActivity : BaseActivity<ActivityAlimentosBinding>(R.layout.activity_alimentos) {
  private val viewModel: AlimentosVM by viewModels<AlimentosVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.alimentosVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linear3ContainedB1.setOnClickListener {
      val destIntent = SelecciNAlimentosActivity.getIntent(this, null)
      startActivity(destIntent)
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

  companion object {
    const val TAG: String = "ALIMENTOS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AlimentosActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
