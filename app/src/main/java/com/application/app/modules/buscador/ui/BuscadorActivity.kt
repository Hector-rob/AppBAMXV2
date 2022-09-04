package com.application.app.modules.buscador.ui

import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityBuscadorBinding
import com.application.app.modules.buscador.`data`.model.BuscadorRowModel
import com.application.app.modules.buscador.`data`.viewmodel.BuscadorVM
import com.application.app.modules.favoritos.ui.FavoritosActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class BuscadorActivity : BaseActivity<ActivityBuscadorBinding>(R.layout.activity_buscador) {
  private val viewModel: BuscadorVM by viewModels<BuscadorVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val buscadorAdapter = BuscadorAdapter(viewModel.buscadorList.value?:mutableListOf())
    binding.recyclerBuscador.adapter = buscadorAdapter
    buscadorAdapter.setOnItemClickListener(
    object : BuscadorAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : BuscadorRowModel) {
        onClickRecyclerBuscador(view, position, item)
      }
    }
    )
    viewModel.buscadorList.observe(this) {
      buscadorAdapter.updateData(it)
    }
    binding.buscadorVM = viewModel
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
    binding.linear3Tab.setOnClickListener {
      val destIntent = FavoritosActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerBuscador(
    view: View,
    position: Int,
    item: BuscadorRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "BUSCADOR_ACTIVITY"

  }
}
