package com.application.app.modules.dinero.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.dinero.`data`.model.DineroModel
import org.koin.core.KoinComponent

class DineroVM : ViewModel(), KoinComponent {
  val dineroModel: MutableLiveData<DineroModel> = MutableLiveData(DineroModel())

  var navArguments: Bundle? = null
}
