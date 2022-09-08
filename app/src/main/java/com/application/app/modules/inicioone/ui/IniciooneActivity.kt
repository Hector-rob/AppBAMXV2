package com.application.app.modules.inicioone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityIniciooneBinding
import com.application.app.modules.inicio.ui.InicioActivity
import com.application.app.modules.inicioone.`data`.viewmodel.IniciooneVM
import kotlin.String
import kotlin.Unit

class IniciooneActivity : BaseActivity<ActivityIniciooneBinding>(R.layout.activity_inicioone) {
  private val viewModel: IniciooneVM by viewModels<IniciooneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.iniciooneVM = viewModel

    Handler().postDelayed(Runnable {
      val i = Intent(this, InicioActivity::class.java)
      startActivity(i)
      finish()
    }, 1000)
  }

  override fun setUpClicks(): Unit {
    binding.linearInicioOne.setOnClickListener {
      val destIntent = InicioActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INICIOONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, IniciooneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
