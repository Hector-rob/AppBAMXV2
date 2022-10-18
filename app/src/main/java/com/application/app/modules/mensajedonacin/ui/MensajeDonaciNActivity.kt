package com.application.app.modules.mensajedonacin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityMensajeDonaciNBinding
import com.application.app.modules.donaciones.ui.DonacionesActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.`data`.viewmodel.MensajeDonaciNVM
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import kotlin.String
import kotlin.Unit

class MensajeDonaciNActivity :
    BaseActivity<ActivityMensajeDonaciNBinding>(R.layout.activity_mensaje_donaci_n) {
  private val viewModel: MensajeDonaciNVM by viewModels<MensajeDonaciNVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.mensajeDonaciNVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linear3Tab.setOnClickListener{
      val intent = Intent(this, QhacemosActivity::class.java)
      startActivity(intent)
    }
  }

  companion object {
    const val TAG: String = "MENSAJE_DONACI_N_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MensajeDonaciNActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
