package com.application.app.modules.seleccinalimentos.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.seleccinalimentos.`data`.model.ListnaranjaRowModel
import com.application.app.modules.seleccinalimentos.`data`.model.ListrectanglefourteenRowModel
import com.application.app.modules.seleccinalimentos.`data`.model.SelecciNAlimentosModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SelecciNAlimentosVM : ViewModel(), KoinComponent {
  val selecciNAlimentosModel: MutableLiveData<SelecciNAlimentosModel> =
      MutableLiveData(SelecciNAlimentosModel())

  var navArguments: Bundle? = null

  val listrectanglefourteenList: MutableLiveData<MutableList<ListrectanglefourteenRowModel>> =
      MutableLiveData(mutableListOf())

  val listnaranjaList: MutableLiveData<MutableList<ListnaranjaRowModel>> =
      MutableLiveData(mutableListOf())
}
