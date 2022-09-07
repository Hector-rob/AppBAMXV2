package com.application.app.modules.formulariodonacin.ui

import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityFormularioDonaciNBinding
import com.application.app.modules.formulariodonacin.`data`.model.ListlabelRowModel
import com.application.app.modules.formulariodonacin.`data`.viewmodel.FormularioDonaciNVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FormularioDonaciNActivity :
    BaseActivity<ActivityFormularioDonaciNBinding>(R.layout.activity_formulario_donaci_n) {

  private val viewModel: FormularioDonaciNVM by viewModels<FormularioDonaciNVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listlabelAdapter = ListlabelAdapter(viewModel.listlabelList.value?:mutableListOf())
    binding.recyclerListlabel.adapter = listlabelAdapter

    listlabelAdapter.setOnItemClickListener(
    object : ListlabelAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListlabelRowModel) {
        onClickRecyclerListlabel(view, position, item)
      }
    }
    )
    viewModel.listlabelList.observe(this) {
      listlabelAdapter.updateData(it)
    }
    binding.formularioDonaciNVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnDonar.setOnClickListener {
      val destIntent = MensajeDonaciNActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListlabel(
    view: View,
    position: Int,
    item: ListlabelRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "FORMULARIO_DONACI_N_ACTIVITY"

  }
}
