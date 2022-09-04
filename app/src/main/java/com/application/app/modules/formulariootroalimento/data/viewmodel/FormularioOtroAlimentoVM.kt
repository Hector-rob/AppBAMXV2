package com.application.app.modules.formulariootroalimento.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.formulariootroalimento.`data`.model.FormularioOtroAlimentoModel
import com.application.app.modules.formulariootroalimento.`data`.model.Listlabel1RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class FormularioOtroAlimentoVM : ViewModel(), KoinComponent {
  val formularioOtroAlimentoModel: MutableLiveData<FormularioOtroAlimentoModel> =
      MutableLiveData(FormularioOtroAlimentoModel())

  var navArguments: Bundle? = null

  val listlabelList: MutableLiveData<MutableList<Listlabel1RowModel>> =
      MutableLiveData(mutableListOf())
}
