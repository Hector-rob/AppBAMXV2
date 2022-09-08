package com.application.app.modules.iniciozero.ui

import android.content.Intent

import android.os.Handler
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityIniciozeroBinding
import com.application.app.modules.inicioone.ui.IniciooneActivity
import com.application.app.modules.iniciozero.data.viewmodel.IniciozeroVM


class IniciozeroActivity : BaseActivity<ActivityIniciozeroBinding>(R.layout.activity_iniciozero) {
  private val viewModel: IniciozeroVM by viewModels<IniciozeroVM>()


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.iniciozeroVM = viewModel

    Handler().postDelayed(Runnable {
      val i = Intent(this, IniciooneActivity::class.java)
      startActivity(i)
      finish()
    }, 2000)
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
