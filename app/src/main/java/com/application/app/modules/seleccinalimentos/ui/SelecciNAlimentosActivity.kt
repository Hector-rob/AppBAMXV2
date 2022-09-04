package com.application.app.modules.seleccinalimentos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivitySelecciNAlimentosBinding
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.resumenalimentos.ui.ResumenAlimentosActivity
import com.application.app.modules.seleccinalimentos.`data`.model.ListnaranjaRowModel
import com.application.app.modules.seleccinalimentos.`data`.model.ListrectanglefourteenRowModel
import com.application.app.modules.seleccinalimentos.`data`.viewmodel.SelecciNAlimentosVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SelecciNAlimentosActivity :
    BaseActivity<ActivitySelecciNAlimentosBinding>(R.layout.activity_selecci_n_alimentos) {
  private val viewModel: SelecciNAlimentosVM by viewModels<SelecciNAlimentosVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectanglefourteenAdapter =
    ListrectanglefourteenAdapter(viewModel.listrectanglefourteenList.value?:mutableListOf())
    binding.recyclerListrectanglefourteen.adapter = listrectanglefourteenAdapter
    listrectanglefourteenAdapter.setOnItemClickListener(
    object : ListrectanglefourteenAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      ListrectanglefourteenRowModel) {
        onClickRecyclerListrectanglefourteen(view, position, item)
      }
    }
    )
    viewModel.listrectanglefourteenList.observe(this) {
      listrectanglefourteenAdapter.updateData(it)
    }
    val listnaranjaAdapter =
    ListnaranjaAdapter(viewModel.listnaranjaList.value?:mutableListOf())
    binding.recyclerListnaranja.adapter = listnaranjaAdapter
    listnaranjaAdapter.setOnItemClickListener(
    object : ListnaranjaAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListnaranjaRowModel) {
        onClickRecyclerListnaranja(view, position, item)
      }
    }
    )
    viewModel.listnaranjaList.observe(this) {
      listnaranjaAdapter.updateData(it)
    }
    binding.selecciNAlimentosVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.imageImageFiftyOne.setOnClickListener {
      val destIntent = ResumenAlimentosActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnDonar.setOnClickListener {
      val destIntent = MensajeDonaciNActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListrectanglefourteen(
    view: View,
    position: Int,
    item: ListrectanglefourteenRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListnaranja(
    view: View,
    position: Int,
    item: ListnaranjaRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SELECCI_N_ALIMENTOS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelecciNAlimentosActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
