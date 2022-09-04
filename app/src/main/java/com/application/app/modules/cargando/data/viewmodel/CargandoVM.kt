package com.application.app.modules.cargando.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.cargando.`data`.model.CargandoModel
import org.koin.core.KoinComponent

class CargandoVM : ViewModel(), KoinComponent {
  val cargandoModel: MutableLiveData<CargandoModel> = MutableLiveData(CargandoModel())

  var navArguments: Bundle? = null
}
