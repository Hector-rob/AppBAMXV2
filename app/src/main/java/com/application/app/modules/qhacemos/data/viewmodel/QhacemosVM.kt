package com.application.app.modules.qhacemos.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.qhacemos.`data`.model.QhacemosModel
import org.koin.core.KoinComponent

class QhacemosVM : ViewModel(), KoinComponent {
  val qhacemosModel: MutableLiveData<QhacemosModel> = MutableLiveData(QhacemosModel())

  var navArguments: Bundle? = null
}
