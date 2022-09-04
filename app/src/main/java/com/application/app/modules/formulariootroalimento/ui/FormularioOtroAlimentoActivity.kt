package com.application.app.modules.formulariootroalimento.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityFormularioOtroAlimentoBinding
import com.application.app.modules.formulariootroalimento.`data`.model.Listlabel1RowModel
import com.application.app.modules.formulariootroalimento.`data`.viewmodel.FormularioOtroAlimentoVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FormularioOtroAlimentoActivity :
    BaseActivity<ActivityFormularioOtroAlimentoBinding>(R.layout.activity_formulario_otro_alimento)
    {
  private val viewModel: FormularioOtroAlimentoVM by viewModels<FormularioOtroAlimentoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listlabelAdapter = ListlabelAdapter(viewModel.listlabelList.value?:mutableListOf())
    binding.recyclerListlabel.adapter = listlabelAdapter
    listlabelAdapter.setOnItemClickListener(
    object : ListlabelAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listlabel1RowModel) {
        onClickRecyclerListlabel(view, position, item)
      }
    }
    )
    viewModel.listlabelList.observe(this) {
      listlabelAdapter.updateData(it)
    }
    binding.formularioOtroAlimentoVM = viewModel
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
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListlabel(
    view: View,
    position: Int,
    item: Listlabel1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "FORMULARIO_OTRO_ALIMENTO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FormularioOtroAlimentoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
