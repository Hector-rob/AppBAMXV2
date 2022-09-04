package com.application.app.modules.voluntariado.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityVoluntariadoBinding
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.voluntariado.`data`.model.VoluntariadoRowModel
import com.application.app.modules.voluntariado.`data`.viewmodel.VoluntariadoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class VoluntariadoActivity :
    BaseActivity<ActivityVoluntariadoBinding>(R.layout.activity_voluntariado) {
  private val viewModel: VoluntariadoVM by viewModels<VoluntariadoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val voluntariadoAdapter =
    VoluntariadoAdapter(viewModel.voluntariadoList.value?:mutableListOf())
    binding.recyclerVoluntariado.adapter = voluntariadoAdapter
    voluntariadoAdapter.setOnItemClickListener(
    object : VoluntariadoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : VoluntariadoRowModel) {
        onClickRecyclerVoluntariado(view, position, item)
      }
    }
    )
    viewModel.voluntariadoList.observe(this) {
      voluntariadoAdapter.updateData(it)
    }
    binding.voluntariadoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnEnviar.setOnClickListener {
      val destIntent = MensajeDonaciNActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerVoluntariado(
    view: View,
    position: Int,
    item: VoluntariadoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "VOLUNTARIADO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, VoluntariadoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
