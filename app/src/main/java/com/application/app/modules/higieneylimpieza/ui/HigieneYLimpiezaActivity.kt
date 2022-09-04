package com.application.app.modules.higieneylimpieza.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityHigieneYLimpiezaBinding
import com.application.app.modules.higieneylimpieza.`data`.model.SpinnerListBoxMainModel
import com.application.app.modules.higieneylimpieza.`data`.viewmodel.HigieneYLimpiezaVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import kotlin.String
import kotlin.Unit

class HigieneYLimpiezaActivity :
    BaseActivity<ActivityHigieneYLimpiezaBinding>(R.layout.activity_higiene_y_limpieza) {
  private val viewModel: HigieneYLimpiezaVM by viewModels<HigieneYLimpiezaVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerListBoxMainList.value = mutableListOf(
    SpinnerListBoxMainModel("Item1"),
    SpinnerListBoxMainModel("Item2"),
    SpinnerListBoxMainModel("Item3"),
    SpinnerListBoxMainModel("Item4"),
    SpinnerListBoxMainModel("Item5")
    )
    val spinnerListBoxMainAdapter =
    SpinnerListBoxMainAdapter(this,R.layout.spinner_item,viewModel.spinnerListBoxMainList.value?:
    mutableListOf())
    binding.spinnerListBoxMain.adapter = spinnerListBoxMainAdapter
    binding.higieneYLimpiezaVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnEnviar.setOnClickListener {
      val destIntent = MensajeDonaciNActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "HIGIENE_Y_LIMPIEZA_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HigieneYLimpiezaActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
