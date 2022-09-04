package com.application.app.modules.donaciones.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.donaciones.`data`.model.DonacionesModel
import org.koin.core.KoinComponent

class DonacionesVM : ViewModel(), KoinComponent {
  val donacionesModel: MutableLiveData<DonacionesModel> = MutableLiveData(DonacionesModel())

  var navArguments: Bundle? = null
}
