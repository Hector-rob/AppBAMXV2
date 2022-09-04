package com.application.app.modules.dinero.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class DineroModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH5: String? = MyApp.getInstance().resources.getString(R.string.lbl_voluntariado)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_con_tu_aportaci)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtH5One: String? = MyApp.getInstance().resources.getString(R.string.msg_quiero_donar_lo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtH5Two: String? = MyApp.getInstance().resources.getString(R.string.msg_ingresa_la_cant)
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
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etBoxValue: String? = null
)
