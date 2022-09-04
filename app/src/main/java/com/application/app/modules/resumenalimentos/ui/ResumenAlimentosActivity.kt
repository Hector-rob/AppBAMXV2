package com.application.app.modules.resumenalimentos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityResumenAlimentosBinding
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.resumenalimentos.`data`.model.Listnaranja1RowModel
import com.application.app.modules.resumenalimentos.`data`.model.Listrectanglefourteen1RowModel
import com.application.app.modules.resumenalimentos.`data`.viewmodel.ResumenAlimentosVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ResumenAlimentosActivity :
    BaseActivity<ActivityResumenAlimentosBinding>(R.layout.activity_resumen_alimentos) {
  private val viewModel: ResumenAlimentosVM by viewModels<ResumenAlimentosVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectanglefourteenAdapter =
    ListrectanglefourteenAdapter(viewModel.listrectanglefourteenList.value?:mutableListOf())
    binding.recyclerListrectanglefourteen.adapter = listrectanglefourteenAdapter
    listrectanglefourteenAdapter.setOnItemClickListener(
    object : ListrectanglefourteenAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      Listrectanglefourteen1RowModel) {
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
      override fun onItemClick(view:View, position:Int, item : Listnaranja1RowModel) {
        onClickRecyclerListnaranja(view, position, item)
      }
    }
    )
    viewModel.listnaranjaList.observe(this) {
      listnaranjaAdapter.updateData(it)
    }
    binding.resumenAlimentosVM = viewModel
  }

  override fun setUpClicks(): Unit {
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
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerListrectanglefourteen(
    view: View,
    position: Int,
    item: Listrectanglefourteen1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListnaranja(
    view: View,
    position: Int,
    item: Listnaranja1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "RESUMEN_ALIMENTOS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ResumenAlimentosActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
