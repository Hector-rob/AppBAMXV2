package com.application.app.modules.seleccinalimentos.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class SelecciNAlimentosModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH5: String? = MyApp.getInstance().resources.getString(R.string.lbl_fruta_y_verdura2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaption: String? = MyApp.getInstance().resources.getString(R.string.lbl_men)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaptionOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_information)

)
