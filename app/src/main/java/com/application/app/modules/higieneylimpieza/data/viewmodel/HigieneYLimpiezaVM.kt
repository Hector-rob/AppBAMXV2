package com.application.app.modules.higieneylimpieza.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.higieneylimpieza.`data`.model.HigieneYLimpiezaModel
import com.application.app.modules.higieneylimpieza.`data`.model.SpinnerListBoxMainModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class HigieneYLimpiezaVM : ViewModel(), KoinComponent {
  val higieneYLimpiezaModel: MutableLiveData<HigieneYLimpiezaModel> =
      MutableLiveData(HigieneYLimpiezaModel())

  var navArguments: Bundle? = null

  val spinnerListBoxMainList: MutableLiveData<MutableList<SpinnerListBoxMainModel>> =
      MutableLiveData()
}
