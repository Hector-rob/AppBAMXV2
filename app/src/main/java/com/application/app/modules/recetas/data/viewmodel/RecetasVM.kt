package com.application.app.modules.recetas.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.recetas.`data`.model.RecetasModel
import com.application.app.modules.recetas.`data`.model.RecetasRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class RecetasVM : ViewModel(), KoinComponent {
  val recetasModel: MutableLiveData<RecetasModel> = MutableLiveData(RecetasModel())

  var navArguments: Bundle? = null

  val recetasList: MutableLiveData<MutableList<RecetasRowModel>> = MutableLiveData(mutableListOf())
}
