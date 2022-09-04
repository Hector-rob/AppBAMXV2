package com.application.app.modules.menprincipal.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.menprincipal.`data`.model.MenPrincipalModel
import org.koin.core.KoinComponent

class MenPrincipalVM : ViewModel(), KoinComponent {
  val menPrincipalModel: MutableLiveData<MenPrincipalModel> = MutableLiveData(MenPrincipalModel())

  var navArguments: Bundle? = null
}
