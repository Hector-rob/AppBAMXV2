package com.application.app.modules.cargando.ui

import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityCargandoBinding
import com.application.app.modules.cargando.`data`.viewmodel.CargandoVM
import kotlin.String
import kotlin.Unit

class CargandoActivity : BaseActivity<ActivityCargandoBinding>(R.layout.activity_cargando) {
  private val viewModel: CargandoVM by viewModels<CargandoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.cargandoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "CARGANDO_ACTIVITY"

  }
}
