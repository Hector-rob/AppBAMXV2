package com.application.app.modules.formulariodonacin.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.formulariodonacin.`data`.model.FormularioDonaciNModel
import com.application.app.modules.formulariodonacin.`data`.model.ListlabelRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class FormularioDonaciNVM : ViewModel(), KoinComponent {
  val formularioDonaciNModel: MutableLiveData<FormularioDonaciNModel> =
      MutableLiveData(FormularioDonaciNModel())

  var navArguments: Bundle? = null

  val listlabelList: MutableLiveData<MutableList<ListlabelRowModel>> =
      MutableLiveData(mutableListOf())
}
