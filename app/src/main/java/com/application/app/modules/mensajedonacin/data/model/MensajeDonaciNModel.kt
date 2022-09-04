package com.application.app.modules.mensajedonacin.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class MensajeDonaciNModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGraciasportu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_gracias_por_tu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtElBancodeAli: String? =
      MyApp.getInstance().resources.getString(R.string.msg_el_banco_de_ali)
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
