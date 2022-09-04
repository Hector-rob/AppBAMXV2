package com.application.app.modules.mensajedonacin.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.mensajedonacin.`data`.model.MensajeDonaciNModel
import org.koin.core.KoinComponent

class MensajeDonaciNVM : ViewModel(), KoinComponent {
  val mensajeDonaciNModel: MutableLiveData<MensajeDonaciNModel> =
      MutableLiveData(MensajeDonaciNModel())

  var navArguments: Bundle? = null
}
