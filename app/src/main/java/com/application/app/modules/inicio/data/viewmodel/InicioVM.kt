package com.application.app.modules.inicio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.inicio.`data`.model.InicioModel
import org.koin.core.KoinComponent

class InicioVM : ViewModel(), KoinComponent {
  val inicioModel: MutableLiveData<InicioModel> = MutableLiveData(InicioModel())

  var navArguments: Bundle? = null
}
