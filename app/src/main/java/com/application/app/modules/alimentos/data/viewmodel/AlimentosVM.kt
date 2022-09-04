package com.application.app.modules.alimentos.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.alimentos.`data`.model.AlimentosModel
import org.koin.core.KoinComponent

class AlimentosVM : ViewModel(), KoinComponent {
  val alimentosModel: MutableLiveData<AlimentosModel> = MutableLiveData(AlimentosModel())

  var navArguments: Bundle? = null
}
