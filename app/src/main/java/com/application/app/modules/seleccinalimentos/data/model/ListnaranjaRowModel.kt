package com.application.app.modules.seleccinalimentos.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class ListnaranjaRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNARANJA: String? = MyApp.getInstance().resources.getString(R.string.lbl_naranja)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupNineteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)

)
