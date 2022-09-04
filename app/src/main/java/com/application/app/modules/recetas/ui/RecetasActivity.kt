package com.application.app.modules.recetas.ui

import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityRecetasBinding
import com.application.app.modules.favoritos.ui.FavoritosActivity
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.recetas.`data`.model.RecetasRowModel
import com.application.app.modules.recetas.`data`.viewmodel.RecetasVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class RecetasActivity : BaseActivity<ActivityRecetasBinding>(R.layout.activity_recetas) {
  private val viewModel: RecetasVM by viewModels<RecetasVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val recetasAdapter = RecetasAdapter(viewModel.recetasList.value?:mutableListOf())
    binding.recyclerRecetas.adapter = recetasAdapter
    recetasAdapter.setOnItemClickListener(
    object : RecetasAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : RecetasRowModel) {
        onClickRecyclerRecetas(view, position, item)
      }
    }
    )
    viewModel.recetasList.observe(this) {
      recetasAdapter.updateData(it)
    }
    binding.recetasVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linear3Tab.setOnClickListener {
      val destIntent = FavoritosActivity.getIntent(this, null)
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

  fun onClickRecyclerRecetas(
    view: View,
    position: Int,
    item: RecetasRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "RECETAS_ACTIVITY"

  }
}
