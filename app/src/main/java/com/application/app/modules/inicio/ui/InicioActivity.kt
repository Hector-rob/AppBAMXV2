package com.application.app.modules.inicio.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityInicioBinding
import com.application.app.modules.inicio.`data`.viewmodel.InicioVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import kotlin.String
import kotlin.Unit

class InicioActivity : BaseActivity<ActivityInicioBinding>(R.layout.activity_inicio) {
  private val viewModel: InicioVM by viewModels<InicioVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.inicioVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageBamxlogoOne.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearInicio.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INICIO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, InicioActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
