package com.application.app.modules.inicioone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.inicioone.`data`.model.IniciooneModel
import org.koin.core.KoinComponent

class IniciooneVM : ViewModel(), KoinComponent {
  val iniciooneModel: MutableLiveData<IniciooneModel> = MutableLiveData(IniciooneModel())

  var navArguments: Bundle? = null
}
