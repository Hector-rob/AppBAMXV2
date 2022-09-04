package com.application.app.modules.resumenalimentos.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.resumenalimentos.`data`.model.Listnaranja1RowModel
import com.application.app.modules.resumenalimentos.`data`.model.Listrectanglefourteen1RowModel
import com.application.app.modules.resumenalimentos.`data`.model.ResumenAlimentosModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ResumenAlimentosVM : ViewModel(), KoinComponent {
  val resumenAlimentosModel: MutableLiveData<ResumenAlimentosModel> =
      MutableLiveData(ResumenAlimentosModel())

  var navArguments: Bundle? = null

  val listrectanglefourteenList: MutableLiveData<MutableList<Listrectanglefourteen1RowModel>> =
      MutableLiveData(mutableListOf())

  val listnaranjaList: MutableLiveData<MutableList<Listnaranja1RowModel>> =
      MutableLiveData(mutableListOf())
}
