package com.application.app.modules.buscador.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class BuscadorModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH5: String? = MyApp.getInstance().resources.getString(R.string.lbl_recetas2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtH5One: String? = MyApp.getInstance().resources.getString(R.string.lbl_recetas2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRecetaCounterFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_receta_5)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRecetaCounterFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_receta_6)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaption: String? = MyApp.getInstance().resources.getString(R.string.lbl_men)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaptionOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_filtrar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaptionTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_favoritos)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etInputFieldValue: String? = null
)
