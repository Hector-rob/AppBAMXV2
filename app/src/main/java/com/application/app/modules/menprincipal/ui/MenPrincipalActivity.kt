package com.application.app.modules.menprincipal.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityMenPrincipalBinding
import com.application.app.modules.donaciones.ui.DonacionesActivity
import com.application.app.modules.menprincipal.`data`.viewmodel.MenPrincipalVM
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import com.application.app.modules.recetas.ui.RecetasActivityIntento
import kotlin.String
import kotlin.Unit

class MenPrincipalActivity :
    BaseActivity<ActivityMenPrincipalBinding>(R.layout.activity_men_principal) {
  private val viewModel: MenPrincipalVM by viewModels<MenPrincipalVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.menPrincipalVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnDonaciones.setOnClickListener {
      val destIntent = DonacionesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnquHacemos.setOnClickListener {
      val destIntent = QhacemosActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.btnRecetas.setOnClickListener {
      val destIntent = Intent(this, RecetasActivityIntento::class.java)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MEN_PRINCIPAL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MenPrincipalActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
