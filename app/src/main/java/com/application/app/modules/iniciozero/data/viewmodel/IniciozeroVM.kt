package com.application.app.modules.iniciozero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.iniciozero.`data`.model.IniciozeroModel
import org.koin.core.KoinComponent

class IniciozeroVM : ViewModel(), KoinComponent {
  val iniciozeroModel: MutableLiveData<IniciozeroModel> = MutableLiveData(IniciozeroModel())

  var navArguments: Bundle? = null
}
