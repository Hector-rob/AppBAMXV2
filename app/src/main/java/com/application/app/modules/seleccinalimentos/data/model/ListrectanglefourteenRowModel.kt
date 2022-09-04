package com.application.app.modules.seleccinalimentos.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class ListrectanglefourteenRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtZero: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMANZANA: String? = MyApp.getInstance().resources.getString(R.string.lbl_manzana)

)
