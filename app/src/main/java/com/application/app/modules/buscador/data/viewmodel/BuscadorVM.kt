package com.application.app.modules.buscador.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.buscador.`data`.model.BuscadorModel
import com.application.app.modules.buscador.`data`.model.BuscadorRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class BuscadorVM : ViewModel(), KoinComponent {
  val buscadorModel: MutableLiveData<BuscadorModel> = MutableLiveData(BuscadorModel())

  var navArguments: Bundle? = null

  val buscadorList: MutableLiveData<MutableList<BuscadorRowModel>> =
      MutableLiveData(mutableListOf())
}
