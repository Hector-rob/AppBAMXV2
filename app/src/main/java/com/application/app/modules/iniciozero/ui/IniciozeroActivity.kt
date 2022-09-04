package com.application.app.modules.iniciozero.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityIniciozeroBinding
import com.application.app.modules.inicioone.ui.IniciooneActivity
import com.application.app.modules.iniciozero.`data`.viewmodel.IniciozeroVM
import kotlin.String
import kotlin.Unit

class IniciozeroActivity : BaseActivity<ActivityIniciozeroBinding>(R.layout.activity_iniciozero) {
  private val viewModel: IniciozeroVM by viewModels<IniciozeroVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.iniciozeroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearInicioZero.setOnClickListener {
      val destIntent = IniciooneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INICIOZERO_ACTIVITY"

  }
}
