package com.application.app.modules.resumenalimentos.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class Listnaranja1RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNARANJA: String? = MyApp.getInstance().resources.getString(R.string.lbl_naranja)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFortyFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)

)
