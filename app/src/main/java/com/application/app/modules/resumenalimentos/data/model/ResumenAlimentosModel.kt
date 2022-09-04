package com.application.app.modules.resumenalimentos.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class ResumenAlimentosModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH5: String? = MyApp.getInstance().resources.getString(R.string.lbl_fruta_y_verdura2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadlineSix: String? = MyApp.getInstance().resources.getString(R.string.lbl_resumen)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOVERLINE: String? = MyApp.getInstance().resources.getString(R.string.lbl_producto)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeight: String? = MyApp.getInstance().resources.getString(R.string.lbl_manzana_1_kg)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOVERLINEOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_producto)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeightOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_durazno_1_kg)
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
