package com.application.app.modules.donaciones.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import com.application.app.modules.voluntariado.ui.VoluntariadoActivity
import kotlin.String
import kotlin.Unit

class DonacionesActivity : BaseActivity<ActivityDonacionesBinding>(R.layout.activity_donaciones) {
  private val viewModel: DonacionesVM by viewModels<DonacionesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.donacionesVM = viewModel
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
      val destIntent = AlimentosActivity.getIntent(this, null)
      startActivity(destIntent)
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
      val destIntent = Intent(this,DineroActivity::class.java)
      startActivity(destIntent)
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
