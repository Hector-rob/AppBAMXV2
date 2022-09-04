package com.application.app.modules.voluntariado.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.voluntariado.`data`.model.VoluntariadoModel
import com.application.app.modules.voluntariado.`data`.model.VoluntariadoRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class VoluntariadoVM : ViewModel(), KoinComponent {
  val voluntariadoModel: MutableLiveData<VoluntariadoModel> = MutableLiveData(VoluntariadoModel())

  var navArguments: Bundle? = null

  val voluntariadoList: MutableLiveData<MutableList<VoluntariadoRowModel>> =
      MutableLiveData(mutableListOf())
}
